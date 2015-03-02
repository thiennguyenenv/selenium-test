import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.internal.FindsById;
import org.openqa.selenium.internal.FindsByName;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

/**
 * Created by Thien (Theodore) on 3/2/2015.
 */
public class FirstJUnit {
    private WebDriver selenium;
    @Before
    public void setup() {
        FirefoxProfile profile = new FirefoxProfile();
        profile.setPreference("browser.startup.homepage", "http://book.theautomatedtester.co.uk/chapter4");
        selenium = new FirefoxDriver(profile);
    }

    @Test
    public void shouldCheckButtonOnChapter2Page() {
        Chapter2 ch2 = new Chapter2(selenium).get();
        Assert.assertTrue(ch2.isButtonPresent("but1"));
    }

    @Test
    public void shouldCheckAnotherButtonOnChapter2Page(){
        Chapter2 ch2 = loadHomePage().clickChapter2();
        Assert.assertTrue(ch2.isButtonPresent("but1"));
    }

    @Test
    public void testExample(){
        selenium.get("http://book.theautomatedtester.co.uk/chapter2");
        // implicit waiting
//        selenium.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        // explicit waiting, findElement will fire NoSuchElementException if not found, we can use findElements to get around.
        WebElement element = new WebDriverWait(selenium, 10).until(new ExpectedCondition<WebElement>() {
            @Override
            public WebElement apply(WebDriver webDriver) {
                return webDriver.findElement(By.xpath("//input[@name = 'verifybutton']"));
            }
        });
        ((FindsByName)selenium).findElementByName("verifybutton");
    }

    @Test
    public void testExampleChap4(){
//        selenium.get("http://book.theautomatedtester.co.uk/chapter4");
        WebElement element = selenium.findElement((By.id("nextBid")));
        element.sendKeys("100");
    }

    @After
    public void teardown(){
        selenium.quit();
    }

    private Chapter2 clickAndLoadChapter2() {
        selenium.findElement(By.linkText("Chapter2")).click();
        return PageFactory.initElements(selenium, Chapter2.class);
    }

    private HomePage loadHomePage() {
        selenium.get("http://book.theautomatedtester.co.uk");
        return new HomePage(selenium);
    }
}
