package userinterfaces.loginpage;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class LoginPage {

    public static final Target USERNAME_INPUT = Target.the("TEXT INPUT FOR THE USERNAME CREDENTIALS").located(By.xpath("//*[@id='email']"));
    public static final Target PASSWORD_INPUT = Target.the("TEXT INPUT FOR THE PASSWORD CREDENTIALS").located(By.xpath("//*[@id='passwd']"));
    public static final Target LOGIN_BUTTON = Target.the("LOGIN BUTTON").located(By.xpath("//*[@id='SubmitLogin']"));


}
