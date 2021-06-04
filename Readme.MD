## Table of Contents

- [Intro](#intro)
- [Prerequisites](#prerequisites)
- [Execution](#execution)
- [Known Issues](#known-issues)

## Intro
**WordPress-Homework** is the Test Automation Framework that was assembled using Java, Selenium Web Driver, TestNG, Maven. **WordPress-Homework** runs front end testing (test cases, automated scenarios, etc.) on specific application. Framework configured and tested to support Google Chrome, Mozilla Firefox browsers.
## Prerequisites
- JAVA JDK 1.8
> [Set up of Java | Maven environment](http://www.tutorialspoint.com/maven/maven_environment_setup.htm)
- MAVEN 3 or HIGHER 
> [Maven in 5 minutes](http://maven.apache.org/guides/getting-started/maven-in-five-minutes.html)  
> [Maven installation on different OSs](https://www.baeldung.com/install-maven-on-windows-linux-mac)

## Execution
- Clone **WordPress-Homework** repository
- `src/test/java/resources/credentials.properties` contains credentials, url, browser type properties.
- Navigate to root directory (where pom.xml is located)

- To run default default `testng.xml` file , execute command below 

```
mvn clean test
```
- To run only specific class/test, execute commands below 

```
mvn test -Dtest=<.java file name>
```

## Known Issues
