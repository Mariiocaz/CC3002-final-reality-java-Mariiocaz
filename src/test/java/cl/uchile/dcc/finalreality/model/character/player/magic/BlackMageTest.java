package cl.uchile.dcc.finalreality.model.character.player.magic;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import cl.uchile.dcc.finalreality.model.character.player.common.Knight;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import static org.junit.jupiter.api.Assertions.*;

class BlackMageTest {
    BlockingQueue<GameCharacter> queue = new LinkedBlockingQueue<>();
    private BlackMage character5;
    private BlackMage character51;
    private BlackMage character52;
    private Knight character53;

    @BeforeEach
    public void setUp() throws InvalidStatValueException {
        character5 = new BlackMage("Godfrey", 10, 10, 10, queue);
        character51 = new BlackMage("Godfrey", 10, 10, 10, queue);
        character52 = new BlackMage("Gody", 9, 9, 9, queue);
        character53 = new Knight("Malenia", 10, 10, queue);
    }

    @Test
    public void testEquals() throws InvalidStatValueException {
        assertEquals(character5, character5);
        assertEquals(character5, character51);
        assertEquals(character52, new BlackMage("Gody", 9, 9, 9, queue));
        assertNotEquals(character5, character52);
    }

    @Test
    public void testToString() {
        assertEquals(character5.toString(), character5.toString());
        assertEquals(character5.toString(), character51.toString());
        assertNotEquals(character5.toString(), character52.toString());
        assertNotEquals(character5.toString(), character53.toString());

    }

    @Test
    public void testHashCode() {
        assertEquals(character5.hashCode(), character5.hashCode());
        assertEquals(character5.hashCode(), character51.hashCode());
        assertNotEquals(character5.hashCode(), character52.hashCode());
    }
}