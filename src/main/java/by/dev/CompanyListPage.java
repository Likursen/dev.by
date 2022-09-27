package by.dev;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class CompanyListPage extends BasePage {

    @FindBy(xpath = "//tbody[@role='alert']/tr")
    private List<WebElement> companyItems;

    @FindBy(xpath = "(//th[@class='sorting']/strong[@data-sort])[2]")
    private WebElement sortingButton;

    public CompanyListPage openPage() {
        webDriver.get("https://companies.devby.io/");
        return this;
    }

    public int getCompaniesCount() {
        return companyItems.size();
    }

    public CompanyPage openCompany(int num) {
        Objects.requireNonNull(getBoardItem(num))
                .openCompany();
        sleep(8000);
        return new CompanyPage();
    }

    public void clickSort() {
        sortingButton.click();
    }

    private List<CompanyItem> getBoardItems() {
        sleep(2500);
        return companyItems.stream()
                .map(CompanyItem::new)
                .collect(Collectors.toList());
    }

    private CompanyItem getBoardItem(int number) {
        List<CompanyItem> boardItem = getBoardItems();
        if (!boardItem.isEmpty()) {
            return boardItem.get(number);
        }
        return null;
    }

    private static class CompanyItem extends BasePage {
        @FindBy(xpath = "./td[1]/a")
        private WebElement companyName;

        public CompanyItem(WebElement item) {
            super(item);
        }

        private void openCompany() {
            clickAndOpenInNewTab(companyName);
        }
    }
}
