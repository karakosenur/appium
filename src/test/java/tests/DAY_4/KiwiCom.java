package tests.DAY_4;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.offset.PointOption;
import org.aspectj.weaver.ast.And;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.KiwiPage;
import utilities.Driver;

public class KiwiCom {




    // Trip type,one way olarak secilir
    // kalkis ulkesi secenegine tiklanir ve default olan ulke kaldirilir
    // kalkis yapilacak ulke/sehir girilir ve sec e tiklanir
    // varis ulkesi secenegine tiklanir ve gidilecek ulke girilir
    // gidis tarihi mayis ayinin 21 i olarak secilir ve set date e tiklanir
    // search butonuna tiklanir
    // en  ucuz ve aktarmasiz filtrelemeleri yapilir
    // gelen bilet fiyati kaydedilir ve kullanicin telefonuna sms olarak gonderilir

    AndroidDriver<AndroidElement>driver =Driver.getAndroidDriver();
    KiwiPage kiwi=new KiwiPage();
    TouchAction touchAction=new TouchAction<>(driver);
    @Test
    public void kiwiTest() throws InterruptedException {
        // uygulamanin yuklendigi dogrulanir
        Assert.assertTrue(driver.isAppInstalled("com.skypicker.main"));

        // uygulamanin basariyla acildigi dogrulanir
        AndroidElement guest=driver.findElementByXPath("//*[@text='Continue as a guest']");
        Assert.assertTrue(kiwi.misafir.isDisplayed());

        // misafir olarak devam et e tiklanir
        kiwi.misafir.click();

        // ardinda gelecek olan 3 adimada yesil butona basilarak devam edilir
        for (int i = 0; i < 3; i++) {
            touchAction.press(PointOption.point(500,1813)).release().perform();
            Thread.sleep(2000);
        }


    }



}
