@Feature2

Feature: Purchase Automation Practice item
  Me as a Automation Practice user
  I want to be able to purchase products from the store


  @Case1
  Scenario: The user successfully purchases items from the Automation Practice store
    Given that the user logs into its Automation practice with the username 'xabras123@gmail.com' and the password 'Popo1234'
    And the user successfully adds an item called 'Printed Chiffon Dress' from the miniature to the shopping cart
    When the user successfully purchases items from the store
    Then the user should be redirected to a successful payment screen

