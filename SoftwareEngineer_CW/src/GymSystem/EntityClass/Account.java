package GymSystem.EntityClass;

import javafx.beans.property.SimpleStringProperty;

/**
 * <p>account</p>
 * <p>class for account
 * </p>
 * @author Yongfan Jin
 * @version 2.0
 */
public class Account {
    private final SimpleStringProperty accountNumProperty = new SimpleStringProperty();
    private final SimpleStringProperty  passwordProperty = new SimpleStringProperty();
    private final SimpleStringProperty usernameProperty = new SimpleStringProperty();
    private final SimpleStringProperty typeProperty = new SimpleStringProperty();
    private final SimpleStringProperty phoneNumProperty = new SimpleStringProperty();
    private final SimpleStringProperty sexualProperty = new SimpleStringProperty();


    public Account(String accNum, String username, String phoneNum,String sexual, String type) {
        accountNumProperty.set(accNum);
        usernameProperty.set(username);
        phoneNumProperty.set(phoneNum);
        sexualProperty.set(sexual);
        typeProperty.set(type);
    }

    public String getAccountNumProperty() {
        return accountNumProperty.get();
    }

    public SimpleStringProperty accountNumPropertyProperty() {
        return accountNumProperty;
    }

    public void setAccountNumProperty(String accountNumProperty) {
        this.accountNumProperty.set(accountNumProperty);
    }

    public String getPasswordProperty() {
        return passwordProperty.get();
    }

    public SimpleStringProperty passwordPropertyProperty() {
        return passwordProperty;
    }

    public void setPasswordProperty(String passwordProperty) {
        this.passwordProperty.set(passwordProperty);
    }

    public String getUsernameProperty() {
        return usernameProperty.get();
    }

    public SimpleStringProperty usernamePropertyProperty() {
        return usernameProperty;
    }

    public void setUsernameProperty(String usernameProperty) {
        this.usernameProperty.set(usernameProperty);
    }

    public String getTypeProperty() {
        return typeProperty.get();
    }

    public SimpleStringProperty typePropertyProperty() {
        return typeProperty;
    }

    public void setTypeProperty(String typeProperty) {
        this.typeProperty.set(typeProperty);
    }

    public String getPhoneNumProperty() {
        return phoneNumProperty.get();
    }

    public SimpleStringProperty phoneNumPropertyProperty() {
        return phoneNumProperty;
    }

    public void setPhoneNumProperty(String phoneNumProperty) {
        this.phoneNumProperty.set(phoneNumProperty);
    }

    public String getSexualProperty() {
        return sexualProperty.get();
    }

    public SimpleStringProperty sexualPropertyProperty() {
        return sexualProperty;
    }

    public void setSexualProperty(String sexualProperty) {
        this.sexualProperty.set(sexualProperty);
    }
}
