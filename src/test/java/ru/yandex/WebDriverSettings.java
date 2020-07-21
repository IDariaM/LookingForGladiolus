package ru.yandex;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class WebDriverSettings {
    static WebDriver chromeDriver;
    static YaPage yaPage;
    static YaPageFactory pageFactory;

    @BeforeAll
    public static void beforeStart() {
        chromeDriver = new ChromeDriver();
//        System.setProperty("webdriver.chrome.driver",System.getenv("CHROME_DRIVER"));
        pageFactory = new YaPageFactory(chromeDriver);
        yaPage = new YaPage(chromeDriver, pageFactory);
        chromeDriver.manage().window().maximize();
        chromeDriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    @AfterAll
    public static void atTheEnd() {
        chromeDriver.quit();
    }
}
