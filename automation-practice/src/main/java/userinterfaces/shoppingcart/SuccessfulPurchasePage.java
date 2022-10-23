package userinterfaces.shoppingcart;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class SuccessfulPurchasePage {

    public static final Target SUCCESSFUL_PURCHASE_TITLE = Target.the("SUCCESSFUL PURCHASE TITLE").located(By.xpath("//*[@class='dark' and contains(text(),'Your order on My Store is complete.')]"));
    public static final Target SUCCESSFUL_PURCHASE_INFO_LABEL = Target.the("SUCCESSFUL PURCHASE INFO LABEL").located(By.xpath("//strong[ contains(text(),'Your order will be sent as soon as we receive payment.')]"));
    public static final Target BACK_HOME_BUTTON = Target.the("BACK HOME BUTTON").located(By.xpath("//*[ @title='Back to orders']"));

}
