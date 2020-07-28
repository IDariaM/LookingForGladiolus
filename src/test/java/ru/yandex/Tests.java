package ru.yandex;

import org.junit.jupiter.api.Test;


public class Tests extends WebDriverSettings {

    @Test
    public void checkSearchResults() {
        chromeDriver.get("https://yandex.ru/");
        yaPage.searchTheText("гладиолус");
        Steps.checkResultsQuantity(yaPage, chromeDriver);
        Steps.checkTheResultHasLink(chromeDriver, yaPage, "ru.wikipedia.org");
    }


}
