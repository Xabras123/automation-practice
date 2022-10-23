package userinterfaces.shoppingcart;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class ShippingInformationPage {
    public static final Target PROCEED_TO_CHECKOUT_BUTTON = Target.the("PROCEED TO CHECKOUT BUTTON").located(By.xpath("//*[@class='button btn btn-default standard-checkout button-medium']"));
    public static final Target TERMS_AND_CONDITIONS_BUTTON = Target.the("TERMS AND CONDITIONS BUTTON").located(By.xpath("//*[@id='uniform-cgv']"));

}
