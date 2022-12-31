package cl.uchile.dcc.finalreality.model.spells;

import cl.uchile.dcc.finalreality.model.character.GameCharacter;

/**
 * An interface that holds the common behavior of all magic in the game.
 *
 * @author <a href="https://www.github.com/r8vnhill">R8V</a>
 * @author Mario Calderón
 */

public interface Imagic {
  int cast(GameCharacter gameCharacter, int dealtdamage);
}
