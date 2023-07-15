package tests;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class ArabamComTest {
    AndroidDriver<AndroidElement> driver;//Android driverlar için kullanilmasi gereken driver

    @BeforeTest
    public void arabamTestSetUp() throws MalformedURLException {

        // kullanici gerekli kurulumlari yapar
        DesiredCapabilities capabilities=new DesiredCapabilities();//yemek kitabını olusturduk

        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME,"Pixel");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION,"10.0");
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME,"UiAutomator2");
        capabilities.setCapability("appPackage","com.dogan.arabam");
        //hangi uygulama üzerşnde çalışmak istiyorsak apk infodan o uygulamanın degerini alıyoruz uygulamanın kimliği

        capabilities.setCapability("appActivity","com.dogan.arabam.presentation.feature.home.HomeActivity");
        //uygulamayı açtıktan sonra hangi sayfadan başlayacağımız orn:anasayfa, profil vb. bu şekilde söylüyoruz (appActivity)
        //appPackage ve appActivity ikisini beraber kullanırız

        driver= new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    @Test
    public void arabamTest() throws InterruptedException {
        //uygulamanın başarılı bir şekşlde yüklendiği doğrulanır
        Assert.assertTrue(driver.isAppInstalled("com.dogan.arabam"));
        //uygulamanın başarılı bir şekilde açıldığı  doğrulanır
        AndroidElement arabamLogo=driver.findElementById("com.dogan.arabam:id/ivArabamLogo");
        Assert.assertTrue(arabamLogo.isDisplayed());

        // Arabam kac para bolumune tiklayalim
        AndroidElement arabamKacPara=driver.findElementById("com.dogan.arabam:id/clytPricePrediction");
        arabamKacPara.click();

        // Aracimin fiyatini merak ediyorum bolumunetiklayalim
        driver.findElementByXPath("//*[@text='Aracımın fiyatını merak ediyorum']").click();

        // Volkswagen markasini secelim
        Thread.sleep(2000);
        TouchAction touchAction=new TouchAction<>(driver);
        touchAction.press(PointOption.point(540,1964))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(350)))
                .moveTo(PointOption.point(536,1041)).release().perform();
        touchAction.press(PointOption.point(540,1964))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(150)))
                .moveTo(PointOption.point(536,1041)).release().perform();
        driver.findElementByXPath("//*[@text='Volkswagen']").click();
        // yil secimi yapalim
        driver.findElementByXPath("//*[@text='2018']").click();
        // model secimi yapalim
        driver.findElementByXPath("//*[@text='Passat']").click();
        // govde tipini secelim
        driver.findElementByXPath("//*[@text='Sedan']").click();
        // yakit tipini secelim
        driver.findElementByXPath("//*[@text='Benzin']").click();
        // vites tipini secelim
        driver.findElementByXPath("//*[@text='Yarı Otomatik']").click();
        // Versiyon secimi yapalim
        //touchAction.press(PointOption.point(235,753)).release().perform();
        driver.findElementByXPath("//*[@text='Passat 1.4 TSI ACT BMT Comfortline DSG  150hp  (2014 - 2019)']").click();
        // aracin km bilgilerini girelim
        Thread.sleep(2000);
        if (driver.isKeyboardShown()){
            driver.getKeyboard().pressKey("50000");
        }else {
            driver.findElementById("com.dogan.arabam:id/et_km").sendKeys("100000");
        }
        driver.findElementById("com.dogan.arabam:id/btn_price_prediction_submit").click();
        // aracin rengini secelim
        Thread.sleep(2000);
        touchAction.press(PointOption.point(540,1964))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(350)))
                .moveTo(PointOption.point(536,1041)).release().perform();
        driver.findElementByXPath("//*[@text='Siyah']").click();
        // opsiyel donanim (varsa) seecelim
        driver.findElementById("com.dogan.arabam:id/btnNext").click();
        // degisen bilgisi ekleyerek tramer kaydi belirtelim
        Thread.sleep(2000);
        driver.findElementById("com.dogan.arabam:id/ivRightBackground").click();
        driver.findElementByXPath("//*[@text='Boyalı']").click();

        Thread.sleep(2000);

        //touchAction.press(PointOption.point(540,2025)).release().perform();
        driver.findElementById("com.dogan.arabam:id/btnNext").click();
        Thread.sleep(2000);

        driver.findElementByXPath("//*[@text='Bilmiyorum']").click();

        driver.findElementByXPath("com.dogan.arabam:id/btn_next").click();

        // aracimizin fiyatinin 500.000 tl den fazla oldugunu test edelim
        String aracinFiyati=driver.findElementById("com.dogan.arabam:id/tvAveragePrice").getText();
        aracinFiyati=aracinFiyati.replaceAll("\\D","");
        System.out.println(aracinFiyati);

        Assert.assertTrue(Integer.parseInt(aracinFiyati)>500000);
        // uygulamayi kapatalim
    }
}
