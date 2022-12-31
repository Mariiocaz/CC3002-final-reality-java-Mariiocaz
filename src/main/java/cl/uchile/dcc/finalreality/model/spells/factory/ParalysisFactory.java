package cl.uchile.dcc.finalreality.model.spells.factory;


import cl.uchile.dcc.finalreality.model.spells.Imagic;
import cl.uchile.dcc.finalreality.model.spells.Paralysis;

/**
 * A class that create Paralysis spells.
 *
 * @author <a href="https://www.github.com/r8vnhill">R8V</a>
 * @author Mario Calderón
 */

public class ParalysisFactory implements MagicFactory {
  @Override
  public Imagic create() {
    return new Paralysis();
  }
}
