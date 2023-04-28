import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import testBase.Base;

public class Swipe extends Base {

    @Test
    public void swipeDemoTest() {
        driver.findElement(AppiumBy.accessibilityId("Views")).click();
        driver.findElement(AppiumBy.accessibilityId("Gallery")).click();
        driver.findElement(By.xpath("//android.widget.TextView[@content-desc='1. Photos']")).click();

        WebElement firstImage=driver.findElement(By.xpath("(//android.widget.ImageView)[1]"));
        // Before perform the swipe
        String firstTimeValue=firstImage.getAttribute("focusable");
        Assert.assertEquals("true", firstTimeValue);

        //perform swipe action
        swipeAction(firstImage, "left");


        // After perform the swipe
        String secondTimeValue=firstImage.getAttribute("focusable");
        Assert.assertEquals("false", secondTimeValue);


    }

}
