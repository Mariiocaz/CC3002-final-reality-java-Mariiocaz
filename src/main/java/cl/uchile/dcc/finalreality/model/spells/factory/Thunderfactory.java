package cl.uchile.dcc.finalreality.model.spells.factory;


import cl.uchile.dcc.finalreality.model.spells.Imagic;
import cl.uchile.dcc.finalreality.model.spells.Thunder;

/**
 * A class that creates the spell Thunder.
 *
 * @author <a href="https://www.github.com/r8vnhill">R8V</a>
 * @author Mario Calderón
 */

public class Thunderfactory implements MagicFactory {
  @Override
  public Imagic create() {
    return new Thunder();
  }
}
