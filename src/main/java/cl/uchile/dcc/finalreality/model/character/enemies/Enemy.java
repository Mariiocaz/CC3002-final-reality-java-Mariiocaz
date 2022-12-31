package cl.uchile.dcc.finalreality.model.character.enemies;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.exceptions.Require;
import cl.uchile.dcc.finalreality.model.character.AbstractCharacter;
import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import java.util.Objects;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import org.jetbrains.annotations.NotNull;

/**
 * A class that holds all the information of a single enemy of the game.
 *
 * @author <a href="https://www.github.com/r8vnhill">R8V</a>
 * @author ~Mario Calderón~
 */
public class Enemy extends AbstractCharacter implements GameEnemy {

  private final int weight;
  private final int damage;

  private ScheduledExecutorService scheduledExecutor;

  /**
   * Creates a new enemy with a name, a weight and the queue with the characters ready to
   * play.
   */
  public Enemy(@NotNull final String name, final int weight, int maxHp, int defense, int damage,
      @NotNull final BlockingQueue<GameCharacter> turnsQueue)
      throws InvalidStatValueException {
    super(name, maxHp, defense, turnsQueue);
    Require.statValueAtLeast(1, weight, "Weight");
    this.weight = weight;
    this.damage = damage;
  }

  /**
   * Returns the weight of this enemy.
   */
  public int getWeight() {
    return weight;
  }

  /**
   * Returns the damage to the weapon.
   */

  public int getDamage() {
    return damage;
  }

  @Override
  public void waitTurn() {
    scheduledExecutor = Executors.newSingleThreadScheduledExecutor();

    scheduledExecutor.schedule(
            /* command = */ this::addToQueue,
            /* delay = */ this.getWeight() / 10,
            /* unit = */ TimeUnit.SECONDS);

  }

  private void addToQueue() {
    try {
      turnsQueue.put(this);
    } catch (Exception e) {
      e.printStackTrace();
    }
    scheduledExecutor.shutdown();
  }


  @Override
  public boolean equals(final Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof final Enemy enemy)) {
      return false;
    }
    return hashCode() == enemy.hashCode()
        && getName().equals(enemy.getName())
        && weight == enemy.weight
        && getMaxHp() == enemy.getMaxHp()
        && getDefense() == enemy.getDefense()
        && damage == enemy.damage;
  }

  @Override
  public int hashCode() {
    return Objects.hash(Enemy.class, getName(), weight, getMaxHp(), getDefense(), damage);
  }

  @Override
  public String toString() {
    return "Enemy{currentHp=%d, maxHp=%d, defense=%d, weight=%d, damage=%d name='%s'}"
            .formatted(getCurrentHp(), getMaxHp(), getDefense(), weight, damage, getName());
  }

}


