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
import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import cl.uchile.dcc.finalreality.model.weapon.GameWeapon;
import java.util.Objects;
import java.util.concurrent.BlockingQueue;
import org.jetbrains.annotations.NotNull;

/**
 * A Black Mage is a type of player character that can cast black magic.
 *
 * @author <a href="https://www.github.com/r8vnhill">R8V</a>
 * @author ~Mario Calderón~
 * @version 2.0
 */
public class BlackMage extends AbstractPlayerMagicCharacter {


  /**
   * Creates a new Black Mage.
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
  public BlackMage(final @NotNull String name, final int maxHp, final int defense,
      final int maxMp, final @NotNull BlockingQueue<GameCharacter> turnsQueue)
      throws InvalidStatValueException {
    super(name, maxHp, defense, maxMp, turnsQueue);

  }

  @Override
  public void equip(GameWeapon weapon) throws InvalidEquippableWeapon {
    equippedWeapon = weapon.equippedByBlackMage(this);

  }

  // region : UTILITY METHODS
  @Override
  public boolean equals(final Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof final BlackMage that)) {
      return false;
    }
    return hashCode() == that.hashCode()
        && getName().equals(that.getName())
        && getMaxHp() == that.getMaxHp()
        && getDefense() == that.getDefense()
        && getMaxMp() == that.getMaxMp();
  }

  @Override
  public String toString() {
    return "BlackMage{currentMp=%d, maxMp=%d, currentHp=%d, maxHp=%d, defense=%d, name='%s'}"
        .formatted(getCurrentMp(), getMaxMp(), getCurrentHp(), getMaxHp(), getDefense(), getName());
  }

  @Override
  public int hashCode() {
    return Objects.hash(BlackMage.class, getName(), getMaxHp(), getDefense(), getMaxMp());
  }
  // endregion
}
