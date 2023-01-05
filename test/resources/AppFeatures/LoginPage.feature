
Feature: Login page feature

Background: 
	Given User is on login page

Scenario: Login page title
	When User gets the title of the page
	Then Page title should be "Login - My Store"
	
Scenario: Forgot password link
	Then Forgot your password link should be displayed

@smoke	
Scenario: Login with correct credentials
	When User enters the valid username "zainahmadkhanpro@gmail.com"
	And User enters the correct password "selenium@123"
	And User clicks on the Signin button
	Then User gets the title of the page
	And Page title should be "My account - My Store"