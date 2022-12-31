package cl.uchile.dcc.finalreality.model.spells;

import cl.uchile.dcc.finalreality.model.character.GameCharacter;

/**
 * A class that cast the spell Paralysis to a game character.
 *
 * @author <a href="https://www.github.com/r8vnhill">R8V</a>
 * @author Mario Calderón
 */

public class Paralysis implements Imagic {
  @Override
  public int cast(GameCharacter gameCharacter, int dealtdamage) {
    gameCharacter.paralize();
    return 25;
  }
}
