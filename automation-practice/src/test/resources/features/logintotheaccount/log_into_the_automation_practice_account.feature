@Feature1

Feature: Log into the Automation Practice account
  Me as an user
  I want to be able to log into my Automation Practice account


  @Case1
  Scenario: The user successfully logs into its Automation Practice account
    Given that the user is on the Automation Practice login screen
    When that the user authenticates with the username xabras123@gmail.com and the password Popo1234
    Then the user should see it was redirected to the user account page


  @Case2
  Scenario: The user tries to log into its Automation Practice account using an email that doesnt exist
    Given that the user is on the Automation Practice login screen
    When that the user authenticates with the username xabras124@gimail.com and the password Popo1234
    Then the user should see an error popup appears stating about the credentials error


  @Case3
  Scenario: The user tries to log into its Automation Practice account using an incorrect password
    Given that the user is on the Automation Practice login screen
    When that the user authenticates with the username xabras123@gmail.com and the password Popo12345
    Then the user should see an error popup appears stating about the credentials error


