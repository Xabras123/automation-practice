package userinterfaces.product;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class ProductSumaryPage {

    public static final Target ADD_ITEM_TO_SHOPPING_CART_BUTTON = Target.the("ADD ITEM TO SHOPPING CART BUTTON").located(By.xpath("//*[@id='add_to_cart']"));

}
