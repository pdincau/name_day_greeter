package domain;

public class InvalidDataException extends RuntimeException {

    public InvalidDataException() {
        super("You can't create a person with these values");
    }
}
