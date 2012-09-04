call-for-paper
==============

A simple call for paper application.

The "call-for-paper-webapp" module works with the TomEE JEE 6 server (1.0.0 Plus version, because Apache TomEE Plus delivers all that is in the Web Profile, plus EJB Full, Java EE Connector Architecture, JMS, JAX-WS and and JAX-RS).

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