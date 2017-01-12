package com.web.skynet.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by pmadan on 12/27/16.
 */
public class HomePage {

    WebDriver driver;
    @FindBy(xpath = ".//*[@id='search-products']/div/div[2]/div[1]/div/div/div[1]/div[1]/div[2]/div[1]/input")
    private WebElement destination;

    public HomePage(WebDriver driverType) {
        this.driver = driverType;
        PageFactory.initElements(driver, this);
    }



    public void setDestination(String destinationName)
    {
        destination.sendKeys(destinationName);
    }
}
