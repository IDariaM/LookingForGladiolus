package ru.yandex;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class WebDriverSettings {
    WebDriver chromeDriver;
    YaPage yaPage;
    YaPageFactory pageFactory;

    @BeforeEach
    public void beforeStart() {
        chromeDriver = new ChromeDriver();
//        System.setProperty("webdriver.chrome.driver",System.getenv("CHROME_DRIVER"));
        pageFactory = new YaPageFactory(chromeDriver);
        yaPage = new YaPage(chromeDriver, pageFactory);
        chromeDriver.manage().window().maximize();
        chromeDriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    @AfterEach
    public void atTheEnd() {
        chromeDriver.quit();
    }
}
