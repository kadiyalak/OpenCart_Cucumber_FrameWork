Feature: Add to the cart and checkout

  @Regression
  Scenario: SuccesFully add to the cart and checkout
    Given User Launch Browser
    And Opens URL "http://demo.opencart.com/"
    When click on the desktop
    And click on the mac
    And click on the mac1
    And click on the addtocart
    Then validate the alert message
    When click on the shoppingcart
    And click on the money
    Then validate the text message
    And click on the checkout
    Then validate the message
