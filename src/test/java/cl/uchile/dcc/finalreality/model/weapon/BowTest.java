package cl.uchile.dcc.finalreality.model.weapon;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BowTest {
    private Bow weapon1;
    private Bow weapon11;
    private Bow weapon12;
    private Sword weapon13;

    @BeforeEach
    public void setUp() {
        weapon1 = new Bow("Albinauric Bow", 10, 5);
        weapon11 = new Bow("Albinauric Bow", 10, 5);
        weapon12 = new Bow("Albin Bow", 4, 3);
        weapon13 = new Sword("Hand of Melania", 10, 5);
    }

    @Test
    public void testGetType() {
        WeaponType bow = WeaponType.BOW;
        WeaponType sword = WeaponType.SWORD;
        assertEquals(weapon1.getType(), weapon1.getType());
        assertEquals(weapon1.getType(), weapon12.getType());
        assertEquals(weapon1.getType(), bow);
        assertNotEquals(weapon1.getType(), weapon13.getType());
        assertNotEquals(weapon1.getType(), sword);
    }

    @Test
    public void testEquals() {
        assertEquals(weapon1, weapon1);
        assertEquals(weapon1, weapon11);
        assertEquals(weapon12, new Bow("Albin Bow", 4, 3));
        assertNotEquals(weapon1, weapon12);
    }

    @Test
    public void testHashCode() {
        assertEquals(weapon1.hashCode(), weapon1.hashCode());
        assertEquals(weapon1.hashCode(), weapon11.hashCode());
        assertNotEquals(weapon1.hashCode(), weapon12.hashCode());
    }

    @Test
    public void testToString() {
        assertEquals(weapon1.toString(), weapon1.toString());
        assertEquals(weapon1.toString(), weapon11.toString());
        assertNotEquals(weapon1.toString(), weapon12.toString());
        assertNotEquals(weapon1.toString(), weapon13.toString());
    }
}