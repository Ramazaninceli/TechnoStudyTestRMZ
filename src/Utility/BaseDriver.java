package Utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;

import java.time.Duration;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BaseDriver {

public static WebDriver driver;
public static WebDriverWait wait;

@BeforeClass

public static void Test(){

    Logger logger=Logger.getLogger("");
    logger.setLevel(Level.SEVERE);

    driver=new ChromeDriver();
    wait=new WebDriverWait(driver,Duration.ofSeconds(20));
    driver.manage().window().maximize();
    driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

}


    public static void BekleKapat(){

       MyFunc.Bekle(2);
       driver.quit();

    }


}
