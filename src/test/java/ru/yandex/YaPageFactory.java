package ru.yandex;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class YaPageFactory {
    WebDriver chromeDriver;

    public YaPageFactory(WebDriver chromeDriver) {
        this.chromeDriver = chromeDriver;
        PageFactory.initElements(chromeDriver, this);
    }

    @FindBy(xpath = "//*[@class = \"input__control input__input mini-suggest__input\"]")
    public WebElement searchField;

    @FindBy(xpath = "//*[@class=\"search2__button\"]")
    public WebElement searchButton;

    @FindAll({
            @FindBy(xpath = "//li[@class=\"serp-item\"]//div/h2/a")
    })
    public List<WebElement> resultList;


}
