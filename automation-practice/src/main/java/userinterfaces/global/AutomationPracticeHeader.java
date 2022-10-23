package userinterfaces.global;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class AutomationPracticeHeader {

    public static final Target ACCESS_ACCOUNT_BUTTON = Target.the("ACCESS ACCOUNT BUTTON").located(By.xpath("//*[@class='account']"));
    public static final Target SING_OUT_BUTTON = Target.the("SING OUT BUTTON").located(By.xpath("//*[@class='logout']"));
    public static final Target SIGN_IN_BUTTON = Target.the("SIGN IN BUTTON").located(By.xpath("//*[@class='header_user_info']"));
    public static final Target SHOPPING_CART_MENU_BUTTON = Target.the("SHOPPING CART MENU BUTTON").located(By.xpath("//*[@title='View my shopping cart']"));
    public static final Target SEARCH_BAR_INPUT = Target.the("SEARCH_BAR_INPUT").located(By.xpath("//*[@id='search_query_top']"));
    public static final Target SEARCH_BUTTON = Target.the("SEARCH BUTTON").located(By.xpath("//*[@id='searchbox']/button"));
    public static final Target HOME_BUTTON = Target.the("HOME BUTTON").located(By.xpath("//*[@title='My Store' and ./parent::*[@id='header_logo']]"));

}
