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
import static userinterfaces.product.ProductSumaryPage.ADD_ITEM_TO_SHOPPING_CART_BUTTON;


public class AddItemToTheShoppingCartFromPrevisualization implements Task {
    private String itemName;

    public AddItemToTheShoppingCartFromPrevisualization(String itemName) {

        this.itemName = itemName;

    }

    public static Performable called(String itemName) {
        return instrumented(AddItemToTheShoppingCartFromPrevisualization.class, itemName);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {



        String itemXPath = "//*[@class='product-name' and @title='"+ itemName + "']";
        Target ITEM_IMAGE_BUTTON = Target.the("ITEM IMAGE BUTTON").located(By.xpath(itemXPath));

        try{
            theActorInTheSpotlight().attemptsTo(
                    TapTheButton.called(ITEM_IMAGE_BUTTON),
                    TapTheButton.called(ADD_ITEM_TO_SHOPPING_CART_BUTTON)
            );
        } catch (Exception e) {
            throw new TheElementNotVisibleError(TheElementNotVisibleError.ELEMENT_NOT_VISIBLE
                    + e.getMessage(), e);

        }
    }

}
