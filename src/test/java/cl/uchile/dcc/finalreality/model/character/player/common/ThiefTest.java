package cl.uchile.dcc.finalreality.model.character.player.common;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.model.character.GameCharacter;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import static org.junit.jupiter.api.Assertions.*;

class ThiefTest {
    BlockingQueue<GameCharacter> queue = new LinkedBlockingQueue<>();
    private Thief character1;
    private Thief character11;
    private Thief character12;
    private Knight character13;

    @BeforeEach
    public void setUp() throws InvalidStatValueException {
        character1 = new Thief("Godrick", 10, 10, queue);
        character11 = new Thief("Godrick", 10, 10, queue);
        character12 = new Thief("Godri", 9, 9, queue);
        character13 = new Knight("Malenia", 10, 10, queue);
    }

    @Test
    public void testHashCode() {
        assertEquals(character1.hashCode(), character1.hashCode());
        assertEquals(character1.hashCode(), character11.hashCode());
        assertNotEquals(character1.hashCode(), character12.hashCode());
    }

    @Test
    public void testEquals() throws InvalidStatValueException {
        assertEquals(character1, character1);
        assertEquals(character1, character11);
        assertEquals(character12, new Thief("Godri", 9, 9, queue));
        assertNotEquals(character1, character12);
    }

    @Test
    public void testToString() {
        assertEquals(character1.toString(), character1.toString());
        assertEquals(character1.toString(), character11.toString());
        assertNotEquals(character1.toString(), character12.toString());
        assertNotEquals(character1.toString(), character13.toString());
    }
}