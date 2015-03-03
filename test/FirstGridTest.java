import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by Thien (Theodore) on 3/3/2015.
 */
public class FirstGridTest {
    WebDriver selenium;
    @Before
    public void setup(){
        DesiredCapabilities capability = DesiredCapabilities.firefox();
        capability.setBrowserName("firefox");
        capability.setPlatform(Platform.WINDOWS);
        try {
            selenium = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capability);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        selenium.get("http://book.theautomatedtester.co.uk/chapter1");
    }

    @After
    public void teardown(){
        selenium.quit();
    }

    @Test
    public void testExamples(){
        Assert.assertEquals(selenium.findElements(By.id("verifybutton")).size(), 1);
    }
}
