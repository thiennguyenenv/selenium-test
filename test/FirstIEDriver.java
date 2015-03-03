import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

/**
 * Created by Thien (Theodore) on 3/2/2015.
 */
public class FirstIEDriver {
    private WebDriver selenium;
    @Before
    public void setup() {
//        System.setProperty("webdriver.chrome.driver", "D:\\Ins\\2015\\SELENIUM\\chromedriver.exe");
        selenium = new InternetExplorerDriver();
        selenium.get("http://book.theautomatedtester.co.uk/chapter4");
    }

    @Test
    public void testExample(){
        WebElement element = selenium.findElement(By.id("selectLoad"));
        String value = element.getAttribute("value");
        Assert.assertEquals("Click to load the select below", value);
    }

    @After
    public void teardown(){
        selenium.quit();
    }
}
