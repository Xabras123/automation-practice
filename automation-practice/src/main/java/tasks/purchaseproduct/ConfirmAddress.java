package tasks.purchaseproduct;


import exceptions.TheElementNotVisibleError;
import interactions.TapTheButton;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static userinterfaces.shoppingcart.AddressInformationConfirmationPage.PROCEED_TO_CHECKOUT_BUTTON;

public class ConfirmAddress implements Task {



    public ConfirmAddress() {



    }

    public static Performable information() {
        return instrumented(ConfirmAddress.class);
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
