package cl.uchile.dcc.finalreality.model.character.player.common;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.model.character.GameCharacter;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import static org.junit.jupiter.api.Assertions.*;

class EngineerTest {
    BlockingQueue<GameCharacter> queue = new LinkedBlockingQueue<>();
    private Engineer character2;
    private Engineer character21;
    private Engineer character22;
    private Knight character23;

    @BeforeEach
    public void setUp() throws InvalidStatValueException {
        character2 = new Engineer("Radahn", 10, 10, queue);
        character21 = new Engineer("Radahn", 10, 10, queue);
        character22 = new Engineer("Rada", 9, 9, queue);
        character23 = new Knight("Malenia", 10, 10, queue);
    }

    @Test
    public void testToString() {
        assertEquals(character2.toString(), character2.toString());
        assertEquals(character2.toString(), character21.toString());
        assertNotEquals(character2.toString(), character22.toString());
        assertNotEquals(character2.toString(), character23.toString());
    }

    @Test
    public void testHashCode() {
        assertEquals(character2.hashCode(), character2.hashCode());
        assertEquals(character2.hashCode(), character21.hashCode());
        assertNotEquals(character2.hashCode(), character22.hashCode());
    }

    @Test
    public void testEquals() throws InvalidStatValueException {
        assertEquals(character2, character2);
        assertEquals(character2, character21);
        assertEquals(character22, new Engineer("Rada", 9, 9, queue));
        assertNotEquals(character2, character22);
    }
}