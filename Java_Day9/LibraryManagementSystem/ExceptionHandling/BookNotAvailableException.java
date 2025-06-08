package Java_Day9.LibraryManagementSystem.ExceptionHandling;

public class BookNotAvailableException extends RuntimeException {
    public BookNotAvailableException(String message) {
        super(message);
    }
}