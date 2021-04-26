
Feature: Login page feature

Scenario: Login Page Title
  Given User is on login page
  When User gets the title of the page
  Then Page title should be "Login - My Store"

@Skip 
Scenario: Forgot Password Link
	Given User is on login page
	Then Forgot password link should be displayed
	
Scenario: Login with correct credentials
	Given User is on login page
	When User enters username "johndoe2021@gmail.com"
	And User enters password "Password@123"
	And User clicks on login button
	Then Page title should be "My Account - My Store"