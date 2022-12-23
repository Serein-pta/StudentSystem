package studentsystem;

public class NumberOutException extends RuntimeException{
    public NumberOutException() {
    }

    public NumberOutException(String message) {
        super(message);
    }
}
