package cl.uchile.dcc.finalreality.model.weapon;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;


public class KnifeTest {
    private Knife weapon5;
    private Knife weapon51;
    private Knife weapon52;
    private Sword weapon53;

    @BeforeEach
    public void setUp() {
        weapon5 = new Knife("Reduvia", 10, 5);
        weapon51 = new Knife("Reduvia", 10, 5);
        weapon52 = new Knife("Duvia", 4, 3);
        weapon53 = new Sword("Hand of Melania", 10, 5);

    }

    @Test
    public void testGetType() {
        WeaponType knife = WeaponType.KNIFE;
        WeaponType sword = WeaponType.SWORD;
        assertEquals(weapon5.getType(), weapon5.getType());
        assertEquals(weapon5.getType(), weapon52.getType());
        assertEquals(weapon5.getType(), knife);
        assertNotEquals(weapon5.getType(), weapon53.getType());
        assertNotEquals(weapon5.getType(), sword);
    }

    @Test
    public void testEquals() {
        assertEquals(weapon5, weapon5);
        assertEquals(weapon5, weapon51);
        assertEquals(weapon52, new Knife("Duvia", 4, 3));
        assertNotEquals(weapon5, weapon52);
    }

    @Test
    public void testHashCode() {
        assertEquals(weapon5.hashCode(), weapon5.hashCode());
        assertEquals(weapon5.hashCode(), weapon51.hashCode());
        assertNotEquals(weapon5.hashCode(), weapon52.hashCode());
    }

    @Test
    public void testToString() {
        assertEquals(weapon5.toString(), weapon5.toString());
        assertEquals(weapon5.toString(), weapon51.toString());
        assertNotEquals(weapon5.toString(), weapon52.toString());
        assertNotEquals(weapon5.toString(), weapon53.toString());
    }
}
