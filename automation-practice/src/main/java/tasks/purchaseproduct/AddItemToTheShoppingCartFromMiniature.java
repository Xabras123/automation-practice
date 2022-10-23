package tasks.purchaseproduct;


import exceptions.TheElementNotVisibleError;
import interactions.TapTheButton;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.MoveMouseToTarget;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;


public class AddItemToTheShoppingCartFromMiniature implements Task {
    private String itemName;

    public AddItemToTheShoppingCartFromMiniature(String itemName) {

        this.itemName = itemName;

    }

    public static Performable called(String itemName) {
        return instrumented(AddItemToTheShoppingCartFromMiniature.class, itemName);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {



        String itemXPath = "//*[@class='product-name' and @title='"+ itemName + "']";
        String addToShoppingCartXPath = "//*[@class='button ajax_add_to_cart_button btn btn-default' and ./parent::*[@class and ./preceding-sibling::*[@itemprop and ./preceding-sibling::*[@class and ./preceding-sibling::*[@itemprop and  ./child::*[@title='" +itemName + "']]]]]]";
        Target ITEM_IMAGE_BUTTON = Target.the("ITEM IMAGE BUTTON").located(By.xpath(itemXPath));
        Target ADD_ITEM_TO_SHOPPING_CART_BUTTON = Target.the("ADD ITEM TO SHOPPING CART BUTTON").located(By.xpath(addToShoppingCartXPath));

        try{
            theActorInTheSpotlight().attemptsTo(

                    new MoveMouseToTarget(ITEM_IMAGE_BUTTON),
                    TapTheButton.called(ADD_ITEM_TO_SHOPPING_CART_BUTTON)
            );
        } catch (Exception e) {
            throw new TheElementNotVisibleError(TheElementNotVisibleError.ELEMENT_NOT_VISIBLE
                    + e.getMessage(), e);

        }
    }

}
