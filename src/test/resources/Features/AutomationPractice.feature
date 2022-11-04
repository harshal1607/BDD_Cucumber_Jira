@SmokeScenario
Feature: Check multiple functionalities on Automation Practice website

  @SmokeTest
  Scenario: Check Radio button functionality
    Given User is on landing page
    Then Verify user is on landing page
    When User clicks on radio button
    Then Radio button should be selected

  @SmokeTest
  Scenario Outline: Check suggession class dropdown functionality
    Given User is on landing page
    Then Verify user is on landing page
    When Enter country in input box and select <value> from dropdown

    Examples: 
      | value |
      | India |
      | China |

  @SmokeTest
  Scenario: Check dropdown functionality
    Given User is on landing page
    Then Verify user is on landing page
    When select value from dropdown

  @SmokeTest
  Scenario: Verify checkbox functinality
    Given User is on landing page
    When Verify user is on landing page
    Then User is able to click on checkbox
    And Verify checkbox is selected

  @SwitchTab
  Scenario: Verify Switch Tab Functionality
    Given User is on landing page
    When click on Open Tab button
    Then verify another Tab is Opened
    And come back to main Tab

  @Alerts
  Scenario: Verify AlertBox Functionality
    Given User is on landing page
    When user click on Enter Your Name textbox
    And user click on Alert and Handle alert
    Then user click on confirm button and handle Alert with Ok
    And user click on confirm button and handle Alert with cancel
    
  @WebTable
  Scenario: Verify Web Table Functionality
    Given User is on landing page
    When verify all table data "1"

  @WebTableFixedHeader
  Scenario: Verify Web Table of Fixed header Fields Are Displayed
    Given User is on landing page
    When verify Table Header
    Then verify fields in fixed header Table
      | HeaderName |
      | Name       |
      | Position   |
      | City       |
      | Amount     |

  @MouseHover
  Scenario Outline: Verify Mouse hover Functionality
    Given User is on landing page
    When mouse hover to Mouse hover button
    Then verify <indexno> value present in List <listvalue>

    Examples: 
      | indexno | listvalue |
      |       1 | Top       |
      |       2 | Reload    |

  @Iframe
  Scenario: Verify iFrame Functionality
    Given User is on landing page
    When user enter In iFrame
    Then verify user in Iframe

  @FBSignUP
  Scenario: Verify SignUP in Facebook Functionality
    Given User in On facebook SignUP Page
    When user click on SignUP page
    Then user verify  all fields in facebook sign up page
      | FieldsNameValue |
      | firstname       |
      | lastname        |
      | reg_email__     |
      | reg_passwd__    |
      | birthday_day    |
      | birthday_month  |
      | birthday_year   |
      | Gender          |
      | Female          |
      | Male            |
      | Custom          |

  @SmokeTest1
  Scenario: Check switch window functionality
    Given User is on landing page
    When Verify user is on landing page
    And Switch on opened window

    
 