package by.dev;

import org.testng.annotations.Test;

public class MyTest extends BaseTest {

    @Test
    public void getContacts() {
        CompanyListPage companyListPage = new CompanyListPage().openPage();
        companyListPage.clickSort();
        int companiesCount = companyListPage.getCompaniesCount() - 2;

        for (int i = 0; i < companiesCount; i++) {
            CompanyPage companyPage = companyListPage.openCompany(i);
            String name = companyPage.getName();
            String site = companyPage.getSite();
            String email = companyPage.getEmail();
            System.out.printf("%s; %s; %s\n", name, site, email);
            companyListPage.switchToPreviousTab();
        }
    }
}