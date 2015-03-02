import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;

/**
 * Created by Thien (Theodore) on 3/2/2015.
 */
public class Chapter2 extends LoadableComponent<Chapter2> {
    WebDriver selenium;
    @FindBy(how = How.NAME, using = "verifybutton")
    WebElement verifybutton;

    public Chapter2(WebDriver selenium) {
        this.selenium = selenium;
        PageFactory.initElements(selenium, this);
    }

    public boolean isButtonPresent(String button){
        return selenium.findElements(By.xpath("//input[@id='" + button + "']")).size() > 0;
    }

    public boolean isButton(String button){
        return selenium.findElements(By.xpath("//button[@id='" + button + "']")).size() > 0;
    }

    @Override
    protected void load() {
        selenium.get("http://book.theautomatedtester.co.uk/chapter2");
    }

    @Override
    protected void isLoaded() throws Error {
        String url = selenium.getCurrentUrl();
        Assert.assertTrue("Not on the right page.", url.contains("chapter2"));
    }
}
