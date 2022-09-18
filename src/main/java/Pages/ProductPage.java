package Pages;
import Base.BaseStepMethod;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.testng.asserts.SoftAssert;

public class ProductPage extends BaseStepMethod {
    private static final Logger LOGGER= LogManager.getLogger(ProductPage.class);
    private static final By TXT_PRODUCTPAGE_FIRSTPRODUCT =By.xpath("//h3[1]");
    private static final By TXT_PRODUCTPAGE_PRODUCTCOLOUR =By.xpath("//div[@class='selected-variant-text']");
    private static final By BTN_PRODUCTPAGE_CART_ADD_BUTTON =By.xpath("(//button[@class='add-to-basket button green block with-icon js-add-basket'])");
    private static final By BTN_PRODUCTPAGE_VIEW_CART_BUTTON =By.xpath("(//a[@class='go-to-shop'])");
    public void clickTo_First_product(){
        LOGGER.info("Dizalti çoraba tıklandı");
            clickElement(TXT_PRODUCTPAGE_FIRSTPRODUCT);
    }
    public void verifyToProduct_Colour(){
        LOGGER.info("renkten emin olundu");
              waitFor(2);
        SoftAssert sf=new SoftAssert();
        sf.assertTrue(getTextElement(TXT_PRODUCTPAGE_PRODUCTCOLOUR).contains("SİYAH"));
        sf.assertAll("siyah çorap seçildi");
    }
    public void click_To_AddToCart_Button(){
        LOGGER.info("sepete eklendi");
        clickElement(BTN_PRODUCTPAGE_CART_ADD_BUTTON);
    }
    public void click_To_View_Cart_Button(){
        LOGGER.info("sepet görüntülendi");
        clickElement(BTN_PRODUCTPAGE_VIEW_CART_BUTTON);
    }
}
