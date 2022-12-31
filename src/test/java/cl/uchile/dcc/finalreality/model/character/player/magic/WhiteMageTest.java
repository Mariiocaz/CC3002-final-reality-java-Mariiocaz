package cl.uchile.dcc.finalreality.model.character.player.magic;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import cl.uchile.dcc.finalreality.model.character.player.common.Knight;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import static org.junit.jupiter.api.Assertions.*;

class WhiteMageTest {
    BlockingQueue<GameCharacter> queue = new LinkedBlockingQueue<>();
    private WhiteMage character4;
    private WhiteMage character41;
    private WhiteMage character42;
    private Knight character43;

    @BeforeEach
    public void setUp() throws InvalidStatValueException {
        character4 = new WhiteMage("Rennala", 10, 10, 10, queue);
        character41 = new WhiteMage("Rennala", 10, 10, 10, queue);
        character42 = new WhiteMage("Ranna", 9, 9, 9, queue);
        character43 = new Knight("Malenia", 10, 10, queue);
    }

    @Test
    public void testEquals() throws InvalidStatValueException {
        assertEquals(character4, character4);
        assertEquals(character4, character41);
        assertEquals(character42, new WhiteMage("Ranna", 9, 9, 9, queue));
        assertNotEquals(character4, character42);
    }

    @Test
    public void testHashCode() {
        assertEquals(character4.hashCode(), character4.hashCode());
        assertEquals(character4.hashCode(), character41.hashCode());
        assertNotEquals(character4.hashCode(), character42.hashCode());
    }

    @Test
    public void testToString() {
        assertEquals(character4.toString(), character4.toString());
        assertEquals(character4.toString(), character41.toString());
        assertNotEquals(character4.toString(), character42.toString());
        assertNotEquals(character4.toString(), character43.toString());
    }
}