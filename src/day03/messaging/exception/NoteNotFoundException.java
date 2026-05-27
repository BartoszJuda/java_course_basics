package day03.messaging.exception;

public class NoteNotFoundException extends Exception{

    public NoteNotFoundException(String message) {
        super(message);
    }
}
