package cl.uchile.dcc.finalreality.model.character;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.exceptions.Require;
import java.util.concurrent.BlockingQueue;

import cl.uchile.dcc.finalreality.model.character.state.Normal;
import cl.uchile.dcc.finalreality.model.character.state.State;
import org.jetbrains.annotations.NotNull;

/**
 * An abstract class that holds the common behaviour of all the characters in the game.
 *
 * @author <a href="https://www.github.com/r8vnhill">R8V</a>
 * @author ~Mario Calderón~
 */
public abstract class AbstractCharacter implements GameCharacter {

  private int currentHp;
  private final int maxHp;
  private final int defense;

  protected final BlockingQueue<GameCharacter> turnsQueue;
  private final String name;
  private State state;

  /**
   * Creates a new character.
   *
   * @param name
   *     the character's name
   * @param maxHp
   *     the character's max hp
   * @param defense
   *     the character's defense
   * @param turnsQueue
   *     the queue with the characters waiting for their turn
   */
  protected AbstractCharacter(@NotNull String name, int maxHp, int defense,
      @NotNull BlockingQueue<GameCharacter> turnsQueue) throws InvalidStatValueException {
    Require.statValueAtLeast(1, maxHp, "Max HP");
    Require.statValueAtLeast(0, defense, "Defense");
    this.maxHp = maxHp;
    this.currentHp = maxHp;
    this.defense = defense;
    this.turnsQueue = turnsQueue;
    this.name = name;
    setState(new Normal());
  }

  @Override
  public abstract void waitTurn();

  @Override
  public String getName() {
    return name;
  }

  @Override
  public int getCurrentHp() {
    return currentHp;
  }

  @Override
  public int getMaxHp() {
    return maxHp;
  }

  @Override
  public int getDefense() {
    return defense;
  }

  @Override
  public void setCurrentHp(int hp) throws InvalidStatValueException {
    Require.statValueAtLeast(0, hp, "Current HP");
    Require.statValueAtMost(maxHp, hp, "Current HP");
    currentHp = hp;
  }

  public void setState(State state) {
    this.state = state;
    this.state.setGameCharacter(this);
  }

  public State getState() {
    return this.state;
  }

  public void paralize() {
    state.paralize();
  }

  public void burn() {
    state.burn();
  }

  public void poison() {
    state.poison();
  }

  public boolean isparalized() {
    return state.isparalized();
  }

  public boolean isburned() {
    return state.isburned();
  }

  public boolean ispoisoned() {
    return state.ispoisoned();
  }

  public boolean isnormal() {
    return state.isnormal();
  }
}
