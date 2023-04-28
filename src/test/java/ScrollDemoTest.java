import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;
import testBase.Base;

public class ScrollDemoTest extends Base {

    @Test
    public void scrollTest(){
        driver.findElement(AppiumBy.accessibilityId("Views")).click();
        //scroll until webView element
        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"WebView\"));"));

        //scroll as long the app has elements
        /*boolean canScrollMore;
        do {
            canScrollMore = (Boolean) ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap.of(
                    "left", 100, "top", 100, "width", 200, "height", 200,
                    "direction", "down",
                    "percent", 3.0
            ));
        }while (canScrollMore);*/

//--> we can put it in Base in methode and call it when we want(name methode : scrollToEnd)
          }
}
