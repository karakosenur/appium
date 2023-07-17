package tests.DAY_3;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.testng.annotations.Test;
import utilities.Driver;


public class DriverDeneme {
    AndroidDriver<AndroidElement> driver= Driver.getAndroidDriver();

    @Test
    public void test01(){
        System.out.println(driver.getDeviceTime());


    }
}