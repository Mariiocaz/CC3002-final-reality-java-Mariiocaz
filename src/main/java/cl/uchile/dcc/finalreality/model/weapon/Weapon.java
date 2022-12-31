package cl.uchile.dcc.finalreality.model.weapon;

import cl.uchile.dcc.finalreality.exceptions.InvalidEquippableWeapon;
import cl.uchile.dcc.finalreality.model.character.player.common.Engineer;
import cl.uchile.dcc.finalreality.model.character.player.common.Knight;
import cl.uchile.dcc.finalreality.model.character.player.common.Thief;
import cl.uchile.dcc.finalreality.model.character.player.magic.BlackMage;
import cl.uchile.dcc.finalreality.model.character.player.magic.WhiteMage;

/**
 * A class that holds all the information of a weapon.
 *
 * @author <a href="https://www.github.com/r8vnhill">R8V</a>
 * @author ~Mario Calderón~
 */
public abstract class Weapon implements GameWeapon {

  private final String name;
  private final int damage;
  private final int weight;

  /**
   * Creates a weapon with a name, a base damage, speed, and it's type.
   */
  protected Weapon(final String name, final int damage, final int weight)  {
    this.name = name;
    this.damage = damage;
    this.weight = weight;
  }

  /**
   * Returns the name of the weapon.
   */
  public String getName() {
    return name;
  }

  /**
   * Returns the damage to the weapon.
   */

  public int getDamage() {
    return damage;
  }

  /**
   * Returns the weight of the weapon.
   */
  public int getWeight() {
    return weight;
  }

  /**
   * Returns the type of the weapon.
   */

  @Override
  public int getMagicdamage() {
    return 0;
  }

  public abstract WeaponType getType();


  public abstract Weapon equippedByEngineer(Engineer engineer) throws InvalidEquippableWeapon;

  public abstract Weapon equippedByKnight(Knight knight) throws InvalidEquippableWeapon;

  public abstract Weapon equippedByThief(Thief thief) throws InvalidEquippableWeapon;

  public abstract Weapon equippedByBlackMage(BlackMage blackMage) throws InvalidEquippableWeapon;

  public abstract Weapon equippedByWhiteMage(WhiteMage whiteMage) throws InvalidEquippableWeapon;


}
