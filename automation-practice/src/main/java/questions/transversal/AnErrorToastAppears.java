package questions.transversal;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.waits.Wait;
import org.openqa.selenium.By;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isPresent;
import static net.serenitybdd.screenplay.questions.WebElementQuestion.the;


public class AnErrorToastAppears implements Question<Boolean> {


    private String errorMessage;
    public AnErrorToastAppears(String statingThat) {
        this.errorMessage = statingThat;
    }



    @Override
    public Boolean answeredBy(Actor actor) {


        String xpathString = "//*[@class='alert alert-danger']//ol//li[contains(text(),'"+ errorMessage  + "')]";

        Target ERROR_MESSAGE_TOAST = Target.the("ERROR MESSAGE TOAST").located(By.xpath(xpathString));
        actor.attemptsTo(
                Wait.until(the(ERROR_MESSAGE_TOAST) , isPresent()).forNoLongerThan(10).seconds()
        );

        return ERROR_MESSAGE_TOAST.resolveFor(actor).isPresent();
    }

    public static AnErrorToastAppears onScreen(String statingThat){
        return new AnErrorToastAppears(statingThat);
    }
}
