package stepdefinitions.shoppingcart;

import interactions.TapTheButton;
import io.cucumber.java.Before;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.waits.Wait;
import org.openqa.selenium.By;
import questions.checkout.TheItemIsNoLongerOnTheCheckout;
import questions.transversal.AnItemSuccessfullyAddedToTheShoppingCartModalAppears;
import tasks.purchaseproduct.AddItemToTheShoppingCartFromMiniature;
import tasks.purchaseproduct.AddItemToTheShoppingCartFromPrevisualization;
import tasks.purchaseproduct.ManageItemFromCheckoutScreen;
import tasks.purchaseproduct.NavigateToTheCheckoutScreen;

import static model.entities.ManageCheckoutItemOptionsEnum.DELETE_ITEM;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;
import static net.serenitybdd.screenplay.questions.WebElementQuestion.the;
import static userinterfaces.shoppingcart.ItemAddedToShopingCartReward.CONTINUE_SHOPPING_BUTTON;

public class AddItemToShoppingCartStepDefinitions {





    @Before
    public void setTheStage(){
        OnStage.setTheStage(new OnlineCast());
    }



    @When("the user successfully adds an item called '(.*)' from the miniature to the shopping cart")
    public void theUserSuccessfullyAddsAnItemFromTheMiniatureToTheShoppingCart(String itemName) {
        theActorInTheSpotlight().attemptsTo(
                AddItemToTheShoppingCartFromMiniature.called(itemName)
        );
        theActorInTheSpotlight().remember("itemAddedToTheShoppingCart",itemName );
    }

    @Then("the user should see a reward modal stating that the element was successfully added to the shopping cart")
    public void theUserShouldSeeARewardModalStatingThatTheElementWasSuccessfullyAddedToTheShoppingCart() {
        theActorInTheSpotlight().should(seeThat(AnItemSuccessfullyAddedToTheShoppingCartModalAppears.forTheItemCalled(theActorInTheSpotlight().recall("itemAddedToTheShoppingCart"))));
    }

    @When("the user successfully adds an item called '(.*)' to the shopping cart from the item preview screen")
    public void theUserSuccessfullyAddsAnItemFromTheVisualizationScreenToTheShoppingCart(String itemName) {
        theActorInTheSpotlight().attemptsTo(
                AddItemToTheShoppingCartFromPrevisualization.called(itemName)
        );
        theActorInTheSpotlight().remember("itemAddedToTheShoppingCart",itemName );
    }


    @When("the user tries to add 2 times the same item to the shopping cart")
    public void theUserTriesToAdd2TimesTheSameItemToTheShoppingCart() {
        theActorInTheSpotlight().attemptsTo(
                AddItemToTheShoppingCartFromMiniature.called("Blouse"),
                TapTheButton.called(CONTINUE_SHOPPING_BUTTON),
                AddItemToTheShoppingCartFromMiniature.called("Blouse")
        );


    }

    @When("the user successfully deletes an item from the the shopping cart")
    public void theUserSuccessfullyDeletesAnItemFromTheTheShoppingCart() {


        theActorInTheSpotlight().remember("itemAddedToTheShoppingCart","Blouse");

        theActorInTheSpotlight().attemptsTo(
                AddItemToTheShoppingCartFromMiniature.called("Blouse"),
                TapTheButton.called(CONTINUE_SHOPPING_BUTTON),
                NavigateToTheCheckoutScreen.fromTheHeaderMenu(),
                ManageItemFromCheckoutScreen.by(DELETE_ITEM)
        );
    }

    @Then("the user should see that the item is no longer on the shopping cart")
    public void theUserShouldSeeThatTheItemIsNoLongerOnTheShoppingCart() {

        String itemName = theActorInTheSpotlight().recall("itemAddedToTheShoppingCart");

        theActorInTheSpotlight().should(seeThat(
                    TheItemIsNoLongerOnTheCheckout.called(itemName)

            ));
    }

    @When("the user successfully deletes all items from the the shopping cart")
    public void theUserSuccessfullyDeletesAllItemsFromTheTheShoppingCart() {
        // Write code here that turns the phrase above into concrete actions
        throw new cucumber.api.PendingException();
    }

    @Then("the user should no longer see any item on the shopping cart")
    public void theUserShouldNoLongerSeeAnyItemOnTheShoppingCart() {
        // Write code here that turns the phrase above into concrete actions
        throw new cucumber.api.PendingException();
    }

}
