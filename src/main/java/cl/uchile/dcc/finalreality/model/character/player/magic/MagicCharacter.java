package cl.uchile.dcc.finalreality.model.character.player.magic;

/*
 * "Final Reality" (c) by R8V and ~Mario Calderón~
 * "Final Reality" is licensed under a
 * Creative Commons Attribution 4.0 International License.
 * You should have received a copy of the license along with this
 * work. If not, see <http://creativecommons.org/licenses/by/4.0/>.
 */

import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import cl.uchile.dcc.finalreality.model.spells.factory.MagicFactory;


/**
 * A {@link GameCharacter} that can use magic habilities.
 *
 * @author <a href="https://www.github.com/r8vnhill">R8V</a>
 * @author ~Mario Calderón~
 */

public interface MagicCharacter extends GameCharacter {
  /**
   * Returns the current MP of the character.
   */
  int getCurrentMp();

  /**
   * Sets the current MP of the character to {@code newMp}.
   */
  void setCurrentMp(final int newMp) throws InvalidStatValueException;
  
  /**
   * Returns the max MP of the character.
   */
  int getMaxMp();

  void castmagic(GameCharacter gameCharacter);

  void setFactory(MagicFactory magicFactory);

  MagicFactory getFactory();
  
}
