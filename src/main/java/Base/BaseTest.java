package Base;


import Utilities.ConfigReader;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.opera.OperaOptions;
import org.testng.annotations.*;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;


public class BaseTest {
    private static final Logger LOGGER = LogManager.getLogger(BaseTest.class);
    public static WebDriver driver;

    public synchronized static WebDriver getDriver() {
        return driver;
    }

    public synchronized static WebDriver setDriver(String browser) {

        if (driver == null) {
            browser = browser == null ? ConfigReader.getProperty("chrome") : browser;


                    ChromeOptions options = new ChromeOptions();
                    options.addArguments("--incognito");
                    options.addArguments("--start-maximized");
                    options.addArguments("--ignore-certificate-errors");
                    options.addArguments("--allow-insecure-localhost");
                    options.addArguments("--acceptInsecureCerts");
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver(options);


        }
        return driver;
    }
    @BeforeClass
    @Parameters(value = {"browser"})
    public synchronized void setupBrowser(@Optional String browser) throws MalformedURLException {
        driver = setDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }
    @AfterClass
    public synchronized void closeBrowser() throws Exception {
        if (driver != null) {
            driver.close();
        }
        driver = null;
    }
}
