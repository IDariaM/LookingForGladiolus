package ru.yandex;

import service.Utils;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class YaSteps {
    private static final String packageName = "yaSearch";

    @Step("Checking that there are more than three results after search")
    public static void checkResultsQuantity(YaPage yaPage, WebDriver driver) {
        if(yaPage.getSearchResults().size() > 3){Assertions.assertTrue(true);}
        else {
            Utils.getScreenshot(driver, packageName);
            Assertions.assertTrue(false,"There are less than 3 results");
        }

    }

    @Step("Checking that there is {link} in results")
    public static void checkTheResultHasLink(WebDriver driver, YaPage yaPage, String link) {
        String xpathName = String.format("//li[@class=\"serp-item\"]//div//a[contains(.,'%s')]", link);
        WebElement element = driver.findElement(By.xpath(xpathName));
        Utils.getScreenshot(driver,element, packageName);
        Assertions.assertTrue(yaPage.getSearchResults().stream().anyMatch(x -> x.get("URL").contains(link)), "There isn't Wiki link");
    }
}

