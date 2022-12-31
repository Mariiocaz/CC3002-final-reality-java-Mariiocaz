package cl.uchile.dcc.finalreality.model.character.state;

/**
 * A class that tells the poisoned state of a gam character.
 *
 * @author <a href="https://www.github.com/r8vnhill">R8V</a>
 * @author Mario Calderón
 */

public class Poisoned extends State {
  @Override
  public boolean ispoisoned() {
    return true;
  }
}
