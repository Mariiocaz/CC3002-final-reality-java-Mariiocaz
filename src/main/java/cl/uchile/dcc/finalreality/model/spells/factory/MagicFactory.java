package cl.uchile.dcc.finalreality.model.spells.factory;


import cl.uchile.dcc.finalreality.model.spells.Imagic;

/**
 * An interface that holds the common behavior of all magicfactories in the game.
 *
 * @author <a href="https://www.github.com/r8vnhill">R8V</a>
 * @author Mario Calderón
 */

public interface MagicFactory {
  Imagic create();
}
