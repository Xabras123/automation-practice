package questions.logintothaccount;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.targets.Target;
import questions.transversal.ElementsAppearOnScreen;

import java.util.ArrayList;
import java.util.List;

import static userinterfaces.global.AutomationPracticeHeader.ACCESS_ACCOUNT_BUTTON;
import static userinterfaces.global.AutomationPracticeHeader.SING_OUT_BUTTON;
import static userinterfaces.useraccountpage.UserAccountPage.ACCOUNT_LISTS;


public class ItWasRedirectedToTheUserAccountScreen implements Question<Boolean> {


    public ItWasRedirectedToTheUserAccountScreen() {  }



    @Override
    public Boolean answeredBy(Actor actor) {

        List<Target> userAccountScreenElements = new ArrayList<>();
        userAccountScreenElements.add(ACCOUNT_LISTS);
        userAccountScreenElements.add(ACCESS_ACCOUNT_BUTTON);
        userAccountScreenElements.add(SING_OUT_BUTTON);

        return ElementsAppearOnScreen.onScreen(userAccountScreenElements, actor);
    }

    public static ItWasRedirectedToTheUserAccountScreen page(){
        return new ItWasRedirectedToTheUserAccountScreen();
    }
}
