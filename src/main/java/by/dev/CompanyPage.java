package by.dev;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CompanyPage extends BasePage {
    @FindBy(xpath = "//div[@class='left']/h1")
    private WebElement companyName;

    @FindBy(css = " div.sidebar-views-contacts.h-card.vcard > ul > li:nth-child(1)")
    private WebElement companyEmail;

    @FindBy(xpath = "//div[@class='sidebar-views-contacts h-card vcard']/ul/li[3]/a")
    private WebElement companySite;

    public String getName() {
        return companyName.getText();
    }

    public String getEmail() {
        return companyEmail.getText();
    }

    public String getSite() {
        return companySite.getText();
    }
}