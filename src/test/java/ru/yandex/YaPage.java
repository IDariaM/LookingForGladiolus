package ru.yandex;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class YaPage {
    private WebDriver chromeDriver;
    private YaPageFactory pageFactory;
    private List<Map<String, String>> searchResults;

    public void searchTheText(String text) {
        WebElement searchInput = pageFactory.searchField;
        searchInput.click();
        searchInput.sendKeys(text);
        WebElement searchButton = pageFactory.searchButton;
        searchButton.click();
    }


    public List<Map<String, String>> getSearchResults() {
        searchResults = new ArrayList<>();
        List<WebElement> elements = pageFactory.resultList;
        for (WebElement element : elements) {
            searchResults.add(Map.of(
                    "URLText", element.getText(),
                    "URL", element.getAttribute("href")
            ));
        }
        return searchResults;
    }

    public YaPage(WebDriver chromeDriver, YaPageFactory pageFactory) {
        this.chromeDriver = chromeDriver;
        this.pageFactory = pageFactory;
    }
}
