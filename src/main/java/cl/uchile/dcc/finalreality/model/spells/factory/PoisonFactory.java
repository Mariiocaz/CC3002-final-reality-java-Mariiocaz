package cl.uchile.dcc.finalreality.model.spells.factory;


import cl.uchile.dcc.finalreality.model.spells.Imagic;
import cl.uchile.dcc.finalreality.model.spells.Poison;

/**
 * A class that creates the spell Poison.
 *
 * @author <a href="https://www.github.com/r8vnhill">R8V</a>
 * @author Mario Calderón
 */

public class PoisonFactory implements MagicFactory {
  @Override
  public Imagic create() {
    return new Poison();
  }
}
