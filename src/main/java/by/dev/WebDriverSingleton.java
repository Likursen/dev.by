package by.dev;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class WebDriverSingleton {
    protected static final Duration WAIT_TIMEOUT_SECONDS = Duration.ofSeconds(15);
    private static WebDriver webDriver;

    private WebDriverSingleton() {
    }

    public static WebDriver getWebDriver() {
        if (webDriver == null) {
            WebDriverManager.chromedriver()
                    .setup();
            webDriver = new ChromeDriver();
            webDriver.manage()
                    .window()
                    .maximize();
            webDriver.manage()
                    .timeouts()
                    .implicitlyWait(WAIT_TIMEOUT_SECONDS);
        }
        return webDriver;
    }

    public static void driverQuit() {
        if (webDriver != null) {
            webDriver.quit();
            webDriver = null;
        }
    }
}