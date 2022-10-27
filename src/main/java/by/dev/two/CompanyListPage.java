package by.dev.two;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class CompanyListPage extends BasePage {
    @FindBy(xpath = "//th[@class='t-left sorting']/strong[@class='icon-dev-user3']")
    private WebElement sortingButton;

    @FindBy(xpath = "//tbody[@role='alert']/tr/td[1]/a")
    private List<WebElement> companyLinks;

    @FindBy(xpath = "//div[contains(@class,'views-contacts')]//li[1]/span")
    private WebElement companyEmail;

    public CompanyListPage openPage() {
        webDriver.get("https://companies.devby.io/");
        waitForVisibilityOfElement(sortingButton);
        return this;
    }

    public CompanyListPage clickSort() {
        sortingButton.click();
        return this;
    }

    public CompanyPage openCompany(String url) {
        do {
            webDriver.get(url);
        } while (!webDriver.findElements(By.xpath("//a[@class='error-page__logo']")).isEmpty());
        waitForVisibilityOfElement(companyEmail);
        return new CompanyPage();
    }

    public LinkedList<String> getLinks() {
        assert companyLinks != null;
        return companyLinks.stream()
                .map(i -> i.getAttribute("href"))
                .collect(Collectors.toCollection(LinkedList::new));
    }
}