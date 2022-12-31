package cl.uchile.dcc.finalreality.model.weapon;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class StaffTest {
    private Staff weapon4;
    private Staff weapon41;
    private Staff weapon42;
    private Sword weapon43;

    @BeforeEach
    public void setUp() {
        weapon4 = new Staff("Crystal Staff", 10, 5,5);
        weapon41 = new Staff("Crystal Staff", 10, 5,5);
        weapon42 = new Staff("Wood Staff", 4, 3,5);
        weapon43 = new Sword("Hand of Melania", 10, 5);
    }

    @Test
    public void testGetType() {
        WeaponType staff = WeaponType.STAFF;
        WeaponType sword = WeaponType.SWORD;
        assertEquals(weapon4.getType(), weapon4.getType());
        assertEquals(weapon4.getType(), weapon42.getType());
        assertEquals(weapon4.getType(), staff);
        assertNotEquals(weapon4.getType(), weapon43.getType());
        assertNotEquals(weapon4.getType(), sword);
    }

    @Test
    public void testEquals() {
        assertEquals(weapon4, weapon4);
        assertEquals(weapon4, weapon41);
        assertEquals(weapon42, new Staff("Wood Staff", 4, 3,5));
        assertNotEquals(weapon4, weapon42);
    }

    @Test
    public void testHashCode() {
        assertEquals(weapon4.hashCode(), weapon4.hashCode());
        assertEquals(weapon4.hashCode(), weapon41.hashCode());
        assertNotEquals(weapon4.hashCode(), weapon42.hashCode());
    }

    @Test
    public void testToString() {
        assertEquals(weapon4.toString(), weapon4.toString());
        assertEquals(weapon4.toString(), weapon41.toString());
        assertNotEquals(weapon4.toString(), weapon42.toString());
        assertNotEquals(weapon4.toString(), weapon43.toString());
    }
}