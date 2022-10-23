package userinterfaces.shoppingcart;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class ItemAddedToShopingCartReward {
    public static final Target CONTINUE_SHOPPING_BUTTON = Target.the("CONTINUE SHOPPING BUTTON").located(By.xpath("//*[@class='continue btn btn-default button exclusive-medium']"));
    public static final Target PROCEED_TO_CHECKOUT_BUTTON = Target.the("PROCEED TO CHECKOUT BUTTON").located(By.xpath("//*[@class='btn btn-default button button-medium']"));


}
