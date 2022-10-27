package by.dev;

import by.dev.two.CompanyListPage;
import by.dev.two.CompanyPage;
import org.testng.annotations.Test;

public class MyTest extends BaseTest {
    @Test
    public void test() {
        CompanyListPage companyListPage = new CompanyListPage()
                .openPage()
                .clickSort();
        sleep(3000);
        for (String link : companyListPage.getLinks()) {
            CompanyPage companyPage = companyListPage.openCompany(link);
            sleep(1000);
            System.out.println(companyPage.getCompanyInfo());

        }
    }
}