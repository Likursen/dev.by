package by.dev;

import org.testng.annotations.AfterMethod;

public abstract class BaseTest {

    @AfterMethod
    public void afterTest() {
        WebDriverSingleton.driverQuit();
    }
}

