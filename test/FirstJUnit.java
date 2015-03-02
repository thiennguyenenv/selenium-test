import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Thien (Theodore) on 3/2/2015.
 */
public class FirstJUnit {
    private WebDriver selenium;
    @Before
    public void setup() {
        selenium = new FirefoxDriver();
    }
    @Test
    public void shouldCheckButtonOnChapter2Page() {
        loadHomePage();
        clickAndLoadChapter2();
        Assert.assertEquals(selenium.findElements(By.id("but1")).size(), 1);
    }

    private void clickAndLoadChapter2() {
        selenium.findElement(By.linkText("Chapter2")).click();
    }

    private void loadHomePage() {
        selenium.get("http://book.theautomatedtester.co.uk");
    }

    @Test
    public void shouldCheckAnotherButtonOnChapter2Page(){
        loadHomePage();
        clickAndLoadChapter2();
        Assert.assertEquals(selenium.findElements(By.name("verifybutton")).size(), 1);
    }

    @After
    public void teardown(){
        selenium.quit();
    }
}
