package by.dev.two;

import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;

public abstract class BasePage {
    protected static final Duration WAIT_TIMEOUT_SECONDS = Duration.ofSeconds(15);
    protected WebDriver webDriver = WebDriverSingleton.getWebDriver();

    public BasePage() {
        PageFactory.initElements(webDriver, this);
    }

    protected void waitForElementToBeClickable(WebElement webElement) {
        new WebDriverWait(webDriver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.elementToBeClickable(webElement));
    }

    protected void waitForVisibilityOfElement(WebElement webElement) {
        new WebDriverWait(webDriver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.visibilityOf(webElement));
    }

    protected void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    protected void switchToSecondTab() {
        ArrayList<String> tabs2 = new ArrayList<>(webDriver.getWindowHandles());
        webDriver.switchTo()
                .window(tabs2.get(1));
    }

    protected void switchToFirstTab() {
        ArrayList<String> tabs2 = new ArrayList<>(webDriver.getWindowHandles());
        webDriver.close();
        webDriver.switchTo()
                .window(tabs2.get(0));
        sleep(1000);
    }
}