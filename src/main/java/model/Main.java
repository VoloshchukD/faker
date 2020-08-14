package model;

import action.GenerateUserAction;

public class Main {
    public static void main(String[] args){
        GenerateUserAction generateUserAction = new GenerateUserAction();
        generateUserAction.run(args[0], args[1], args[2]);
    }
}
