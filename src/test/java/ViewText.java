import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import testBase.Base;

public class ViewText extends Base {

    @Test
    public void textText() {

        driver.findElement(AppiumBy.accessibilityId("Views")).click();
        driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"Buttons\"]")).click();
        String normalBtn = driver.findElement(By.id("io.appium.android.apis:id/button_normal")).getText();
        Assert.assertEquals(normalBtn, "Normal");

    }
}
