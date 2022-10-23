package questions.transversal;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.List;

import static net.serenitybdd.screenplay.questions.WebElementQuestion.the;
import static userinterfaces.shoppingcart.ItemAddedToShopingCartReward.CONTINUE_SHOPPING_BUTTON;
import static userinterfaces.shoppingcart.ItemAddedToShopingCartReward.PROCEED_TO_CHECKOUT_BUTTON;


public class AnItemSuccessfullyAddedToTheShoppingCartModalAppears implements Question<Boolean> {


    private String itemName;
    public AnItemSuccessfullyAddedToTheShoppingCartModalAppears(String itemName) {
        this.itemName = itemName;
    }


    @Override
    public Boolean answeredBy(Actor actor) {

        List<Target> AddItemToShoppingCartModalListElements = new ArrayList();
        String xpathString = "//*[@id='layer_cart_product_title'  and contains(text(), '"+ itemName  + "')]";
        Target ITEM_NAME_LABEL = Target.the("ITEM NAME LABEL").located(By.xpath(xpathString));
        AddItemToShoppingCartModalListElements.add(ITEM_NAME_LABEL);
        AddItemToShoppingCartModalListElements.add(CONTINUE_SHOPPING_BUTTON);
        AddItemToShoppingCartModalListElements.add(PROCEED_TO_CHECKOUT_BUTTON);

        return ElementsAppearOnScreen.onScreen(AddItemToShoppingCartModalListElements, actor);
    }

    public static AnItemSuccessfullyAddedToTheShoppingCartModalAppears forTheItemCalled(String itemName){
        return new AnItemSuccessfullyAddedToTheShoppingCartModalAppears(itemName);
    }
}
