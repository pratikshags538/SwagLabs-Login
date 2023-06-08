Feature: Login using Excel data

  Scenario Outline: Verify Login with valid data
    Given Chrome is opened and Swaglabs is opened
    When User enters username and password from sheetname "<sheetname>" and rownumber <rownumber>
    And User clicks on Login button
    Then It shows Home Page

    Examples: 
      | sheetname | rownumber |
      | Sheet1    |         0 |
      | Sheet1    |         1 |
      | Sheet1    |         2 |
