package cl.uchile.dcc.finalreality.model.character.enemies;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import static org.junit.jupiter.api.Assertions.*;

class EnemyTest {
    BlockingQueue<GameCharacter> queue = new LinkedBlockingQueue<>();
    private Enemy character1;
    private Enemy character2;
    private Enemy character3;

    @BeforeEach
    public void setUp() throws InvalidStatValueException {
        character1 = new Enemy("Blaidd", 10, 10, 10, 10, queue);
        character2 = new Enemy("Blaidd", 10, 10, 10, 10, queue);
        character3 = new Enemy("Blai", 9, 9, 9, 9, queue);
    }

    @Test
    public void testGetWeight() {
        assertEquals(character1.getWeight(), character1.getWeight());
        assertEquals(character1.getWeight(), character2.getWeight());
        assertNotEquals(character2.getWeight(), character3.getWeight());
    }

    @Test
    public void testGetDamage() {
        assertEquals(character1.getDamage(), character1.getDamage());
        assertEquals(character1.getDamage(), character2.getDamage());
        assertNotEquals(character2.getDamage(), character3.getDamage());
    }


    @Test
    public void testEquals() throws InvalidStatValueException {
        assertEquals(character1, character1);
        assertEquals(character1, character2);
        assertEquals(character3, new Enemy("Blai", 9, 9, 9, 9, queue));
        assertNotEquals(character1, character3);
    }

    @Test
    public void testHashCode() {
        assertEquals(character1.hashCode(), character1.hashCode());
        assertEquals(character1.hashCode(), character2.hashCode());
        assertNotEquals(character1.hashCode(), character3.hashCode());
    }

    @Test
    public void testToString() {
        assertEquals(character1.toString(), character1.toString());
        assertEquals(character1.toString(), character2.toString());
        assertNotEquals(character1.toString(), character3.toString());
    }
}