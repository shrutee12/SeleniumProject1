Feature: Oracle Create User

Scenario: To Check user with valid details

Given Chrome is Opened & Login Page is displayed
When User enters "sys" & "India@123"
And Click on Login button
Then Home Page Should Display
When User clicks on Admin
And Database user & Click on Create
And User enters following details
	| UserName | Password | CPassword |
	| dtl99 					 | dtl99					 | dtl99							|
And Click on Create
Then User created Message should display