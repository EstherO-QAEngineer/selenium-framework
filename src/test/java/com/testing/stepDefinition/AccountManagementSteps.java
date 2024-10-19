package com.testing.stepDefinition;

import com.testing.cucumber.Hooks;
import com.testing.pageObject.CreateAccountPagePO;
import com.testing.pageObject.HomepagePO;
import com.testing.pageObject.SignInPagePO;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import static com.testing.pageObject.SignInPagePO.*;


public class AccountManagementSteps {
    WebDriver driver = Hooks.driver;


    @Given("I am on create an account page")
    public void iAmOnCreateAnAccountPage() {
        HomepagePO homepagePO = new HomepagePO(driver);
        homepagePO.clickCreateAccountLink();

    }

    @When("I enter {string} {string} {string} {string} {string}")
    public void iEnter(String FirstName, String LastName, String Email, String Password, String ConfirmPassword) {
        CreateAccountPagePO createAccountPagePO = new CreateAccountPagePO(driver);
        createAccountPagePO.enterFirstName(FirstName);
        createAccountPagePO.enterLastName(LastName);
        createAccountPagePO.enterEmailAddress(Email);
        createAccountPagePO.enterPassword(Password);
        createAccountPagePO.enterConfirmPassword(ConfirmPassword);


    }

    @And("I click on create an account")
    public void iClickOnCreateAnAccount() {
        CreateAccountPagePO createAccountPagePO = new CreateAccountPagePO(driver);
        createAccountPagePO.clickCreateAccountButton();
    }

    @Then("Error message should display account already created")
    public void errorMessageShouldDisplayAccountAlreadyCreated() {
        String ExpectedResult = "Customer Login";
        String ActualResult = driver.getTitle();
        Assert.assertEquals(ExpectedResult, ActualResult);
    }


    @Given("I am on Sign In page")
    public void iAmOnSignInPage() {
        HomepagePO homepagePO = new HomepagePO(driver);
        homepagePO.clickSignInLink();
    }

    @When("I enter {string} {string}")
    public void iEnter(String Email, String Password) {
        SignInPagePO signInPagePO = new SignInPagePO(driver);
        signInPagePO.enterEmailAddress(Email);
        signInPagePO.enterPassword(Password);

    }


    @And("I click on Sign In")
    public void iClickOnSignIn() {
        SignInPagePO signInPagePO = new SignInPagePO(driver);
        signInPagePO.clickSignInButton();
    }

    @Then("My account page is displayed")
    public void myAccountPageIsDisplayed() {
        String ExpectedResult = "My Account";
        String ActualResult = driver.getTitle();
        Assert.assertEquals(ExpectedResult, ActualResult);

    }


    @Then("The System should display unregistered customer cannot Login")
    public void theSystemShouldDisplayUnregisteredCustomerCannotLogin() {
        String ExpectedResult = "My Account";
        String ActualResult = driver.getTitle();
        Assert.assertEquals(ExpectedResult, ActualResult);

    }


    @When("I repeat entering {string} {string} and Click Sign in four more times")
    public void iRepeatEnteringAndClickSignInFourMoreTimes(String Email, String Password) {
        for (int i = 0; i < 5; i++) {

            SignInPagePO signInPagePO = new SignInPagePO(driver);
            signInPagePO.enterEmailAddress(Email);
            signInPagePO.enterPassword(Password);
            signInPagePO.clickSignInButton();

            //clear fields before entering new data
            EmailAddressField.clear();
            PasswordField.clear();

            EmailAddressField.sendKeys(Email);
            PasswordField.sendKeys(Password);
            SignInButton.click();
        }

    }

    @Then("Error message should display account has been locked")
    public void errorMessageShouldDisplayAccountHasBeenLocked() {
        String ExpectedResult = "Customer Login";
        String ActualResult = driver.getTitle();
        Assert.assertEquals(ExpectedResult, ActualResult);
    }

}
