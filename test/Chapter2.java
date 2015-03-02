import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/**
 * Created by Thien (Theodore) on 3/2/2015.
 */
public class Chapter2 {
    WebDriver selenium;
    @FindBy(how = How.NAME, using = "verifybutton")
    WebElement verifybutton;

    public Chapter2(WebDriver selenium) {
        this.selenium = selenium;
        // make sure chapter 2 is opened as a start point
        if (!"Selenium: Beginners Guide".equalsIgnoreCase(this.selenium.getTitle())){
            this.selenium.get("http://book.theautomatedtester.co.uk/chapter2");
        }
    }

    public boolean isButtonPresent(String button){
        return selenium.findElements(By.xpath("//input[@id='" + button + "']")).size() > 0;
    }

    public boolean isButton(String button){
        return selenium.findElements(By.xpath("//button[@id='" + button +"']")).size() > 0;
    }
}
