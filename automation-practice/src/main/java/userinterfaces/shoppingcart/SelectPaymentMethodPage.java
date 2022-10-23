package userinterfaces.shoppingcart;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class SelectPaymentMethodPage {
    public static final Target PAYMENT_BY_BANK_WIRE_BUTTON = Target.the("PAYMENT BY BANK WIRE BUTTON").located(By.xpath("(//*[@class='payment_module'])[1]"));
    public static final Target PAYMENT_BY_CHECK_BUTTON = Target.the("PAYMENT BY CHECK BUTTON").located(By.xpath("(//*[@class='payment_module'])[2]"));

}
