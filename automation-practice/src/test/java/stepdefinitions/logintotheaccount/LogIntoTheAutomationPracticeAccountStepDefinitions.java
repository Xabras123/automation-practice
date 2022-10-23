package stepdefinitions.logintotheaccount;

import interactions.TapTheButton;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import model.entities.login.AuthenticationData;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.thucydides.core.annotations.Managed;
import org.openqa.selenium.WebDriver;
import questions.logintothaccount.ItWasRedirectedToTheUserAccountScreen;
import questions.transversal.AnErrorToastAppears;
import tasks.logintotheaccount.FillTheLoginForm;
import userinterfaces.HomePage;

import static model.entities.ErrorMessagesEnum.AUTHENTICATION_ERROR;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static userinterfaces.global.AutomationPracticeHeader.HOME_BUTTON;
import static userinterfaces.global.AutomationPracticeHeader.SIGN_IN_BUTTON;

public class LogIntoTheAutomationPracticeAccountStepDefinitions {


    @Managed(driver = "chrome")
    private WebDriver browser;
    private HomePage homePage = new HomePage();



    @Before
    public void setTheStage(){
        OnStage.setTheStage(new OnlineCast());
    }



    @Given("that the user is on the Automation Practice login screen")
    public void thatTheUserIsOnTheAutomationPracticeLoginScreen() {
        theActorCalled("user").can(BrowseTheWeb.with(browser));
        theActorInTheSpotlight().wasAbleTo(Open.browserOn(homePage));
    }

    @When("that the user authenticates with the username (.*) and the password (.*)")
    public void thatTheUserAuthenticatesWithTheUsernameStandard_userAndThePasswordSecret_sauce(String userName, String userPassword) {

        AuthenticationData theAuthenticationData = new AuthenticationData(userName, userPassword);
        theActorInTheSpotlight().attemptsTo(
                TapTheButton.called(SIGN_IN_BUTTON),
                FillTheLoginForm.with(theAuthenticationData)
        );
    }


    @When("that the user logs into its Automation practice with the username '(.*)' and the password '(.*)'")
    public void thatTheUserAuthenticatesWithTheUsernameStandardUserAndThePasswordSecret_sauce(String userName, String userPassword) {
        theActorCalled("user").can(BrowseTheWeb.with(browser));
        theActorInTheSpotlight().wasAbleTo(Open.browserOn(homePage));
        AuthenticationData theAuthenticationData = new AuthenticationData(userName, userPassword);
        theActorInTheSpotlight().attemptsTo(
                TapTheButton.called(SIGN_IN_BUTTON),
                FillTheLoginForm.with(theAuthenticationData),
                TapTheButton.called(HOME_BUTTON)

                );
    }

    @Then("the user should see it was redirected to the user account page")
    public void theUserShouldSeeItWasRedirectedToTheUserAccountPage() {
        theActorInTheSpotlight().should(seeThat(ItWasRedirectedToTheUserAccountScreen.page()));
    }

    @Then("the user should see an error popup appears stating about the credentials error")
    public void theUserShouldSeeAnErrorPopupAppearsStatingAboutTheCredentialsError() {
        theActorInTheSpotlight().should(seeThat(AnErrorToastAppears.onScreen(AUTHENTICATION_ERROR.getValue())));
    }



}
