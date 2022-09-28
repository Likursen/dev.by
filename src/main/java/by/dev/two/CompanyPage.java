package by.dev.two;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CompanyPage extends BasePage {
    @FindBy(xpath = "//div[@class='left']/h1")
    private WebElement companyName;

    @FindBy(xpath = "//div[contains(@class,'views-contacts')]//li[1]/span[contains(text(), '@')]")
    private WebElement companyEmail;

    @FindBy(xpath = "//div[@class='sidebar-views-contacts h-card vcard']/ul/li[3]/a")
    private WebElement companyURL;

    public String getName() {
        return companyName.getText();
    }

    public String getEmail() {
        try {
            waitForVisibilityOfElement(companyEmail);
        } catch (NoSuchElementException exception) {
            webDriver.get(webDriver.getCurrentUrl());
        }
        waitForVisibilityOfElement(companyEmail);
        return companyEmail.getText();
    }

    public String getSite() {
        return companyURL.getText();
    }

    public void closeTab(){
        webDriver.close();
    }
}