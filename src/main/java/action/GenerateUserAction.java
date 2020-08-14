package action;
import com.github.javafaker.Faker;
import model.UserData;
import exception.InvalidInputException;

import java.util.Locale;

public class GenerateUserAction {
    private String region;
    private int userDataNumber;
    private int errorNumber;
    private float errorNumberFloat = 0;
    public static Faker faker;
     StringBuilder s1 = new StringBuilder();


    private void setInputData(String region, String userDataNumber, String errorNumber)  {
        this.region = region.replace("_","-");
        faker = new Faker(new Locale(this.region));
        this.userDataNumber = Integer.parseInt(userDataNumber);
        if(errorNumber.length() == 1) {
            if (Integer.parseInt(errorNumber) < 0) throw new RuntimeException();
            this.errorNumber = Integer.parseInt(errorNumber);
            return;
        }
        if (errorNumber.charAt(1) == '.') {
            this.errorNumberFloat = Float.parseFloat(errorNumber);
        } else{
            this.errorNumber = Integer.parseInt(errorNumber);
        }
    }

    public void run(String region, String userDataNumber){
        run(region, userDataNumber, "0");
    }

    public void run(String region, String userDataNumber, String errorNumber){
        setInputData(region,userDataNumber, errorNumber);
        if( this.userDataNumber < 0
                || this.errorNumber < 0
                || this.errorNumberFloat < 0 ){
            throw new InvalidInputException();
        }

        if(this.errorNumber == 0){
            for (int i = 0; i < this.userDataNumber; i++) {
                new UserData();
            }
            System.out.println(new UserData());
        return;
        }

        MakeMistakeAction makeMistakeAction = new MakeMistakeAction(this.region);

        if(errorNumberFloat == 0) {
            for (int i = 0; i < this.userDataNumber; i++) {
                String s = makeMistakeAction.run(new UserData().toString(), this.errorNumber);
                System.out.println(s);
            }
        }

        if(errorNumberFloat != 0) {
            int t = (int) (this.userDataNumber * errorNumberFloat);
            for (int i = 0; i < t; i++) {
                String s = makeMistakeAction.run(new UserData().toString());
                System.out.println(s);
            }
            for (int i = 0; i < (this.userDataNumber - t); i++) {
                System.out.println(new UserData().toString());
            }
        }

    }

}