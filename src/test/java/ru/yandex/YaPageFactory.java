package ru.yandex;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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

    @FindBy(id = "search-result")
    public WebElement listElement;

    public List<WebElement> getResultList() {
        return listElement.findElements(By.xpath("//*[@class=\"serp-item\"]"));
    }


}
