package by.dev;

import by.dev.two.CompanyListPage;
import org.testng.annotations.Test;

public class Two extends BaseTest {
    @Test
    public void test() {
        CompanyListPage companyListPage = new CompanyListPage().openPage().clickSort();

        companyListPage.openFirstCompanyPage(1);

    }
}
