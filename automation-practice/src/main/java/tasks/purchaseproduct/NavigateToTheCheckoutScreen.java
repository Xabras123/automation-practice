package tasks.purchaseproduct;


import exceptions.TheElementNotVisibleError;
import interactions.TapTheButton;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.MoveMouseToTarget;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static userinterfaces.global.AutomationPracticeHeader.SHOPPING_CART_MENU_BUTTON;
import static userinterfaces.global.ShoppingCartMiniMenu.CHECK_OUT_BUTTON;
import static userinterfaces.product.ProductSumaryPage.ADD_ITEM_TO_SHOPPING_CART_BUTTON;
import static userinterfaces.shoppingcart.ConfirmPurchasePage.CONFIRM_PURCHASE_BUTTON;

public class NavigateToTheCheckoutScreen implements Task {



    public NavigateToTheCheckoutScreen() {



    }

    public static Performable fromTheHeaderMenu() {
        return instrumented(NavigateToTheCheckoutScreen.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {


        try {
            theActorInTheSpotlight().attemptsTo(
                    new MoveMouseToTarget(SHOPPING_CART_MENU_BUTTON),
                    TapTheButton.called(CHECK_OUT_BUTTON)
            );
        } catch (Exception e) {
            throw new TheElementNotVisibleError(TheElementNotVisibleError.ELEMENT_NOT_VISIBLE
                    + e.getMessage(), e);
        }
    }
}
