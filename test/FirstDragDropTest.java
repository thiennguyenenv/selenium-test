import com.opera.core.systems.scope.protos.ExecProtos;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

/**
 * Created by Thien (Theodore) on 3/3/2015.
 */
public class FirstDragDropTest {
    WebDriver selenium;
    @Before
    public void setup(){
        selenium = new FirefoxDriver();
        selenium.get("http://book.theautomatedtester.co.uk");
    }

    @After
    public void teardown(){
        selenium.quit();
    }

    @Test
    public void testCapture(){
        String screenshotBase64 = ((TakesScreenshot)selenium).getScreenshotAs(OutputType.BASE64);
    }

    @Test
    public void testExample(){
        // this test not works as it requires http://book.theautomatedtester.co.uk/demo2.html which is not available.
        WebElement element = selenium.findElement(By.className("draggable"));
        WebElement otherElement = selenium.findElement(By.className("droppable"));

        Actions builder = new Actions(selenium);
        Action dragAndDrop = builder.clickAndHold(element).moveToElement(otherElement).release(otherElement).build();

        dragAndDrop.perform();
    }
}
