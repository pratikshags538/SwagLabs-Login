Feature: LoginPage

	Scenario: Navigation
		Given Chrome is opened and Swaglabs is opened
		Then It navigates on to login page
		
  Scenario: UI
    Given Chrome is opened and Swaglabs is opened
    Then It shows elements on login page

  Scenario: Field Validation (Username and Password fields are enabled)
    Given Chrome is opened and Swaglabs is opened
    When User clicks on Username and Password
    Then Username and Password fields are enabled on login page

  Scenario: Main functionality
    Given Chrome is opened and Swaglabs is opened
    When User enters "standard_user" and "secret_sauce"
    And User clicks on login button
    Then It shows home page

  