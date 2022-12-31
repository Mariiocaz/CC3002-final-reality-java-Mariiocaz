package cl.uchile.dcc.finalreality.model.character.state;

/**
 * A class that tells the normal state of a game character.
 *
 * @author <a href="https://www.github.com/r8vnhill">R8V</a>
 * @author Mario Calderón
 */

public class Normal extends State {

  public void paralize() {
    this.changeState(new Paralized());
  }

  public void burn() {
    this.changeState(new Burned());
  }

  public void poison() {
    this.changeState(new Poisoned());
  }

  @Override
  public boolean isnormal() {
    return true;
  }
}
