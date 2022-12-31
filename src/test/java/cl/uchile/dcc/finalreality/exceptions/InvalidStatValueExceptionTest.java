package cl.uchile.dcc.finalreality.exceptions;

import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import cl.uchile.dcc.finalreality.model.character.player.common.Engineer;
import cl.uchile.dcc.finalreality.model.character.player.common.Thief;
import cl.uchile.dcc.finalreality.model.character.player.magic.WhiteMage;
import org.junit.jupiter.api.Test;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import static org.junit.jupiter.api.Assertions.*;

class InvalidStatValueExceptionTest {

    BlockingQueue<GameCharacter> queue = new LinkedBlockingQueue<>();


    @Test
    public void testInvalidStatValue() {
        assertThrows(InvalidStatValueException.class, () -> new WhiteMage("Rennala", 10, 10, -3, queue));
        assertThrows(InvalidStatValueException.class, () -> new Engineer("Radahn", 10, -2, queue));
        assertThrows(InvalidStatValueException.class, () -> new Thief("Godrick", -5, 10, queue));

    }
}