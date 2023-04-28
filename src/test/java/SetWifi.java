import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import testBase.Base;

public class SetWifi extends Base {

    @Test
    public void setWifiTest() {

        //Object Locators: xpath, id, className, accessibilityId, androidUIautomator
        driver.findElement(AppiumBy.accessibilityId("Preference")).click();
        driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"3. Preference dependencies\"]")).click();
        driver.findElement(By.id("android:id/checkbox")).click();
        driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.ListView/android.widget.LinearLayout[2]/android.widget.RelativeLayout")).click();
        driver.findElement(By.id("android:id/edit")).sendKeys("no1234");
        driver.findElement(By.id("android:id/button1")).click();
        //driver.findElement(AppiumBy.className("android.widget.Button")).get(1).click();
    }
}