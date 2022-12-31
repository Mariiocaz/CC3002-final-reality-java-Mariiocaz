package cl.uchile.dcc.finalreality.model.character.player.common;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import static org.junit.jupiter.api.Assertions.*;

class KnightTest {
    BlockingQueue<GameCharacter> queue = new LinkedBlockingQueue<>();
    private Knight character3;
    private Knight character31;
    private Knight character32;
    private Engineer character33;

    @BeforeEach
    public void setUp() throws InvalidStatValueException {
        character3 = new Knight("Malenia", 10, 10, queue);
        character31 = new Knight("Malenia", 10, 10, queue);
        character32 = new Knight("Melania", 9, 9, queue);
        character33 = new Engineer("Radahn", 10, 10, queue);
    }

    @Test
    public void testToString() {
        assertEquals(character3.toString(), character3.toString());
        assertEquals(character3.toString(), character31.toString());
        assertNotEquals(character3.toString(), character32.toString());
        assertNotEquals(character3.toString(), character33.toString());
    }

    @Test
    public void testHashCode() {
        assertEquals(character3.hashCode(), character3.hashCode());
        assertEquals(character3.hashCode(), character31.hashCode());
        assertNotEquals(character3.hashCode(), character32.hashCode());
    }

    @Test
    public void testEquals() throws InvalidStatValueException {
        assertEquals(character3, character3);
        assertEquals(character3, character31);
        assertEquals(character32, new Knight("Melania", 9, 9, queue));
        assertNotEquals(character3, character32);
    }
}