@Feature3

Feature: Add product to the Automation Practice shopping cart
  Me as a Automation Practice user
  add product to the Automation Practice shopping cart


  @Case1
  Scenario: The user successfully adds item to shopping cart from the item miniature
    Given that the user is on the Automation Practice login screen
    When the user successfully adds an item called 'Printed Chiffon Dress' from the miniature to the shopping cart
    Then the user should see a reward modal stating that the element was successfully added to the shopping cart


  @Case2
  Scenario: The user successfully adds item to shopping cart from the item visualization screen
    Given that the user is on the Automation Practice login screen
    When the user successfully adds an item called 'Blouse' to the shopping cart from the item preview screen
    Then the user should see a reward modal stating that the element was successfully added to the shopping cart


  @Case3
  Scenario: The user tries to add an already added item
    Given that the user is on the Automation Practice login screen
    When the user tries to add 2 times the same item to the shopping cart
    Then the user should see a reward modal stating that the element was successfully added to the shopping cart



  @Case4
  Scenario: The user deletes an item from the shopping cart list
    Given that the user logs into its Automation practice with the username 'xabras123@gmail.com' and the password 'Popo1234'
    When the user successfully deletes an item from the the shopping cart
    Then the user should see that the item is no longer on the shopping cart



