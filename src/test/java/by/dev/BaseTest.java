package by.dev;

import by.dev.two.WebDriverSingleton;
import org.testng.annotations.AfterMethod;

public abstract class BaseTest {

    public void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @AfterMethod
    public void afterTest() {
        WebDriverSingleton.driverQuit();
    }
}