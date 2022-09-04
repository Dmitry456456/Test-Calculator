import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import junit.framework.TestCase;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

public class Main {

    private AndroidDriver driver;

    @Before
    public void setUp() throws MalformedURLException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("platformName", "Android");
        desiredCapabilities.setCapability("appium:ensureWebviewsHavePages", true);
        desiredCapabilities.setCapability("appium:nativeWebScreenshot", true);
        desiredCapabilities.setCapability("appium:newCommandTimeout", 3600);
        desiredCapabilities.setCapability("appium:connectHardwareKeyboard", true);

        URL remoteUrl = new URL("http://127.0.0.1:4723/wd/hub");

        driver = new AndroidDriver(remoteUrl, desiredCapabilities);


    }

    @Test
    public void allNumbersTest() {
        driver.findElement(By.id("com.android.calculator2:id/digit_0")).click();
        driver.findElement(By.id("com.android.calculator2:id/digit_1")).click();
        driver.findElement(By.id("com.android.calculator2:id/digit_2")).click();
        driver.findElement(By.id("com.android.calculator2:id/digit_3")).click();
        driver.findElement(By.id("com.android.calculator2:id/digit_4")).click();
        driver.findElement(By.id("com.android.calculator2:id/digit_5")).click();
        driver.findElement(By.id("com.android.calculator2:id/digit_6")).click();
        driver.findElement(By.id("com.android.calculator2:id/digit_7")).click();
        driver.findElement(By.id("com.android.calculator2:id/digit_8")).click();
        driver.findElement(By.id("com.android.calculator2:id/digit_9")).click();
        MobileElement result = (MobileElement) driver.findElementById("com.android.calculator2:id/formula");
        Assert.assertEquals("bad all", "0123456789", result.getText());
        driver.findElement(By.id("com.android.calculator2:id/eq")).click();

    }

    @Test
    public void additionTest() {

        driver.findElement(By.id("com.android.calculator2:id/digit_8")).click();
        driver.findElement(By.id("com.android.calculator2:id/op_add")).click();
        driver.findElement(By.id("com.android.calculator2:id/digit_4")).click();
        driver.findElement(By.id("com.android.calculator2:id/eq")).click();
        MobileElement result = (MobileElement) driver.findElementById("com.android.calculator2:id/result");

        Assert.assertEquals("bad addition", "12", result.getText());


    }

    @Test
    public void subtractionTest() {

        driver.findElement(By.id("com.android.calculator2:id/digit_8")).click();
        driver.findElement(By.id("com.android.calculator2:id/op_sub")).click();
        driver.findElement(By.id("com.android.calculator2:id/digit_4")).click();
        driver.findElement(By.id("com.android.calculator2:id/eq")).click();

        MobileElement result = (MobileElement) driver.findElementById("com.android.calculator2:id/result");

        Assert.assertEquals("bad subtraction", "4", result.getText());


    }

    @Test
    public void multiplicationTest() {

        driver.findElement(By.id("com.android.calculator2:id/digit_8")).click();
        driver.findElement(By.id("com.android.calculator2:id/op_mul")).click();
        driver.findElement(By.id("com.android.calculator2:id/digit_4")).click();
        driver.findElement(By.id("com.android.calculator2:id/eq")).click();

        MobileElement result = (MobileElement) driver.findElementById("com.android.calculator2:id/result");

        Assert.assertEquals("bad multiplication", "32", result.getText());


    }

    @Test
    public void divisionTest() {

        driver.findElement(By.id("com.android.calculator2:id/digit_8")).click();
        driver.findElement(By.id("com.android.calculator2:id/op_div")).click();
        driver.findElement(By.id("com.android.calculator2:id/digit_4")).click();
        driver.findElement(By.id("com.android.calculator2:id/eq")).click();

        MobileElement result = (MobileElement) driver.findElementById("com.android.calculator2:id/result");

        Assert.assertEquals("bad division", "2", result.getText());

    }


    @After
    public void tearDown() {
        driver.quit();
    }


}