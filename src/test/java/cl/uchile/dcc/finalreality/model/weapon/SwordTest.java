package cl.uchile.dcc.finalreality.model.weapon;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SwordTest {
    private Sword weapon3;
    private Sword weapon31;
    private Sword weapon32;
    private Staff weapon33;

    @BeforeEach
    public void setUp() {
        weapon3 = new Sword("Hand of Melania", 10, 5);
        weapon31 = new Sword("Hand of Melania", 10, 5);
        weapon32 = new Sword("Foot of Melania", 4, 3);
        weapon33 = new Staff("Crystal Staff", 10, 5,5);
    }

    @Test
    public void testGetType() {
        WeaponType staff = WeaponType.STAFF;
        WeaponType sword = WeaponType.SWORD;
        assertEquals(weapon3.getType(), weapon3.getType());
        assertEquals(weapon3.getType(), weapon32.getType());
        assertEquals(weapon3.getType(), sword);
        assertNotEquals(weapon3.getType(), weapon33.getType());
        assertNotEquals(weapon3.getType(), staff);
    }

    @Test
    public void testEquals() {
        assertEquals(weapon3, weapon3);
        assertEquals(weapon3, weapon31);
        assertEquals(weapon32, new Sword("Foot of Melania", 4, 3));
        assertNotEquals(weapon3, weapon32);
    }

    @Test
    public void testHashCode() {
        assertEquals(weapon3.hashCode(), weapon3.hashCode());
        assertEquals(weapon3.hashCode(), weapon31.hashCode());
        assertNotEquals(weapon3.hashCode(), weapon32.hashCode());
    }

    @Test
    public void testToString() {
        assertEquals(weapon3.toString(), weapon3.toString());
        assertEquals(weapon3.toString(), weapon31.toString());
        assertNotEquals(weapon3.toString(), weapon32.toString());
        assertNotEquals(weapon3.toString(), weapon33.toString());
    }
}