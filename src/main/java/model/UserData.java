package model;
import action.GenerateUserAction;
import static action.GenerateUserAction.faker;

public class UserData {
    private String name;
    private String adress;
    private String number;

    public UserData() {
        this.name = faker.name().fullName();
        this.adress = faker.address().zipCode() + " "
                + faker.address().country() + " "
                + faker.address().cityName()
                + faker.address().streetSuffix()
                + faker.address().streetName()
                + faker.address().buildingNumber()
                + faker.address().secondaryAddress();
        this.number = GenerateUserAction.faker.phoneNumber().phoneNumber();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return name + "; " + adress + "; " + number;
    }

}
