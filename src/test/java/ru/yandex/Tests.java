package ru.yandex;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Tests extends WebDriverSettings {

    @Test
    public void checkSearchResultsQuantity() {
        chromeDriver.get("https://yandex.ru/");
        yaPage.searchTheText("гладиолус");
        List<WebElement> resultList = pageFactory.getResultList();
        Assertions.assertTrue(resultList.size() > 3, "There are less than 3 results");
    }

    @Test
    public void checkSearchResultsHasWiki() {
        chromeDriver.get("https://yandex.ru/");
        yaPage.searchTheText("гладиолус");
        List<WebElement> resultList = pageFactory.getResultList();
        Assertions.assertTrue(resultList.stream().anyMatch(x -> x.getText().contains("ru.wikipedia.org")), "There isn't Wiki link");

    }
}
