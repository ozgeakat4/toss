#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
@tag
Feature: Title of your feature
  I want to use this template for my feature file

  @tag1
  Scenario: Search charger
    Given open webpage "<webpage>"
    When login web with username "<username>" and password "<password>"
    Then add charger
    When login app with username "<username>" and password "<password>"
    Then search charger on web
    Then search charger on app
    
    Examples:
    |username|password|webpage|
    |aa@gmail.com|asd.1234|https://vesteuwebapptest.azurewebsites.net|
    |aa@dsfsf.com|asd.1234|https://vesteuwebapptest.azurewebsites.net|
    
    
  @tag2
  Scenario: Reserved charger
  	Given open webpage  "<webpage>"
    When login web with username "<username>" and password "<password>"
    When search charger on web 
    Then charger is unreserved
    When login app  with username "<username>" and password "<password>"
    And search charger on app
    And reserve charger on app
  	Then search charger on web
		Then charger is reserved 
		
	@tag3
	Scenario: Check payment 
  	Given open webpage 
    When login web  with username "<username>" and password "<password>"
    When login app with username "<username>" and password "<password>"
    Then search charger on app
    Then start charge on app 
    Then search user on web
    Then check user status 
    
  @tag4
	Scenario: Activate user
  	Given open webpage 
    When login web  with username "<username>" and password "<password>"
    When signup app  with username "<username>" and password "<password>"
    Then search user on web
    Then activate user  
  
  @tag5
	Scenario: Check charger
  	Given open webpage 
    When login web  with username "<username>" and password "<password>"
    When delete device on web
    Then search charger on web
    When login app  with username "<username>" and password "<password>"
    Then search charger on app
  @tag6
	Scenario: Change charger status
	Given open webpage 
  When login web  with username "<username>" and password "<password>"
	Then change device status on web
	
  @tag7
	Scenario: Delete user
	Given open webpage 
  When login web  with username "<username>" and password "<password>"
	Then delete user on web
	
	@tag8
	Scenario: Change user status
	Given open webpage 
  When login web  with username "<username>" and password "<password>"
	Then change user status on web
	
	@tag9	
	Scenario: Add rfid card
	Given open webpage 
  When login web  with username "<username>" and password "<password>"
	Then search user on web
	Then add rfid card
	
    