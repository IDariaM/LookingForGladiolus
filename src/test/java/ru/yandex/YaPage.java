package ru.yandex;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class YaPage {
    private WebDriver chromeDriver;
    private YaPageFactory pageFactory;

    public void searchTheText(String text) {
        WebElement searchInput = pageFactory.searchField;
        searchInput.click();
        searchInput.sendKeys("гладиолус");
        WebElement searchButton = pageFactory.searchButton;
        searchButton.click();
    }


    public YaPage(WebDriver chromeDriver, YaPageFactory pageFactory) {
        this.chromeDriver = chromeDriver;
        this.pageFactory = pageFactory;
    }
}
