Feature: login to letme call application

Scenario: user in login page

Given user already in login page 
When user able to verify title of application
Then user enters username
And user enters password



Scenario: signup to lmc application

Given user is ready to enter the details
When enter user name and email
Then enter the password and zipcode 
And signup to application

Scenario: verify all titles and headers in login page view 

Given verify main header
When verify application image
Then verify source image and address
Then verify menu options