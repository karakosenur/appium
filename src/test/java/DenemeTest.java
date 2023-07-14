import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class DenemeTest {

    AndroidDriver<AndroidElement> driver;//Android driverlar için kullanilmasi gereken driver
    //AppiumDriver<AndroidElement> driver2;//hem andrpid hem ios cihazlar için kullanılabilen driver
    //AppiumDriver<MobileElement> driver3;//ios icin kullanilir(android cihazlar icin de kullanilabilir)


    @Test
    public void deneme1() throws MalformedURLException {
        // kullanici gerekli kurulumlari yapar
        DesiredCapabilities capabilities=new DesiredCapabilities();//yemek kitabını olusturduk

        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME,"Pixel");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION,"10.0");
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME,"UiAutomator2");
        //eger ki kullandıgımız sürüm 6 ve üzeri ise automator 2 kyllanıyoruz

            // capabilities.setCapability(MobileCapabilityType.APP,"C:\\Users\\Nurullah Karaköse\\IdeaProjects\\appium\\Apps\\Calculator_8.4.1 (520193683)_Apkpure.apk");

        //app capabilityType bir uygulamayı yüklemek istediğimizde indirdigimiz apk dosyasının path uzantısını vererek o uygulama

        driver= new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        //driver.sendSMS("5555555555","selam");

        // kullanici gerekli kurulumlari yapar
        // uygulamanin yuklendigini dogrular(isInstalled)
        // uygulamanin acildigini dogrular
        // carpma,bolme,toplama,cikarma islemleri yaparak sonuclari dogrular
        // AC butonuna tiklayarak ana ekrani temizler



    }
}
