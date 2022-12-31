package cl.uchile.dcc.finalreality.model.spells;

import cl.uchile.dcc.finalreality.model.character.GameCharacter;

/**
 * A class that cast the spell Poison.
 *
 * @author <a href="https://www.github.com/r8vnhill">R8V</a>
 * @author Mario Calderón
 */

public class Poison implements Imagic {
  @Override
  public int cast(GameCharacter gameCharacter, int dealtdamage) {
    gameCharacter.poison();
    return 40;
  }
}
