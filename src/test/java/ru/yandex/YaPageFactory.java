package ru.yandex;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class YaPageFactory {
    private WebDriver chromeDriver;

    private final String searchFieldLocator = "//*[@class = \"input__control input__input mini-suggest__input\"]";
    private final String searchButtonLocator = "//*[@class=\"search2__button\"]";
    private final String resultListLocator = "//li[@class=\"serp-item\"]//div/h2/a";


    public YaPageFactory(WebDriver chromeDriver) {
        this.chromeDriver = chromeDriver;
        PageFactory.initElements(chromeDriver, this);
    }

    @FindBy(xpath = searchFieldLocator)
    public WebElement searchField;

    @FindBy(xpath = searchButtonLocator)
    public WebElement searchButton;

    @FindAll({
            @FindBy(xpath = resultListLocator)
    })
    public List<WebElement> resultList;


}
