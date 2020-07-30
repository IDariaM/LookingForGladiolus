package ru.yandex_market;

import service.Utils;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class YaMarketSteps {
    private static final String packageName = "yaMarket";

    @Step("Checking that result contains only chosen brands")
    public static void checkBrand(YaMarketPageFactory yaMarketPageFactory, WebDriver driver, String... brands) {
        List<WebElement> prods = yaMarketPageFactory.productList;
        List<String> brandsList = new ArrayList<>();
        List<String> brandsNames = new ArrayList<>();
        Arrays.stream(brands).forEach(x -> brandsList.add(x.toLowerCase()));
        brandsList.forEach(System.out::println);
        prods.forEach(x -> brandsNames.add(x.getText()));
        for (String str : brandsNames) {
            if (!brandsList.contains(str.toLowerCase())) {
                Utils.getScreenshot(driver, packageName);
                Assertions.assertTrue(false, String.format("There should not be %s", str));
            }

        }
        Assertions.assertTrue(true);

    }
}
