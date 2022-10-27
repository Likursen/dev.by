package by.dev.two;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CompanyPage extends BasePage {
    @FindBy(xpath = "//div[@class='left']/h1")
    private WebElement companyName;

    @FindBy(xpath = "//div[contains(@class,'views-contacts')]//li[1]/span")
    private WebElement companyEmail;

    @FindBy(xpath = "//div[@class='sidebar-views-contacts h-card vcard']//a")
    private WebElement companyURL;

    public Company getCompanyInfo() {
        return new Company()
                .setName(getName())
                .setEmail(getEmail())
                .setUrl(getUrl());
    }

    private String getName() {
        return companyName.getText();
    }

    private String getEmail() {
        int i = 0;
        while (!companyEmail.getText().contains("@")) {
            if (i <= 5) {
                pageRefresh();
                i++;
            } else break;
        }
        return companyEmail.getText();
    }

    private String getUrl() {
        return companyURL.getText();
    }
}