package Pages;

import Base.BaseStepMethod;
import Utilities.ConfigReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import static Base.BaseTest.driver;
public class MainPage extends BaseStepMethod {
    private static final Logger LOGGER= LogManager.getLogger(MainPage.class);
    private static final By BTN_COOKIES_ALLOW =By.xpath("(//button[@id='CybotCookiebotDialogBodyLevelButtonLevelOptinAllowAll'])");
       public void goTo_A101() {
        LOGGER.info("User go to " + "https://www.a101.com.tr/");
        driver.get("https://www.a101.com.tr/");
    }
    public void enterTo_Allow(){
        LOGGER.info("User allowed cookies");
        clickElement(BTN_COOKIES_ALLOW);
    }
    public void goToDizAltiCorap(){
        LOGGER.info("User navigate to " + ConfigReader.getProperty("https://www.a101.com.tr/giyim-aksesuar/dizalti-corap/"));
       driver.navigate().to("https://www.a101.com.tr/giyim-aksesuar/dizalti-corap/");
    }
}
