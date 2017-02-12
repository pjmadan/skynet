# skynet
Generic BDD Automation Framework using Cucumber, Selenium, Appium and Docker

This project provides the generic Blueprint for an Automation Project structure that can be used to automate web applications,mobile applications and webservices using a BDD approach to testing. The following framework libraries are used
1) Cucumber for providing BDD automation
2) Gherkin for providing BDD syntax
3) Selenium Webdriver for automating websites and webapplications
4) Appium to automate mobile web and native mobile applications for IOS and Android
5) Maven Surefire to provide multithreading capabilties.Separate Runner class for each feature using tag filters. 
6) Exisiting Github project to provide pretty colored reports
7) Generic HTTP GET and POST clients for testing webservices

The following design patterns are used by the Framework to make it extensible and easy to maintain
1) Facade pattern to run against multiple execution platforms such as SauceLabs, AWS Device Farm, Perfecto
2) PageObject pattern for web pages and mobile screens
3) Picocontainers that provides Dependency Injection for sharing objects with step instances
4) Configuration file for Locator properties

The whole framework can be run on a docker container using the image which is a generic docker image with Java, Maven pre installed.
