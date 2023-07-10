Feature: Login With Valid Credentials

  @Sanity
  Scenario Outline: Succesfull login With Valid Credentials
    Given User Launch Browser
    And Opens URL "http://demo.opencart.com/"
    When User Navigate To MyAccount Menu
    #And Click on Login
    #And User Enters Email as "<email>" and Password as "<password>"
   # And Click on Login button

    #Then User Navigate to MyAccountPage
    #Examples: 
    #  | email                  | password     |
     # | kranthikadiyala        | krannthi@123 |
     # | padukadiyala@gmail.com | kadi@123     |
    And Click on Register
    And User Enters First Name as "<First Name>" and Last Name as "<Last Name>" and E-Mail as "<E-Mail>" and Password as "<Password>"
    And User click on the radio button yes to Subscribe NewsLetter
    And User click on the check box to agree privacy policy
    And Click on continue button
    
       Examples: 
       | First Name                   | Last Name    | E-Mail                | Password
       | kranthi                      | kadiyala     | kranthikadiyala       | krannthi@123
       | padu                        | kadiyala     |    padukadiyala@gmail.com| kadi@123