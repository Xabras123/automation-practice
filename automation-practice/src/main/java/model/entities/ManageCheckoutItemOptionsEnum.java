package model.entities;

public class ManageCheckoutItemOptionsEnum {
    public static final String DELETE_ITEM = ("Delete item");
    public static final String ADD_ITEM = ("Add item");
    public static final String SUBTRACT_ITEM = ("Subtract item");
    public static final String SEE_ITEM = ("see item");



    private String value;

    ManageCheckoutItemOptionsEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

}
