package com.juaracoding.pages;

import com.juaracoding.drivers.DriverSingleton;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageLogin {

    private WebDriver driver;

    public PageLogin(){
        this.driver = DriverSingleton.getDriver();
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@id='user-name']")
    WebElement formUsername;

    @FindBy(xpath = "//input[@id='password']")
    WebElement formPassword;

    @FindBy(xpath = "//input[@id='login-button']")
    WebElement btnLogin;

    public void login(String username, String password){
        formUsername.sendKeys(username);
        formPassword.sendKeys(password);
        btnLogin.click();
    }



}
