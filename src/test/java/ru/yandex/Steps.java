package ru.yandex;

import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Steps {
    @Step("Проверка, что в выдаче по запросу более трёх пунктов")
    public static void checkResultsQuantity(YaPage yaPage, WebDriver driver) {
        if(yaPage.getSearchResults().size() > 3){Assertions.assertTrue(true);}
        else {
            Utils.getScreenshot(driver);
            Assertions.assertTrue(false,"There are less than 3 results");
        }

    }

    @Step("В выдаче результатов есть ссылка на {link}")
    public static void checkTheResultHasLink(WebDriver driver, YaPage yaPage, String link) {
        String xpathName = String.format("//li[@class=\"serp-item\"]//div//a[contains(.,'%s')]", link);
        WebElement element = driver.findElement(By.xpath(xpathName));
        Utils.getScreenshot(driver,element);
        Assertions.assertTrue(yaPage.getSearchResults().stream().anyMatch(x -> x.get("URL").contains(link)), "There isn't Wiki link");
    }
}

