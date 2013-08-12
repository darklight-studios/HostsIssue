package com.isaacjg.darklight.issues;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import com.ijg.darklight.sdk.core.Issue;

/*
 * HostsIssue - An Issue for Darklight Nova Core
 * Copyright © 2013 Isaac Grant
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

/**
 * HostsIssue is an Issue for Darklight Nova Core that checks if
 * bad entries are present in the hosts file
 * 
 * @author Isaac Grant
 */

public class HostsIssue extends Issue {

	private File hostsFile = new File("C:\\Windows\\System32\\drivers\\etc\\hosts");
	private String[] badEntries;
	
	public HostsIssue() {
		super("Hosts", "The hosts file has been cleansed of its impurities");
	}

	public void setBadEntries(String[] badEntries) {
		this.badEntries = badEntries;
	}
	
	@Override
	public boolean isFixed() {
		try {
			Scanner hosts = new Scanner(hostsFile);
			while (hosts.hasNextLine()) {
				String next = hosts.nextLine();
				for (String badEntry : badEntries) {
					if (badEntry.equals(next.trim())) {
						hosts.close();
						return false;
					}
				}
			}
			hosts.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return true;
	}

}
