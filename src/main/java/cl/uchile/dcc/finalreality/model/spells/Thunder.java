package cl.uchile.dcc.finalreality.model.spells;

import cl.uchile.dcc.finalreality.model.character.GameCharacter;

/**
 * A class that cast the spell Thunder.
 *
 * @author <a href="https://www.github.com/r8vnhill">R8V</a>
 * @author Mario Calderón
 */

public class Thunder implements Imagic {
  @Override
  public int cast(GameCharacter gameCharacter, int dealtdamage) {
    int damage = dealtdamage - gameCharacter.getDefense() / 2;
    if (damage > 0) {
      gameCharacter.setCurrentHp(Math.max(gameCharacter.getCurrentHp() - damage, 0));
    }
    int prob = (int) (Math.random() * 100 + 1);
    if (prob >= 30) {
      gameCharacter.paralize();
    }
    return 15;
  }
}
