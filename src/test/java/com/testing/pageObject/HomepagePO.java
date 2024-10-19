package com.testing.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomepagePO {
    // Element Locators
    @FindBy(linkText = "Create an Account")
    public static WebElement CreateAccountLink;

    @FindBy(linkText = "Sign In" )
    public static WebElement SignInLink;

    // Initialised Web Element Using Selenium
    public HomepagePO(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    // Java method to perform Web Element Action
    public void clickCreateAccountLink(){
        CreateAccountLink.click();
    }

    public void clickSignInLink(){
        SignInLink.click();
    }
















}
