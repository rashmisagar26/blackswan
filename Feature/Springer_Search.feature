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

Feature: Search functionality
As a user, when I search for a keyword, I want to see the relevant search results 

Scenario: Searching with a valid keyword gives results matching with the keyword
Given I am on Springer Link Page
And I see the search box
When I type keyword in the search box
And I click on search button
Then I see the results for keyword

Scenario: Searching with an invalid keyword displays appropriate message to the user
Given I am on Springer Link Page
And I see the search box
When I type invalid_term in the search box
And I click on search button
Then I should see validation_message on the results section