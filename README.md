Darklight Nova Core Issue: Hosts
====================================

Issue for [Darklight Nova Core](https://github.com/darklight-studios/darklight-nova-core)

### Function
The Hosts issue checks that bad entries in the hosts file have been removed

### Use

1. Download the latest version from the [releases](https://github.com/darklight-studios/HostsIssue/releases/) section
2. Add DNCHostsIssue.jar to your DNC build path
3. Create a `HostsIssue hostsIssue = new HostsIssue()`
4. Set the issue's bad entries: `hostsIssue.setBadEntries(new String[] { "127.0.0.1 lol.com" });`
5. Add `hostsIssue` issues array in CoreEngine
6. Start DNC!

### License
[GPLv3](LICENSE)

### Contributors
[@IsaacJG](https://github.com/IsaacJG)
