import com.juaracoding.drivers.DriverSingleton;
import com.juaracoding.pages.Checkout;
import com.juaracoding.pages.PageLogin;
import com.juaracoding.pages.Shopping;
import com.juaracoding.pages.Validasi;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Testing {
    WebDriver driver;
    Validasi validasi;
    PageLogin pageLogin;
    Checkout checkout;
    Shopping shopping;

    @BeforeClass
    public void setUp(){
        DriverSingleton.getInstance("chrome");
        driver = DriverSingleton.getDriver();
        driver.get("https://www.saucedemo.com");
        validasi = new Validasi();
        checkout = new Checkout();
        pageLogin = new PageLogin();
        shopping = new Shopping();
    }

    @AfterClass
    public void finish(){
        DriverSingleton.delay(3);
        DriverSingleton.closeObjectInstance();
    }

    @Test(priority = 1)
    public void validasiLogin(){
        pageLogin.login("standard_user","secret_sauce");
        Assert.assertEquals(validasi.getDashboard(),"Products");
    }

    @Test(priority = 2)
    public void validasiShopping(){
        shopping.shop();
        Assert.assertEquals(validasi.getshop(),"Sauce Labs Backpack");
    }

    @Test(priority = 3)
    public void validasiCheckout(){
        checkout.fillForm("Wahyu","Ferryansyah","23254");
        Assert.assertEquals(validasi.getfinish(),"Thank you for your order!");
    }
}
