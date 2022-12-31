package cl.uchile.dcc.finalreality.model.spells.factory;


import cl.uchile.dcc.finalreality.model.spells.Heal;
import cl.uchile.dcc.finalreality.model.spells.Imagic;

/**
 * A class that creates the spell Heal.
 *
 * @author <a href="https://www.github.com/r8vnhill">R8V</a>
 * @author Mario Calderón
 */

public class HealFactory implements MagicFactory {
  @Override
  public Imagic create() {
    return new Heal();
  }
}
