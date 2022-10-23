package tasks.purchaseproduct;


import exceptions.TheElementNotVisibleError;
import interactions.TapTheButton;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static userinterfaces.shoppingcart.AddressInformationConfirmationPage.PROCEED_TO_CHECKOUT_BUTTON;
import static userinterfaces.shoppingcart.SelectPaymentMethodPage.PAYMENT_BY_BANK_WIRE_BUTTON;

public class SelectsThePaymentMethod implements Task {



    public SelectsThePaymentMethod() {



    }

    public static Performable bySelectingTheOption(String paymentOption) {
        return instrumented(SelectsThePaymentMethod.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {


        try {
            theActorInTheSpotlight().attemptsTo(
                    TapTheButton.called(PAYMENT_BY_BANK_WIRE_BUTTON)
            );
        } catch (Exception e) {
            throw new TheElementNotVisibleError(TheElementNotVisibleError.ELEMENT_NOT_VISIBLE
                    + e.getMessage(), e);
        }
    }
}
