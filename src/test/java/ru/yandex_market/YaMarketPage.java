package ru.yandex_market;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;


public class YaMarketPage {
    private WebDriver chromeDriver;
    private YaMarketPageFactory yaMarketPageFactory;

    public void openCatalogPreview() {
        yaMarketPageFactory.catalogButton.click();
    }

    public void chooseCategory(String catDev, String catName) {
        Actions actions = new Actions(chromeDriver);
        List<WebElement> elemList = yaMarketPageFactory.catList;
        for (WebElement el : elemList) {
            if (el.getText().equals(catDev)) {
                actions.moveToElement(el).build().perform();
            }
        }
        yaMarketPageFactory.findCategoryByParams(catDev, catName).click();

    }

    public void chooseManufacturer(String... manufacturer) {
        yaMarketPageFactory.showMoreManuf.click();

        for (String str : manufacturer) {
            yaMarketPageFactory.findManufacturer(str).click();
        }
    }

    public void showAllResults() {
        while (true) {
            if (yaMarketPageFactory.ifPreloaderExists()) {
                new WebDriverWait(chromeDriver, 10).until(ExpectedConditions.
                        invisibilityOf(chromeDriver.findElement(By.xpath(yaMarketPageFactory.xpathPreloader))));
            }
            if (yaMarketPageFactory.productList.size() % 48 == 0) {
                if (yaMarketPageFactory.ifShowMoreButtonExists()) {
                    yaMarketPageFactory.showMoreButton.click();
                } else break;

            } else break;

        }

    }

    public void plateView() {
        yaMarketPageFactory.plateViewButton.click();
    }

    public YaMarketPage(WebDriver chromeDriver, YaMarketPageFactory yaMarketPageFactory) {
        this.chromeDriver = chromeDriver;
        this.yaMarketPageFactory = yaMarketPageFactory;
    }


}
