package cl.uchile.dcc.finalreality.exceptions;

/**
 * This error is used to represent an invalid weapon for a character.
 *
 * @author <a href="https://github.com/r8vnhill">R8V</a>
 * @author ~Mario Calderón~
 */
public class InvalidState extends RuntimeException {

  /**
  * Creates a new {@code InvalidStatValueException} with a {@code description} of the
  * error.
  */
  public InvalidState(String description) {
    super("The provided state is not valid " + description);
  }
}