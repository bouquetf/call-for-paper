call-for-paper
==============

A simple call for paper application.

Installation instructions
=========================

First, start a BOS-5.7.2 studio and import the process found in processes folder.
Set initial value for conf_* process variables for your environment.
Hit run and click on the link to the user experience in the top right corner.

Then, build the project with the command
```
mvm package
```

Finally, copy the war file which can be found in call-for-paper-webapp/target to the webapp folder of a tomEE 1.0.0 Plus
webapp folder.
Configure the following resources in the tomee.xml configuration file : 
```xml
<Resource id="cfpDatabase" type="DataSource">
  JdbcDriver org.hsqldb.jdbcDriver
  JdbcUrl jdbc:hsqldb:mem:cfpDB
  UserName sa
  Password
  JtaManaged true
</Resource>
```
Run tomEE by launching bin/startup.{bat|sh} script.