package com.juaracoding;

import com.juaracoding.drivers.DriverSingleton;
import com.juaracoding.pages.Checkout;
import com.juaracoding.pages.PageLogin;
import com.juaracoding.pages.Shopping;
import com.juaracoding.pages.Validasi;
import org.openqa.selenium.WebDriver;

public class Main {
    static WebDriver driver;

    public static void main(String[] args) {
        DriverSingleton.getInstance("chrome");
        driver = DriverSingleton.getDriver();
        driver.get("https://www.saucedemo.com");

        //login
        PageLogin pageLogin = new PageLogin();
        pageLogin.login("standard_user","secret_sauce");

        //validasi login
        Validasi validasi = new Validasi();
        validasi.validasiLogin("Products");

        //shopping
        Shopping shopping = new Shopping();
        shopping.shop();

        //checkout
        Checkout checkout = new Checkout();
        checkout.fillForm("Wahyu","Ferryansyah","23254");

        //validasi checkout
        validasi.validasiCheckout("Thank you for your order!");
    }
}