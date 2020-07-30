package ru.yandex_market;

import org.openqa.selenium.*;
import org.openqa.selenium.Point;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.util.List;

public class YaMarketPageFactory {
    private WebDriver chromeDriver;
    private final String xpathChooseCat = "//div [contains(.,\"%s\")]//div[@data-zone-data and contains(.,\"%s\")][last()]";
    private final String xpathOnStock = "//input[@name = \"В продаже\"]";
    private final String xpathSearchManuf = "//input[@class=\"_1JYTt02WxW\"]";
    private final String xpathCategory = "//div[@role=\"tablist\" and @class=\"SyJTASPsrT _3mU1ofltUh _17n6su90-I\"]//a";
    private final String xpathOpenCatalog = "//button [@id=\"27903767-tab\"]";
    private final String xpathShowMoreManuf = "//*[@data-autotest-id='7893318']//button [contains(.,\"Показать всё\")]";
    private final String xpathShowMoreButton = "//div[@class=\"pager-more__button pager-loader_preload\"]";
    private final String xpathForProduct = "//div[@class=\"_1NyIdwOZ6-\"]";
    private final String xpathManufacturer = "//*[@data-autotest-id='7893318']//li//div[@class=\"_16hsbhrgAf\"]";
    public final String xpathPreloader = "//div[@class=\"preloadable__preloader preloadable__preloader_visibility_visible preloadable__paranja\"]";
    public final String xpathPlateViewButton = "//input[@class=\"_1kPcEInxOi\" and @value = \"grid\"]";
    public final String xpathChosenManuf = "//a//label[@class=\"_2IwbFpEZn7 _1e7iX1B2oW\"]";

    @FindBy(xpath = xpathPreloader)
    WebElement preloader;

    @FindBy (xpath = xpathPlateViewButton)
    WebElement plateViewButton;

    @FindBy(xpath = xpathShowMoreButton)
    WebElement showMoreButton;

    @FindBy(xpath = xpathManufacturer)
    public WebElement oneManuf;

    @FindAll({
            @FindBy(xpath = xpathManufacturer)
    })
    public List<WebElement> manufList;

    @FindBy(xpath = xpathShowMoreManuf)
    public WebElement showMoreManuf;

    @FindBy(xpath = xpathOpenCatalog)
    public WebElement catalogButton;

    @FindAll({
            @FindBy(xpath = xpathCategory)
    })
    public List<WebElement> catList;

    @FindAll({
            @FindBy(xpath = xpathForProduct)
    })
    public List<WebElement> productList;

    @FindBy(xpath = xpathSearchManuf)
    public WebElement searchManuf;

    @FindBy(xpath = xpathChosenManuf)
    public WebElement chosenManuf;


    public WebElement findCategoryByParams(String catDev, String catName) {
        String xpathName = String.format(xpathChooseCat, catDev, catName);
        List<WebElement> foundElements = chromeDriver.findElements(By.xpath(xpathName));
        for (WebElement element : foundElements) {
            if (element.getText().equals(catName)) {
                return element;
            }
        }
        return null;
    }

    public void scrollTheManufList() {
        WebElement element = searchManuf;
        Point coordinates = element.getLocation();
        try {
            Robot robot = new Robot();
            robot.mouseMove(coordinates.getX() + 10, coordinates.getY() - 500);
            robot.mouseWheel(100);

        } catch (AWTException e) {
            e.printStackTrace();
        }
    }

    public WebElement findManufacturer(String manufacturer) {
        searchManuf.click();
        searchManuf.clear();
        searchManuf.sendKeys(manufacturer);
        if (ifPreloaderExists()) {
            new WebDriverWait(chromeDriver, 5).until(ExpectedConditions.
                    invisibilityOf(chromeDriver.findElement(By.xpath(xpathPreloader))));
        }

        return chosenManuf;
    }

    public boolean ifShowMoreButtonExists() {
        try {
            WebElement element = chromeDriver.findElement(By.xpath(xpathShowMoreButton));
            if (element.isDisplayed()) {
                return true;
            }
        } catch (Exception e) {
            return false;
        }
        return false;
    }

    public boolean ifPreloaderExists() {
        try {
            chromeDriver.findElement(By.xpath(xpathPreloader));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public YaMarketPageFactory(WebDriver chromeDriver) {
        this.chromeDriver = chromeDriver;
        PageFactory.initElements(chromeDriver, this);
    }


}

