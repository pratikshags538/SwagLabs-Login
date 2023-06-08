Feature: LoginPage DataDriven

  Scenario Outline: Verify Login with Valid data
    Given Chrome is opened and Swaglabs is opened
    When User enters "<username>" and "<password>"
    And User clicks on Login button
    Then It shows Home Page

    Examples: 
      | username                | password     |
      | standard_user           | secret_sauce |
      | problem_user            | secret_sauce |
      | performance_glitch_user | secret_sauce |

  Scenario Outline: Verify Login with Invalid data
    Given Chrome is opened and Swaglabs is opened
    When User enters "<username>" and "<password>"
    And User clicks on Login button
    Then It shows Login Page

    Examples: 
      | username        | password     |
      | Alex Jobs       | demo         |
      | locked_out_user | secret_sauce |
      