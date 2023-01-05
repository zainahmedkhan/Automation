
Feature: Place order from webshop

Background:
	Given User navigates to the webshop URL
	Then The title of the page is "Shopping Cart"
	Then User accepts the cookies
	And User enters the valid email address
	Then User clicks the continue to payment button
	When User navigates to the checkout page
	And User enters the following billing details
		|firstname|lastname|phone|address|zip|city|
		|zain|khan|3434354545|street 101|1234|soest|

Scenario: User places the order from webshop with TeamViewer Business
And User selects the payment method Invoice
And User accepts the license agreement
Then User clicks on the place order button

Scenario: User places the order from webshop with TeamViewer Business via Paypal
And User selects the payment method Paypal
And User accepts the license agreement
Then User clicks on the paypal button
And User enters the paypal credentials
|Email											|Password|
|intdev-buyer@teamviewer.com|s7ugeWuc|
