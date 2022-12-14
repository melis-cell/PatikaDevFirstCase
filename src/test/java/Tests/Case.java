package Tests;

import Base.BaseTest;
import Pages.AllPages;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import java.lang.reflect.Method;


public class Case extends BaseTest {
    private static final Logger LOGGER= LogManager.getLogger(Case.class);
    @Test(description = "First Case - Patika.Dev - A101 ")
    public void case1(Method method) throws InterruptedException {
        AllPages allPages=new AllPages();
        allPages.mainPage().goTo_A101();
        allPages.mainPage().enterTo_Allow();
        allPages.mainPage().goToDizAltiCorap();
        allPages.productPage().clickTo_First_product();
        allPages.productPage().verifyToProduct_Colour();
        allPages.productPage().click_To_AddToCart_Button();
        allPages.productPage().click_To_View_Cart_Button();
        allPages.basketPage().click_To_sepeti_onayla_button();
        allPages.ordersCheckoutPage().click_To_UYE_OLMADAN_DEVAMET_Button();
        allPages.ordersCheckoutPage().send_Email();
        allPages.addressPage().click_To_adres_olustur();
        allPages.addressPage().set_To_Text_adress();
        allPages.addressPage().click_Kaydet_Devamet_button();
        allPages.paymentPage().verify_odeme_ekrani();
        allPages.paymentPage().click_To_Siparisi_Tamamla_Button();
        allPages.paymentPage().verify_Navigate_To_Odeme_Page();
        allPages.paymentPage().click_To_GARANTIPAY_Button();
        allPages.paymentPage().navigate_To_GARANTIPAY_Odeme_Ekrani();
        allPages.paymentPage().verify_To_GARANTIPAY_Odeme_Ekrani();
    }
}
