package cl.uchile.dcc.finalreality.exceptions;

/**
 * This error is used to represent an invalid weapon.
 *
 * @author <a href="https://github.com/r8vnhill">R8V</a>
 * @author ~Mario Calderón~
 */

public class InvalidEquippableWeapon extends Exception {

    /**
     * Creates a new {@code InvalidStatValueException} with a {@code description} of the
     * error.
     */
    public InvalidEquippableWeapon(String description) {
        super("The provided weapon is not valid " + description);
    }

}

