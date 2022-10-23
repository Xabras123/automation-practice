package model.entities;

public enum ErrorMessagesEnum {

    AUTHENTICATION_ERROR("Authentication failed.");


    private String value;

    ErrorMessagesEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

}
