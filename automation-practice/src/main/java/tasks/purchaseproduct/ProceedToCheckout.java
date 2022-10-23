package tasks.purchaseproduct;


import exceptions.TheElementNotVisibleError;
import interactions.TapTheButton;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static userinterfaces.shoppingcart.CheckoutInformationPage.PROCEED_TO_CHECKOUT_BUTTON;
import static userinterfaces.shoppingcart.ConfirmPurchasePage.CONFIRM_PURCHASE_BUTTON;

public class ProceedToCheckout implements Task {



    public ProceedToCheckout() {



    }

    public static Performable onTheShoppingCartScreen() {
        return instrumented(ProceedToCheckout.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {


        try {
            theActorInTheSpotlight().attemptsTo(
                    TapTheButton.called(PROCEED_TO_CHECKOUT_BUTTON)
            );
        } catch (Exception e) {
            throw new TheElementNotVisibleError(TheElementNotVisibleError.ELEMENT_NOT_VISIBLE
                    + e.getMessage(), e);
        }
    }
}
