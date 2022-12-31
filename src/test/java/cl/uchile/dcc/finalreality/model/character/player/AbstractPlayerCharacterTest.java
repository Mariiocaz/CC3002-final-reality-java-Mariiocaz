package cl.uchile.dcc.finalreality.model.character.player;

import cl.uchile.dcc.finalreality.exceptions.InvalidEquippableWeapon;
import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import cl.uchile.dcc.finalreality.model.character.player.common.Engineer;
import cl.uchile.dcc.finalreality.model.character.player.common.Knight;
import cl.uchile.dcc.finalreality.model.character.player.common.Thief;
import cl.uchile.dcc.finalreality.model.character.player.magic.BlackMage;
import cl.uchile.dcc.finalreality.model.character.player.magic.WhiteMage;
import cl.uchile.dcc.finalreality.model.weapon.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import static org.junit.jupiter.api.Assertions.*;

class AbstractPlayerCharacterTest {
    BlockingQueue<GameCharacter> queue = new LinkedBlockingQueue<>();
    private Bow weapon1;
    private Axe weapon2;
    private Sword weapon3;
    private Staff weapon4;
    private Knife weapon5;
    private Thief character1;
    private Engineer character2;
    private Knight character3;
    private WhiteMage character4;
    private BlackMage character5;


    @BeforeEach
    public void setUp() throws InvalidStatValueException {
        weapon1 = new Bow("Albinauric Bow", 10, 5);
        weapon2 = new Axe("Stormhawk axe", 10, 5);
        weapon3 = new Sword("Hand of Melania", 10, 5);
        weapon4 = new Staff("Crystal Staff", 10, 5,5);
        weapon5 = new Knife("Reduvia", 10, 5);
        character1 = new Thief("Godrick", 10, 10, queue);
        character2 = new Engineer("Radahn", 10, 10, queue);
        character3 = new Knight("Malenia", 10, 10, queue);
        character4 = new WhiteMage("Rennala", 10, 10, 10, queue);
        character5 = new BlackMage("Godfrey", 10, 10, 10, queue);

    }

    @Test
    public void testEquipANDgetEquippedWeapon() throws InvalidEquippableWeapon {

        // -- Equippable
        // -- Thief
        character1.equip(weapon1);
        assertEquals(weapon1, character1.getEquippedWeapon());
        character1.equip(weapon5);
        assertEquals(weapon5, character1.getEquippedWeapon());
        character1.equip(weapon3);
        assertEquals(weapon3, character1.getEquippedWeapon());
        assertNotEquals(weapon1, character2.getEquippedWeapon());
        character1.equip(weapon1);
        // -- Engineer
        character2.equip(weapon2);
        assertEquals(weapon2, character2.getEquippedWeapon());
        character2.equip(weapon1);
        assertEquals(weapon1, character2.getEquippedWeapon());
        assertNotEquals(weapon2, character3.getEquippedWeapon());
        character2.equip(weapon2);
        // -- Knight
        character3.equip(weapon3);
        assertEquals(weapon3, character3.getEquippedWeapon());
        character3.equip(weapon5);
        assertEquals(weapon5, character3.getEquippedWeapon());
        character3.equip(weapon2);
        assertEquals(weapon2, character3.getEquippedWeapon());
        assertNotEquals(weapon3, character4.getEquippedWeapon());
        character3.equip(weapon3);
        // -- WhiteMage
        character4.equip(weapon4);
        assertEquals(weapon4, character4.getEquippedWeapon());
        assertNotEquals(weapon4, character5.getEquippedWeapon());
        // -- BlackMage
        character5.equip(weapon5);
        assertEquals(weapon5, character5.getEquippedWeapon());
        assertNotEquals(weapon5, character1.getEquippedWeapon());

    }

}