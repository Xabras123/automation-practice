package questions.checkout;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.waits.Wait;
import org.openqa.selenium.By;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isNotPresent;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isPresent;
import static net.serenitybdd.screenplay.questions.WebElementQuestion.the;


public class TheItemIsNoLongerOnTheCheckout implements Question<Boolean> {



    private String itemName;
    public TheItemIsNoLongerOnTheCheckout(String itemName) {
        this.itemName = itemName;
    }



    @Override
    public Boolean answeredBy(Actor actor) {


        Target DELETE_BUTTON = Target.the("NAME INPUT").located(By.xpath("//*[@class='cart_delete text-center' and ./preceding-sibling::*[@class='cart_description' and ./child::*[@class and ./child::*[contains(text(), '"+ itemName + "')]]]]"));

        actor.attemptsTo(
                Wait.until(the(DELETE_BUTTON) , isNotPresent()).forNoLongerThan(10).seconds()
        );

        return !DELETE_BUTTON.resolveFor(actor).isPresent();
    }

    public static TheItemIsNoLongerOnTheCheckout called(String itemName){
        return new TheItemIsNoLongerOnTheCheckout(itemName);
    }
}
