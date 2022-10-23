package userinterfaces.shoppingcart;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class CheckoutInformationPage {
    public static final Target PROCEED_TO_CHECKOUT_BUTTON = Target.the("PROCEED TO CHECKOUT BUTTON").located(By.xpath("//*[@class='button btn btn-default standard-checkout button-medium']"));
}
