package day03.pantry_app.exceptions;

public class InvalidProductDataException extends Exception {

    public InvalidProductDataException(String message ){
        super(message);
    }
}
