Feature: Contact Us Feature

  Scenario Outline: Contact Us scenario with different data sets
    Given User is on contact us page
    When User fills form from given "<SheetName>" and row number <RowNumber>
    And User clicks on send button
    Then Successful message is displayed to user

    Examples: 
      | SheetName     | RowNumber |
      | ContactUsForm |         0 |
      | ContactUsForm |         1 |
