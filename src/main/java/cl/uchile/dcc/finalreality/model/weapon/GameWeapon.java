package cl.uchile.dcc.finalreality.model.weapon;

import cl.uchile.dcc.finalreality.exceptions.InvalidEquippableWeapon;
import cl.uchile.dcc.finalreality.model.character.player.common.Engineer;
import cl.uchile.dcc.finalreality.model.character.player.common.Knight;
import cl.uchile.dcc.finalreality.model.character.player.common.Thief;
import cl.uchile.dcc.finalreality.model.character.player.magic.BlackMage;
import cl.uchile.dcc.finalreality.model.character.player.magic.WhiteMage;

/**
 * AN interface that holds all the information of a weapon.
 *
 * @author <a href="https://www.github.com/r8vnhill">R8V</a>
 * @author ~Mario Calderón~
 */
public interface GameWeapon {

  /**
   * Returns the name of the weapon.
   */

  String getName();

  /**
   * Returns the damage to the weapon.
   */

  int getDamage();

  /**
   * Returns the weight of the weapon.
   */
  int getWeight();

  /**
   * Returns the type of the weapon.
   */

  WeaponType getType();

  /**
   * Check if the weapon is equippable by an Engineer.
   */

  Weapon equippedByEngineer(Engineer engineer) throws InvalidEquippableWeapon;

  /**
   * Check if the weapon is equippable by a Knight.
   */

  Weapon equippedByKnight(Knight knight) throws InvalidEquippableWeapon;

  /**
   * Check if the weapon is equippable by a Thief.
   */

  Weapon equippedByThief(Thief thief) throws InvalidEquippableWeapon;

  /**
   * Check if the weapon is equippable by a Black Mage.
   */

  Weapon equippedByBlackMage(BlackMage blackMage) throws InvalidEquippableWeapon;

  /**
   * Check if the weapon is equippable by a WhiteMage.
   */

  Weapon equippedByWhiteMage(WhiteMage whiteMage) throws InvalidEquippableWeapon;

  /**
   * Returns the  magic damage to the weapon.
   */

  int getMagicdamage();
}


