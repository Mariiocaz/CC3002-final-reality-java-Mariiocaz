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
import cl.uchile.dcc.finalreality.model.character.player.PlayerCharacter;
import cl.uchile.dcc.finalreality.model.weapon.GameWeapon;
import java.util.Objects;
import java.util.concurrent.BlockingQueue;
import org.jetbrains.annotations.NotNull;

/**
 * A {@link PlayerCharacter} that can equip {@code Staff}s and use <i>white magic</i>.
 *
 * @author <a href="https://www.github.com/r8vnhill">R8V</a>
 * @author ~Mario Calderón~
 */
public class WhiteMage extends AbstractPlayerMagicCharacter {

  /**
   * Creates a new character.
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
  public WhiteMage(final @NotNull String name, final int maxHp, final int defense,
      final int maxMp, final @NotNull BlockingQueue<GameCharacter> turnsQueue)
      throws InvalidStatValueException {
    super(name, maxHp, defense, maxMp, turnsQueue);
  }

  @Override
  public void equip(GameWeapon weapon) throws InvalidEquippableWeapon {
    equippedWeapon = weapon.equippedByWhiteMage(this);

  }

  @Override
  public boolean equals(final Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof final WhiteMage that)) {
      return false;
    }
    return hashCode() == that.hashCode()
        && getMaxMp() == that.getMaxMp()
        && getName().equals(that.getName())
        && getMaxHp() == that.getMaxHp()
        && getDefense() == that.getDefense();
  }

  @Override
  public int hashCode() {
    return Objects.hash(WhiteMage.class, getName(), getMaxHp(), getDefense(), getMaxMp());
  }

  @Override
  public String toString() {
    return "WhiteMage{currentMp=%d, maxMp=%d, currentMp=%d, maxHp=%d, defense=%d, name='%s'}"
        .formatted(getCurrentMp(), getMaxMp(), getCurrentMp(), getMaxHp(), getDefense(), getName());
  }


}
