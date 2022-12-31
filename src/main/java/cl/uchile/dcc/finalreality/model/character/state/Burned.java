package cl.uchile.dcc.finalreality.model.character.state;

/**
 * A class that tells the burn state of a game character.
 *
 * @author <a href="https://www.github.com/r8vnhill">R8V</a>
 * @author Mario Calderón
 */

public class Burned extends State {
  @Override
  public boolean isburned() {
    return true;
  }
}
