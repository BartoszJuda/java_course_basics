package day03.pantry_app.exceptions;

public class NotEnoughProductException extends Exception{
    public NotEnoughProductException(String message) {
        super(message);
    }
}
