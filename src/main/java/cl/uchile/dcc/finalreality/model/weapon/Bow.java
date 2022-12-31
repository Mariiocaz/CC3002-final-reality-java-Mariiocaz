/*
 * "Final Reality" (c) by R8V and ~Mario Calderón~
 * "Final Reality" is licensed under a
 * Creative Commons Attribution 4.0 International License.
 * You should have received a copy of the license along with this
 * work. If not, see <http://creativecommons.org/licenses/by/4.0/>.
 */

package cl.uchile.dcc.finalreality.model.weapon;

import cl.uchile.dcc.finalreality.exceptions.InvalidEquippableWeapon;
import cl.uchile.dcc.finalreality.model.character.player.common.Engineer;
import cl.uchile.dcc.finalreality.model.character.player.common.Knight;
import cl.uchile.dcc.finalreality.model.character.player.common.Thief;
import cl.uchile.dcc.finalreality.model.character.player.magic.BlackMage;
import cl.uchile.dcc.finalreality.model.character.player.magic.WhiteMage;
import java.util.Objects;

/**
 * A {@link GameWeapon} that can be equipped by {@code Engineer}s and {@code Thief}s.
 *
 * @author <a href="https://www.github.com/r8vnhill">R8V</a>
 * @author ~Mario Calderón~
 */

public class Bow extends Weapon {

  WeaponType type = WeaponType.BOW;
  /**
   * Creates a weapon with a name, a base damage, speed, and it's type.
   */

  public Bow(String name, int damage, int weight) {
    super(name, damage, weight);
  }

  @Override
  public WeaponType getType() {
    return type;
  }

  @Override
  public Weapon equippedByEngineer(Engineer engineer) {
    return this;

  }

  @Override
  public Weapon equippedByKnight(Knight knight) throws InvalidEquippableWeapon {
    throw new InvalidEquippableWeapon("Invalid Equippable Weapon");

  }

  @Override
  public Weapon equippedByThief(Thief thief) {
    return this;
  }

  @Override
  public Weapon equippedByBlackMage(BlackMage blackMage) throws InvalidEquippableWeapon {
    throw new InvalidEquippableWeapon("Invalid Equippable Weapon");
  }

  @Override
  public Weapon equippedByWhiteMage(WhiteMage whiteMage) throws InvalidEquippableWeapon {
    throw new InvalidEquippableWeapon("Invalid Equippable Weapon");
  }

  @Override
  public boolean equals(final Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof final Bow weapon)) {
      return false;
    }
    return hashCode() == weapon.hashCode()
            && getDamage() == weapon.getDamage()
            && getWeight() == weapon.getWeight()
            && getName().equals(weapon.getName())
            && type == weapon.type;
  }

  @Override
  public int hashCode() {
    return Objects.hash(Weapon.class, getName(), getDamage(), getWeight(), type);
  }

  @Override
  public String toString() {
    return "Weapon{name='%s', damage=%d, weight=%d, type=%s}"
            .formatted(getName(), getDamage(), getWeight(), type);
  }
}
