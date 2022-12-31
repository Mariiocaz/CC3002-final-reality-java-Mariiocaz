package cl.uchile.dcc.finalreality.model.weapon;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WeaponTest {
    private Bow weapon1;
    private Axe weapon2;
    private Axe weapon21;
    private Sword weapon3;
    private Staff weapon4;
    private Knife weapon5;

    @BeforeEach
    public void setUp() {
        weapon1 = new Bow("Albinauric Bow", 10, 5);
        weapon2 = new Axe("Stormhawk axe", 10, 5);
        weapon21 = new Axe("Stormhawk axe", 15, 4);
        weapon3 = new Sword("Hand of Melania", 10, 5);
        weapon4 = new Staff("Crystal Staff", 10, 5,5);
        weapon5 = new Knife("Reduvia", 5, 6);
    }

    @Test
    public void testGetName() {
        String sword = "Hand of Melania";
        String staff = "Wood Staff";
        assertEquals(weapon1.getName(), weapon1.getName());
        assertEquals(weapon2.getName(), weapon21.getName());
        assertEquals(weapon3.getName(), sword);
        assertNotEquals(weapon4.getName(), weapon5.getName());
        assertNotEquals(weapon4.getName(), staff);
    }

    @Test
    public void testGetDamage() {
        assertEquals(weapon1.getDamage(), weapon1.getDamage());
        assertEquals(weapon1.getDamage(), weapon2.getDamage());
        assertNotEquals(weapon4.getDamage(), weapon5.getDamage());
    }

    @Test
    public void testGetWeight() {
        assertEquals(weapon1.getWeight(), weapon1.getWeight());
        assertEquals(weapon1.getWeight(), weapon2.getWeight());
        assertNotEquals(weapon4.getWeight(), weapon5.getWeight());
    }
}