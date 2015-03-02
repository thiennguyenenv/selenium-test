import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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
        Chapter2 ch2 = new Chapter2(selenium).get();
        Assert.assertTrue(ch2.isButtonPresent("but1"));
    }

    private Chapter2 clickAndLoadChapter2() {
        selenium.findElement(By.linkText("Chapter2")).click();
        return PageFactory.initElements(selenium, Chapter2.class);
    }

    private HomePage loadHomePage() {
        selenium.get("http://book.theautomatedtester.co.uk");
        return new HomePage(selenium);
    }

    @Test
    public void shouldCheckAnotherButtonOnChapter2Page(){
        Chapter2 ch2 = loadHomePage().clickChapter2();
        Assert.assertTrue(ch2.isButtonPresent("but1"));
    }

    @After
    public void teardown(){
        selenium.quit();
    }
}
