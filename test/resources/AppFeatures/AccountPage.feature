Feature: Account Page Feature

Background:
	Given User has already logged in to the application
				|username|password|
				|zainahmadkhanpro@gmail.com|selenium@123|

Scenario: Accounts page title
	Given User is on account page
	When User gets the title of the page
	Then Page title should be "My account - My Store"
	
Scenario: Account section count
	Given User is on account page
	Then User gets the account sections
	|ORDER HISTORY AND DETAILS|
	|MY CREDIT SLIPS|
	|MY ADDRESSES|
	|MY PERSONAL INFORMATION|
	|MY WISHLISTS|
	|Home|
	And account section count should be 6