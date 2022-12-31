package cl.uchile.dcc.finalreality.model.weapon;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AxeTest {
    private Axe weapon2;
    private Axe weapon21;
    private Axe weapon22;
    private Sword weapon23;

    @BeforeEach
    public void setUp() {
        weapon2 = new Axe("Stormhawk axe", 10, 5);
        weapon21 = new Axe("Stormhawk axe", 10, 5);
        weapon22 = new Axe("Sunhawk axe", 4, 3);
        weapon23 = new Sword("Hand of Melania", 10, 5);
    }

    @Test
    public void testGetType() {
        WeaponType axe = WeaponType.AXE;
        WeaponType sword = WeaponType.SWORD;
        assertEquals(weapon2.getType(), weapon2.getType());
        assertEquals(weapon2.getType(), weapon22.getType());
        assertEquals(weapon2.getType(), axe);
        assertNotEquals(weapon2.getType(), weapon23.getType());
        assertNotEquals(weapon2.getType(), sword);
    }

    @Test
    public void testEquals() {
        assertEquals(weapon2, weapon2);
        assertEquals(weapon2, weapon21);
        assertEquals(weapon22, new Axe("Sunhawk axe", 4, 3));
        assertNotEquals(weapon2, weapon22);
    }

    @Test
    public void testHashCode() {
        assertEquals(weapon2.hashCode(), weapon2.hashCode());
        assertEquals(weapon2.hashCode(), weapon21.hashCode());
        assertNotEquals(weapon2.hashCode(), weapon22.hashCode());
    }

    @Test
    public void testToString() {
        assertEquals(weapon2.toString(), weapon2.toString());
        assertEquals(weapon2.toString(), weapon21.toString());
        assertNotEquals(weapon2.toString(), weapon22.toString());
        assertNotEquals(weapon2.toString(), weapon23.toString());
    }


}