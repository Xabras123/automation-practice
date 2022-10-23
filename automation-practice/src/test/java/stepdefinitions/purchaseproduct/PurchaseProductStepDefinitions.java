package stepdefinitions.purchaseproduct;

import interactions.TapTheButton;
import io.cucumber.java.Before;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import questions.checkout.ItWasRedirectedToTheSuccessfulPaymentScreen;
import tasks.purchaseproduct.*;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static userinterfaces.shoppingcart.ItemAddedToShopingCartReward.CONTINUE_SHOPPING_BUTTON;
import static userinterfaces.shoppingcart.SuccessfulPurchasePage.BACK_HOME_BUTTON;

public class PurchaseProductStepDefinitions {





    @Before
    public void setTheStage(){
        OnStage.setTheStage(new OnlineCast());
    }



    @When("the user successfully purchases items from the store")
    public void theUserSuccessfullyPurchasesItemsFromTheStore() {
        String paymentOption = null;
        theActorInTheSpotlight().attemptsTo(
                TapTheButton.called(CONTINUE_SHOPPING_BUTTON),
                NavigateToTheCheckoutScreen.fromTheHeaderMenu(),
                ProceedToCheckout.onTheShoppingCartScreen(),
                ConfirmAddress.information(),
                ConfirmShipping.information(),
                SelectsThePaymentMethod.bySelectingTheOption(paymentOption),
                ConfirmOrder.payment()
        );
    }


    @Then("the user should be redirected to a successful payment screen")
    public void theUserShouldBeRedirectedToASuccessfulPaymentScreen() {

        theActorInTheSpotlight().should(seeThat(
                ItWasRedirectedToTheSuccessfulPaymentScreen.page()
        ));
        theActorInTheSpotlight().attemptsTo(
                TapTheButton.called(BACK_HOME_BUTTON)
        );
    }






}
