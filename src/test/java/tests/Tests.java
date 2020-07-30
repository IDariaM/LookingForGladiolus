package tests;

import io.qameta.allure.Description;
import ru.yandex.YaSteps;
import ru.yandex.YaPage;
import ru.yandex.YaPageFactory;
import ru.yandex_market.YaMarketPage;
import ru.yandex_market.YaMarketPageFactory;
import ru.yandex_market.YaMarketSteps;
import service.WebDriverSettings;
import org.junit.jupiter.api.Test;


public class Tests extends WebDriverSettings {
    private YaPage yaPage;
    private YaPageFactory yaPageFactory;
    private YaMarketPage yaMarketPage;
    private YaMarketPageFactory yaMarketPageFactory;

    @Test
    @Description(value = "Yandex search test")

    public void checkSearchResultsYandex() {
        yaPageFactory = new YaPageFactory(chromeDriver);
        yaPage = new YaPage(chromeDriver, yaPageFactory);
        chromeDriver.get("https://yandex.ru/");
        yaPage.searchTheText("гладиолус");
        YaSteps.checkResultsQuantity(yaPage, chromeDriver);
        YaSteps.checkTheResultHasLink(chromeDriver, yaPage, "ru.wikipedia.org");
    }

    @Test
    @Description(value = "Yandex Market brands filter test")

    public void checkSmartphonesFilter() {
        yaMarketPageFactory = new YaMarketPageFactory(chromeDriver);
        yaMarketPage = new YaMarketPage(chromeDriver, yaMarketPageFactory);
        chromeDriver.get("https://market.yandex.ru/");
        yaMarketPage.openCatalogPreview();
//        yaMarketPage.chooseCategory("Зоотовары", "Аквариумы");
        yaMarketPage.chooseCategory("Электроника", "Смартфоны");
        yaMarketPage.plateView();
//        yaMarketPage.chooseManufacturer("Tetra");
        yaMarketPage.chooseManufacturer("Apple");
        yaMarketPage.showAllResults();
//        YaMarketSteps.checkBrand(yaMarketPageFactory, chromeDriver, "Tetra");
        YaMarketSteps.checkBrand(yaMarketPageFactory, chromeDriver, "Apple");

    }

}
