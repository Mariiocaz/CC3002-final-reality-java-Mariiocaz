package cl.uchile.dcc.finalreality.model.spells;

import cl.uchile.dcc.finalreality.model.character.GameCharacter;

/**
 * A class that cast the spell Fire on a game character.
 *
 * @author <a href="https://www.github.com/r8vnhill">R8V</a>
 * @author Mario Calderón
 */

public class Fire implements Imagic {
  @Override
  public int cast(GameCharacter gameCharacter, int dealtdamage) {
    int damage = dealtdamage - gameCharacter.getDefense() / 2;
    if (damage > 0) {
      gameCharacter.setCurrentHp(Math.max(gameCharacter.getCurrentHp() - damage, 0));
    }
    int prob = (int) (Math.random() * 100 + 1);
    if (prob >= 20) {
      gameCharacter.burn();
    }
    return 15;
  }
}
