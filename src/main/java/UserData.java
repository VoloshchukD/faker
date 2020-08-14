public class UserData {
    private String name;
    private String adress;
    private String number;

    public UserData() {
        this.name = GenerateUserAction.faker.name().fullName();
        this.adress = GenerateUserAction.faker.address().zipCode() + " "
                + GenerateUserAction.faker.address().country() + " "
                + GenerateUserAction.faker.address().cityName()
                + GenerateUserAction.faker.address().streetSuffix()
                + GenerateUserAction.faker.address().streetName()
                + GenerateUserAction.faker.address().buildingNumber()
                + GenerateUserAction.faker.address().secondaryAddress();
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
