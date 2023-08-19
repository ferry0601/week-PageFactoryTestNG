package com.juaracoding.pages;

import com.juaracoding.drivers.DriverSingleton;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Shopping {
    private WebDriver driver;
    public Shopping(){
        this.driver = DriverSingleton.getDriver();
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//button[@id='add-to-cart-sauce-labs-backpack']")
    WebElement addBackpack;

    @FindBy(xpath = "//button[@id='add-to-cart-sauce-labs-bolt-t-shirt']")
    WebElement addblacktShirt;

    @FindBy(xpath = "//a[@class='shopping_cart_link']")
    WebElement cart;

    @FindBy(xpath = "//button[@id='checkout']")
    WebElement btnCheckout;

    public void shop(){
        addBackpack.click();
        addblacktShirt.click();
        cart.click();
        DriverSingleton.delay(3);
        btnCheckout.click();
    }
}
