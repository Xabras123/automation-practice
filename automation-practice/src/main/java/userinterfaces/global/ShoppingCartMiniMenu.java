package userinterfaces.global;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class ShoppingCartMiniMenu {

    public static final Target CHECK_OUT_BUTTON = Target.the("SHOPPING CART MENU BUTTON").located(By.xpath("//*[@class='icon-chevron-right right']"));

}
