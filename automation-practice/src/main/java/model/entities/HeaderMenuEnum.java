package model.entities;

public class HeaderMenuEnum {
    public static final String SHOPPING_CART = ("shopping cart");
    public static final String ACCOUNT = ("account options");
    public static final String SIGN_IN = ("user options");
    public static final String SIGN_OUT = ("user options");
    public static final String SEARCH_BAR_BUTTON = ("user options");


    private String value;

    HeaderMenuEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

}
