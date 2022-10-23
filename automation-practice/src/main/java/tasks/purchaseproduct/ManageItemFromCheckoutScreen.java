package tasks.purchaseproduct;

import exceptions.TheElementNotVisibleError;
import interactions.NavigateThroughMenu;
import interactions.TapTheButton;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

import static model.entities.HeaderMenuEnum.SHOPPING_CART;
import static model.entities.ManageCheckoutItemOptionsEnum.*;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static userinterfaces.StoreHomeHeader.USER_OPTIONS_MENU_BUTTON;
import static userinterfaces.global.AutomationPracticeHeader.ACCESS_ACCOUNT_BUTTON;

public class ManageItemFromCheckoutScreen implements Task {

    private String actionToDo;

    public ManageItemFromCheckoutScreen(String actionToDo) {
        this.actionToDo = actionToDo;
    }

    public static Performable by(String navigationDestination) {
        return instrumented(ManageItemFromCheckoutScreen.class, navigationDestination);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        String itemName = actor.recall("itemAddedToTheShoppingCart");
        try {
            Target navigationDestinationTarget = theActorSelectsTheItemFromTheMenuToNavigateTo(actionToDo, itemName);
            actor.attemptsTo(
                    TapTheButton.called(navigationDestinationTarget)
            );
        } catch (Exception e) {
            throw new TheElementNotVisibleError(TheElementNotVisibleError.ELEMENT_NOT_VISIBLE
                    + e.getMessage(), e);
        }
    }

    private Target theActorSelectsTheItemFromTheMenuToNavigateTo(String actionToDo, String itemName) {

        Target DELETE_BUTTON = Target.the("NAME INPUT").located(By.xpath("//*[@class='cart_delete text-center' and ./preceding-sibling::*[@class='cart_description' and ./child::*[@class and ./child::*[contains(text(), '"+ itemName + "')]]]]"));
        Target ADD_QUANTITY_BUTTON = Target.the("ADD QUANTITY BUTTON").located(By.xpath(""));
        Target SUBTRACT_QUANTITY_BUTTON = Target.the("SUBTRACT QUANTITY BUTTON").located(By.xpath(""));
        Target IMAGE_BUTTON = Target.the("IMAGE BUTTON").located(By.xpath(""));


        switch((actionToDo)){

            case DELETE_ITEM:
                return DELETE_BUTTON;
            case ADD_ITEM:
                return ADD_QUANTITY_BUTTON;
            case SUBTRACT_ITEM:
                return SUBTRACT_QUANTITY_BUTTON;
            default:
                return IMAGE_BUTTON;

        }

    }
}
