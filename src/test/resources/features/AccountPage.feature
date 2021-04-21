Feature: Account Page Feature

Background: 
	Given User is logged in to application
	|	email 								| password			|
	|	johndoe2021@gmail.com	|	Password@123	|
	
Scenario: Accounts page title
	Given User is on Accounts page
	When User gets the title of the page
  Then Page title should be "My account - My Store"
  
Scenario: Account Section Links
	Given User is on Accounts page
	Then User gets account section links
	|	ORDER HISTORY AND DETAILS	|
	|	MY ADDRESSES							|
	|	MY CREDIT SLIPS						|
	|	MY PERSONAL INFORMATION		|
	|	MY WISHLISTS							|
	Then "5" links are displayed in the account section