Feature: To Validate the login functionality of email application

Scenario: To validate login with valid username and invalid password name
Given To lanch the chrome browser and maximise window
When To lanch the url of the email application
And To pass valid username name in email field
And To pass valid password in password field
And To click the next button
And To check whether navigate to the page or not
Then To close the Browser


Scenario Outline: To validate the positive and nagative combination of login functionality
Given user has to launch the browser and maximise window
When User has to hit the email url
And User has to Pass the data"<emaildatas>" in email field
And User has to pass the data "<passworddatas>"in password field  
And User has to login button 
Then User has to close the browser 

Examples:

|emaildatas	               |passworddatas |
|seleniuminmakes@gmail.com |Unique |
|Manualtesting@gmail.com   |12345678 |
|Abcd@gmail.com            |Cucumber| 
|Framework@gmail.com |9876543210 |















