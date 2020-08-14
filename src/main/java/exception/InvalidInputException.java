package exception;

public class InvalidInputException extends RuntimeException{
    public InvalidInputException() {
        System.out.println("Input data is not valid");
    }
}
