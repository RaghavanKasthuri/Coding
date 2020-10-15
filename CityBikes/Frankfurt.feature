Feature: Citybikes in Frankfurt

	Scenario: 2)As a user I want to verify that the city Frankfurt is in Germany and return their corresponded latitude and longitude
	Given I'm a Biker 
	When I login into the Citybikes application to verify that the city Frankfurt is in Germany
	Then I'm displayed that the city of Frankfurt is in Germany alongside the corresponding latitude and longitude
	