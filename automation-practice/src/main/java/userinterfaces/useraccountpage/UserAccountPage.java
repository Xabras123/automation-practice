package userinterfaces.useraccountpage;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class UserAccountPage {

    public static final Target ACCOUNT_LISTS = Target.the("ACCOUNT LISTS").located(By.xpath("//*[@class='myaccount-link-list']"));

}
