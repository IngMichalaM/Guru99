# Guru99
- Final project for the Prague/Dublin Coding school, course Automated testing 
- Dublin Coding School: https://prahacoding.cz/courses/automation-testing-course-praha-coding-school/

## About
Smoke test for the Guru99 bank app (https://demo.guru99.com/v4/)

## Comments
Taking into account that I had no prior Java knowledge, this is quite a good result. 

## Technologies 
- Java 
- selenium webdriver
- JUnit 5
- Maven 

## Details
- There are two separate methods, one for creating a new customer and a second one for a new account (package "pages"). These two are called whenever a test method needs a new customer ID or account ID.
- The input data for individual dashboards are stored in the package "test_data".
- The locators for items on the dashboards are stored in the package "locators".
- Test are in "test_classes".

## How to run
Run the test_classess/SmokeTest as JUnit Test.

## Problems
Random variables are random only for the first call, later on they are all equal to this one. The problem is probably with the initialisation of the random number.

## What I have learned 
- Java syntax (I like Matlab and Python much much more)
- Creating a new java project
- What is Maven project good for
- Use of JUnit 5 for testing
- Page Object Model idea
- Make a printscreen during the test execution
- That a method can accept and return a value
