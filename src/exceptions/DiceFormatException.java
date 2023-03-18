package codeCombat.exceptions;

/**
 * This exception is thrown when the format of the dice notation is invalid.
 * The dice notation should be in the format 'xdy', where x is the number of dice and y is the number of faces per
 * die. Both x and y must be positive integers.
 */
public class DiceFormatException extends IllegalArgumentException {
    public DiceFormatException() {
        super();
    }

    public DiceFormatException(String message) {
        super(message);
    }

    public DiceFormatException(String message, Throwable cause) {
        super(message, cause);
    }
}