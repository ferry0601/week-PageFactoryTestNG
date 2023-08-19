package com.juaracoding.pages;

import com.juaracoding.drivers.DriverSingleton;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Validasi {
    private WebDriver driver;

    public Validasi(){
        this.driver = DriverSingleton.getDriver();
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//span[@class='title']")
    WebElement Dashboard;

    @FindBy(xpath = "//div[@class='inventory_item_name']")
    WebElement titlecart;

    @FindBy(xpath = "//h2[@class='complete-header']")
    WebElement completed;

    public void validasiShop(String expected){
        String result = validasiin(getshop(),expected);
        System.out.println(result);
    }
    public String getshop(){
        return titlecart.getText();
    }
    public void validasiCheckout(String expected){
        String result = validasiin(getfinish(),expected);
        System.out.println(result);
    }

    public String getfinish(){
        return completed.getText();
    }

    public void validasiLogin(String expected){
        String result = validasiin(getDashboard(),expected);
        System.out.println(result);
    }

    public String getDashboard(){
        return Dashboard.getText();
    }

    public static String validasiin(String actual, String expected){
        if(actual.contains(expected)){
            return "Successfully "+expected;
        } else {
            return "Invalid "+expected;
        }
    }
}
