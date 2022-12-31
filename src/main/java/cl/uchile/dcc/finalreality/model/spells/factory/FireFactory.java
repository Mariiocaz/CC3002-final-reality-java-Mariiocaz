package cl.uchile.dcc.finalreality.model.spells.factory;


import cl.uchile.dcc.finalreality.model.spells.Fire;
import cl.uchile.dcc.finalreality.model.spells.Imagic;

/**
 * A class that create the spell Fire.
 *
 * @author <a href="https://www.github.com/r8vnhill">R8V</a>
 * @author Mario Calderón
 */


public class FireFactory implements MagicFactory {
  @Override
  public Imagic create() {
    return new Fire();
  }
}
