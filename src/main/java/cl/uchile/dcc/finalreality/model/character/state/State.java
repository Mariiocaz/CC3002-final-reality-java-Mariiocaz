package cl.uchile.dcc.finalreality.model.character.state;

import cl.uchile.dcc.finalreality.exceptions.InvalidState;
import cl.uchile.dcc.finalreality.model.character.GameCharacter;

/**
 * A class that holds the common behavior of all states in the game.
 *
 * @author <a href="https://www.github.com/r8vnhill">R8V</a>
 * @author Mario Calderón
 */

public class State {
  private GameCharacter gameCharacter;

  public void setGameCharacter(GameCharacter gameCharacter) {
    this.gameCharacter = gameCharacter;
  }

  void changeState(State state) {
    gameCharacter.setState(state);
  }

  void error() {
    throw new InvalidState("cambio de estado no válido");
  }

  public void paralize() {
    error();
  }

  public void burn() {
    error();
  }

  public void poison() {
    error();
  }

  public boolean isparalized() {
    return false;
  }

  public boolean isburned() {
    return false;
  }

  public boolean ispoisoned() {
    return false;
  }

  public boolean isnormal() {
    return false;
  }
}
