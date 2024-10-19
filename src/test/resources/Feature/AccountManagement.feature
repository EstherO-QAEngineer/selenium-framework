@AccountManagement
Feature: Account Management

  @CreateAccount
  Scenario Outline: Create an account using a valid email address
    Given I am on create an account page
    When I enter "<FirstName>" "<LastName>" "<Email>" "<Password>" "<ConfirmPassword>"
    And I click on create an account
    Then My account page is displayed

    Examples:
      | FirstName | LastName | Email           | Password  | ConfirmPassword |
      | Betty     | Golden   | betty1@gmail.com | Betty200$ | Betty200$       |

  @SignIn
  Scenario Outline: Account Login with username and password
    Given I am on Sign In page
    When I enter "<Email>" "<Password>"
    And I click on Sign In
    Then My account page is displayed


    Examples:
      | Email           | Password  |
      | betty1@gmail.com | Betty200$ |

@DuplicateAccount
  Scenario Outline: Create Account - Duplicate Account creation not allowed
    Given I am on create an account page
    When I enter "<FirstName>" "<LastName>" "<Email>" "<Password>" "<ConfirmPassword>"
    And I click on create an account
    Then Error message should display account already created


    Examples:
      | FirstName | LastName | Email           | Password  | ConfirmPassword |
      | Betty     | Golden   | betty1@gmail.com | Betty200$ | Betty200$       |

@UnregisteredCustomer
  Scenario Outline: Unregistered Customer cannot login
    Given I am on Sign In page
    When I enter "<Email>" "<Password>"
    And I click on Sign In
    Then The System should display unregistered customer cannot Login


    Examples:
      | Email            | Password  |
      | betty2@gmail.com | Betty200$ |


  @AccountLock
  Scenario Outline: Account Lock - Account is locked after maximum of 5 attempts

  //call the create an account action already created here to avoid repetition
    Given I am on Sign In page
    And I enter "<Email>" "<Password>"
    And I click on Sign In
    When I repeat entering "<Email>" "<Password>" and Click Sign in four more times
    Then Error message should display account has been locked

    Examples:
      | Email           | Password  |
      | betty1@gmail.com | Betty200! |






