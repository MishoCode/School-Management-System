package example.school.exceptions;

public class SubjectIsAlreadyEnrolledException extends RuntimeException {
    public SubjectIsAlreadyEnrolledException(String message) {
        super(message);
    }
}
