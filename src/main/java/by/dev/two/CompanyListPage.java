package by.dev.two;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class CompanyListPage extends BasePage {
    @FindBy(xpath = "(//th[@class='sorting']/strong[@data-sort])[2]")
    private WebElement sortingButton;

    @FindBy(xpath = "(//tbody[@role='alert']/tr/td[1]/a")
    private List<WebElement> companyLinks;

    private  LinkedList<String> companyLinksList = getLinks();

    public CompanyListPage openPage() {
        webDriver.get("https://companies.devby.io/");
        return this;
    }

    public CompanyListPage clickSort() {
        sortingButton.click();
        return this;
    }

    public CompanyPage openFirstCompanyPage() {
        webDriver.get(companyLinksList.getFirst());
        companyLinksList.removeFirst();
        return new CompanyPage();
    }

    private List<String> getLinks() {
        return companyLinks.stream()
                .map(i -> i.getAttribute("href"))
                .collect(Collectors.toList());
    }


}