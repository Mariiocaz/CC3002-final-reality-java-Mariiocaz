package cl.uchile.dcc.finalreality.model.spells;

import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import cl.uchile.dcc.finalreality.model.character.state.Normal;

/**
 * A class that cast the spell Heal to the selected gamecharacter.
 *
 * @author <a href="https://www.github.com/r8vnhill">R8V</a>
 * @author Mario Calderón
 */

public class Heal implements Imagic {
  @Override
  public int cast(GameCharacter gameCharacter, int dealtdamage) {
    if (dealtdamage > 0) {
      int curacion = (int) (gameCharacter.getMaxHp() * 0.3);
      gameCharacter.setCurrentHp(Math.min(curacion + gameCharacter.getCurrentHp(),
              gameCharacter.getMaxHp()));
      gameCharacter.setState(new Normal());
      return 15;
    }
    else {
      System.out.println("No staff detected");
      return 0;
    }
  }
}
