package US_TST_03;

import Utility.BaseDriver;
import Utility.MyFunc;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class US_TST_03 extends BaseDriver {

    @Test
    void testApplyForCourseWithHomepageApplyButton(){
        driver.get("https://techno.study/tr/");



        WebElement basVurBtn = driver.findElement(By.xpath("(//td[text()='BAŞVUR'])[1]"));
        basVurBtn.click();

        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement bizeUlas = driver.findElement(By.xpath("//strong[text()='Bize ulaşın!']"));
        js.executeScript("arguments[0].scrollIntoView(true);", bizeUlas);

        WebElement firtName = driver.findElement(By.xpath("//input[@placeholder='Adı Soyadı']"));
        firtName.clear();
        MyFunc.Bekle(2);
        firtName.sendKeys("Test Braby");


        WebElement e_mail = driver.findElement(By.xpath("//input[@placeholder='Email']"));
        e_mail.sendKeys("Test_Team12_@gmail.com");


        WebElement phone = driver.findElement(By.xpath("//input[@type='tel']"));
        phone.sendKeys("99999999999");


        WebElement country = driver.findElement(By.xpath("//select[@name='country']"));
        country.click();


        Select ddMenu = new Select(country);
        ddMenu.selectByIndex(4);


        WebElement course = driver.findElement(By.xpath("//select[@name='course']"));
        course.click();

        Select ddMenu1 = new Select(course);
        ddMenu1.selectByIndex(1);

        WebElement nrdDuydun = driver.findElement(By.xpath("//select[@name='survey']"));
        Select ddMenu2 = new Select(nrdDuydun);
        ddMenu2.selectByIndex(1);

        WebElement prmsCd = driver.findElement(By.xpath("//input[@name='promo code']"));
        prmsCd.sendKeys("12345");

        WebElement checkBox = driver.findElement(By.xpath("//span[text()='Şartları']"));
        checkBox.click();
        MyFunc.Bekle(2);

        WebElement bsvrBtnClick = driver.findElement(By.xpath("//button[@type='submit']"));
        bsvrBtnClick.click();

        WebElement iframe = driver.findElement(By.id("captchaIframeBox"));
        driver.switchTo().frame(iframe);

        WebElement iframe1 = driver.findElement(By.xpath("//iframe[@title='reCAPTCHA']"));
        driver.switchTo().frame(iframe1);

        WebElement rbtChckBox = driver.findElement(By.xpath("//span[@id='recaptcha-anchor']"));
        rbtChckBox.click();

        MyFunc.Bekle(2);


      /*   WebElement shadowWebParent=driver.findElement(By.cssSelector("[href='chrome-extension://mpbjkejclgfgadiemmefgebjfooflfhl/src/solve/solver-button.css']"));
         SearchContext shadowContent=shadowWebParent.getShadowRoot();
         WebElement kabulbtn=shadowContent.findElement(By.cssSelector("button"));
         kabulbtn.click();*/

        WebElement bsvrMsg = driver.findElement(By.xpath("(//div/p/span[text()='Başvurunuz alınmıştır. Bilgilendirme emailinize gönderilmiştir.'])[2]"));
        System.out.println(bsvrMsg.getText());

        Assert.assertTrue(bsvrMsg.getText().contains("Başvurunuz "));



    }


}
