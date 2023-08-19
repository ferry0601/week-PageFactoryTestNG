package com.juaracoding.pages;

import com.juaracoding.drivers.DriverSingleton;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Checkout {
    private WebDriver driver;

    public Checkout(){
        this.driver = DriverSingleton.getDriver();
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@id='first-name']")
    WebElement formFirstname;

    @FindBy(xpath = "//input[@id='last-name']")
    WebElement formLastName;

    @FindBy(xpath = "//input[@id='postal-code']")
    WebElement formZipcode;

    @FindBy(xpath = "//input[@id='continue']")
    WebElement btnContinue;

    @FindBy(xpath = "//button[@id='finish']")
    WebElement btnfinish;

    public void fillForm(String firstname, String lastname, String zipcode){
        formFirstname.sendKeys(firstname);
        formLastName.sendKeys(lastname);
        formZipcode.sendKeys(zipcode);
        DriverSingleton.delay(2);
        btnContinue.click();

        DriverSingleton.scrolling();
        btnfinish.click();
    }
}
