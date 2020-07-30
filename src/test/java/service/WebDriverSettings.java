package service;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class WebDriverSettings {
   protected WebDriver chromeDriver;


    @BeforeEach
    public void beforeStart() {
        chromeDriver = new ChromeDriver();
//        System.setProperty("webdriver.chrome.driver",System.getenv("CHROME_DRIVER"));
        chromeDriver.manage().window().maximize();
        chromeDriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

//    @AfterEach
//    public void atTheEnd() {
//        chromeDriver.quit();
//    }
}
