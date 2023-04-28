package testBase;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class Base {

    public AndroidDriver driver;
    public AppiumDriverLocalService service;

    @BeforeClass
    public void configAppium() throws MalformedURLException, InterruptedException {

        Map<String, String> env = new HashMap<String, String>(System.getenv());
        env.put("ANDROID_HOME", "C:\\Users\\asus\\AppData\\Local\\Android\\Sdk");
        env.put("JAVA_HOME", "C:\\Program Files\\Java\\jdk-17");

        //run appium server automatically
        service = new AppiumServiceBuilder()
                .withAppiumJS(new File("C:\\Users\\asus\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
                .withIPAddress("127.0.0.1").usingPort(4723).withEnvironment(env).withTimeout(Duration.ofSeconds(300)).build();

        service.start();


        //create capabilities
        UiAutomator2Options options = new UiAutomator2Options();
        options.setDeviceName("Pixel_2_API_29");
        options.setApp(System.getProperty("user.dir") + "\\src\\test\\java\\resources\\ApiDemos-debug.apk");
        options.setPlatformName("Android");
        options.setCapability("platformVersion", "10.0");
        options.setAutomationName("UiAutomator2");

        //create object for androidDriver /iosDriver
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //Object Locators: xpath, id, className, accessibilityId, androidUIautomator

        //driver.findElement(AppiumBy.accessibilityId("Preference")).click();


    }
    //perform swipe action
    public void swipeAction(WebElement ele, String swipeDirection) {

        ((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement) ele).getId(),
                "direction", swipeDirection,
                "percent", 0.75
        ));
    }
    @AfterClass
    public void tearDown() {
        driver.quit();
        service.stop();
    }
}
