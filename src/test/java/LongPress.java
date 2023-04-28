import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import testBase.Base;

public class LongPress extends Base {

    @Test
    public void longPressTest() throws InterruptedException {
        driver.findElement(AppiumBy.accessibilityId("Views")).click();
        driver.findElement(AppiumBy.accessibilityId("Expandable Lists")).click();
        driver.findElement(AppiumBy.accessibilityId("1. Custom Adapter")).click();
        WebElement longElement = driver.findElement(By.xpath("//android.widget.TextView[@text='People Names']"));
        driver.executeScript("mobile: longClickGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement) longElement).getId(), "duration", 3000));
        Thread.sleep(2000);

        WebElement sMenu = driver.findElement(By.id("android:id/title"));
        String peopleText = sMenu.getText();
        Assert.assertEquals(peopleText, "Sample menu");

        Boolean display = sMenu.isDisplayed();
        Assert.assertTrue(display);


    }
}
