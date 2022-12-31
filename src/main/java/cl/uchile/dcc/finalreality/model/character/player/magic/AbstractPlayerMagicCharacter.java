/*
 * "Final Reality" (c) by R8V and ~Mario Calderón~
 * "Final Reality" is licensed under a
 * Creative Commons Attribution 4.0 International License.
 * You should have received a copy of the license along with this
 * work. If not, see <http://creativecommons.org/licenses/by/4.0/>.
 */

package cl.uchile.dcc.finalreality.model.character.player.magic;

import cl.uchile.dcc.finalreality.exceptions.InvalidEquippableWeapon;
import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.exceptions.Require;
import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import cl.uchile.dcc.finalreality.model.character.player.AbstractPlayerCharacter;
import cl.uchile.dcc.finalreality.model.spells.Imagic;
import cl.uchile.dcc.finalreality.model.spells.factory.MagicFactory;
import cl.uchile.dcc.finalreality.model.weapon.GameWeapon;
import cl.uchile.dcc.finalreality.model.weapon.Weapon;
import java.util.concurrent.BlockingQueue;
import org.jetbrains.annotations.NotNull;


/**
 * A class that holds all the information of a player-controlled MAGIC character in the game.
 *
 * <p>All player characters have a {@code name}, a maximum amount of <i>hit points</i>
 * ({@code maxHp}), a {@code defense} value, a queue of {@link GameCharacter}s that are
 * waiting for their turn ({@code turnsQueue}), and can equip a {@link Weapon}.
 *
 * @author <a href="https://www.github.com/r8vnhill">R8V</a>
 * @author ~Mario Calderón~
 */
public abstract class AbstractPlayerMagicCharacter extends AbstractPlayerCharacter implements
        MagicCharacter {

  private final int maxMp;
  private int currentMp;
  private MagicFactory magicFactory;

  /**
   * Creates a new character.
   * This constructor is <b>protected</b>, because it'll only be used by subclasses.
   *
   * @param name
   *     the character's name
   * @param maxHp
   *     the character's max hp
   * @param defense
   *     the character's defense
   * @param maxMp
   *     the character's max mp
   * @param turnsQueue
   *     the queue with the characters waiting for their turn
   */
  protected AbstractPlayerMagicCharacter(@NotNull final String name, final int maxHp,
                                         final int defense, final int maxMp,
                                         @NotNull final BlockingQueue<GameCharacter> turnsQueue)
      throws InvalidStatValueException {
    super(name, maxHp, defense, turnsQueue);
    Require.statValueAtLeast(0, maxMp, "Max MP");

    this.maxMp = maxMp;
    this.currentMp = maxMp;
  }

  /**
   * Returns the current MP of the character.
   */
  @Override
  public int getCurrentMp() {
    return currentMp;
  }

  /**
   * Sets the current MP of the character to {@code newMp}.
   */
  @Override
  public void setCurrentMp(final int newMp) throws InvalidStatValueException {
    Require.statValueAtLeast(0, newMp, "Current MP");
    Require.statValueAtMost(maxMp, newMp, "Current MP");
    this.currentMp = newMp;
  }

  /**
   * Returns the max MP of the character.
   */
  @Override
  public int getMaxMp() {
    return maxMp;
  }

  @Override
  public abstract void equip(GameWeapon weapon) throws InvalidEquippableWeapon;

  public void setFactory(MagicFactory magicFactory) {
    this.magicFactory = magicFactory;
  }

  public MagicFactory getFactory() {
    return this.magicFactory;
  }

  /**
   * Set de current mana points of the character to de value.
   *
   * @param gameCharacter
   *        gamecharacter who´s taking the spell
   * @throws InvalidStatValueException
   *        if the value it´s not gamecharacter
   */
  public void castmagic(GameCharacter gameCharacter) throws InvalidStatValueException {
    Imagic magic = magicFactory.create();
    GameWeapon weapon = getEquippedWeapon();
    int dealtdamage = weapon.getMagicdamage();
    int usedmp = magic.cast(gameCharacter, dealtdamage);
    setCurrentMp(getCurrentMp() - usedmp);
  }
}

