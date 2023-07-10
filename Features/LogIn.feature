Feature: Login With Valid Credentials

  @Sanity @Regression
  Scenario: Succesfull login With Valid Credentials
    Given User Launch Browser
    And Opens URL "http://demo.opencart.com/"
    When User Navigate To MyAccount Menu
    # And Click on Register
    #And User Enters First Name as "suman" and Last Name as "yejella" and E-Mail as "yejellasuman@gmail.com" and Password as "suman@123"
    # And User click on the radio button yes to Subscribe NewsLetter
    # And User click on the check box to agree privacy policy
    # And Click on continue button
    And Click on Login
    And User Enters Email as "padukadiyala@gmail.com" and Password as "kadi@123"
    And Click on Login button
