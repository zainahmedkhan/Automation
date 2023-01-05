

Feature: Contact Us page feature

Scenario Outline: contact us scenario with different sets of data
Given User naviagtes to contactus page
When User fills the form from the given sheetname "<Sheetname>" and rownumber <RowNumber> 
And User clicks on send button
Then It shows the successful message "Your message has been successfully sent to our team."
Examples:
|Sheetname|RowNumber|
|contactus|0|
|contactus|1|