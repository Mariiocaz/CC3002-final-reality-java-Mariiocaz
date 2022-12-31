package cl.uchile.dcc.finalreality.model.character.player;

/*
 * "Final Reality" (c) by R8V and ~Mario Calderón~
 * "Final Reality" is licensed under a
 * Creative Commons Attribution 4.0 International License.
 * You should have received a copy of the license along with this
 * work. If not, see <http://creativecommons.org/licenses/by/4.0/>.
 */

import cl.uchile.dcc.finalreality.exceptions.InvalidEquippableWeapon;
import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import cl.uchile.dcc.finalreality.model.weapon.GameWeapon;

/**
 * A {@link GameCharacter} that can equip a weapon.
 *
 * @author <a href="https://www.github.com/r8vnhill">R8V</a>
 * @author ~Mario Calderón~
 */

public interface PlayerCharacter extends GameCharacter {
  /**
   * Equips a weapon to the character.
   */
  void equip(GameWeapon weapon) throws InvalidEquippableWeapon;

  /**
   * Return this character's equipped weapon.
   */
  GameWeapon getEquippedWeapon();
}
