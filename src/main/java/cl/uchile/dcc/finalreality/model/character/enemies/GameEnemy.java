package cl.uchile.dcc.finalreality.model.character.enemies;

import cl.uchile.dcc.finalreality.model.character.GameCharacter;

/**
 * AN interface that holds all the information of an enemy.
 *
 * @author <a href="https://www.github.com/r8vnhill">R8V</a>
 * @author ~Mario Calderón~
 */

public interface GameEnemy extends GameCharacter {
  /**
   * Returns the weight of this enemy.
   */
  int getWeight();

  /**
   * Returns the damage to the weapon.
   */

  int getDamage();

}
