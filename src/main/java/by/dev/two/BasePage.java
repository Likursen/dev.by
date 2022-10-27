package by.dev.two;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public abstract class BasePage {
    protected static final Duration WAIT_TIMEOUT_SECONDS = Duration.ofSeconds(15);
    protected WebDriver webDriver = WebDriverSingleton.getWebDriver();

    public BasePage() {
        PageFactory.initElements(webDriver, this);
    }

    protected void waitForVisibilityOfElement(WebElement webElement) {
        new WebDriverWait(webDriver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.visibilityOf(webElement));
    }

    protected void pageRefresh() {
        do {
            webDriver.get(webDriver.getCurrentUrl());
        } while (!webDriver.findElements(By.xpath("//a[@class='error-page__logo']")).isEmpty());
    }
}