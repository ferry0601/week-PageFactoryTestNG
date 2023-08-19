package com.juaracoding.drivers.strategies;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Firefox implements DriverStrategy{
    @Override
    public WebDriver setStrategy() {
        String path = "C:\\Tools\\geckodriver.exe";
        System.setProperty("webdriver.chrome.driver",path);
        WebDriver driver = new FirefoxDriver();
        return driver;
    }
}
