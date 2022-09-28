package by.dev;

import by.dev.two.WebDriverSingleton;
import org.testng.annotations.AfterMethod;

public abstract class BaseTest {

    @AfterMethod
    public void afterTest() {
        WebDriverSingleton.driverQuit();
    }
}

