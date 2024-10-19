package com.testing.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignInPagePO {
    // Element Locators
    @FindBy(id = "email")
    public static WebElement EmailAddressField;

    @FindBy(id = "pass")
    public static WebElement PasswordField;

    @FindBy(css = "#send2")
    public static WebElement SignInButton;

    // Initialised Web Element Using Selenium
    public SignInPagePO(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    // Java method to perform Web Element Action
    public void enterEmailAddress(String Email){
        EmailAddressField.sendKeys(Email);
    }

    public void enterPassword(String Password){
        PasswordField.sendKeys(Password);
    }

    public void clickSignInButton() {
       SignInButton.click();
    }






}







