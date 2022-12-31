package cl.uchile.dcc.finalreality.exceptions;

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

class InvalidEquippableWeaponTest {
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
    void setUp() throws InvalidStatValueException {
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
    public void testInvalidEquippableWeapon() {

        // -- Non Equippable
        // -- Thief
        assertThrows(InvalidEquippableWeapon.class, () -> character1.equip(weapon2));
        assertThrows(InvalidEquippableWeapon.class, () -> character1.equip(weapon4));

        // -- Engineer
        assertThrows(InvalidEquippableWeapon.class, () -> character2.equip(weapon3));
        assertThrows(InvalidEquippableWeapon.class, () -> character2.equip(weapon4));
        assertThrows(InvalidEquippableWeapon.class, () -> character2.equip(weapon5));

        // -- Knight
        assertThrows(InvalidEquippableWeapon.class, () -> character3.equip(weapon1));
        assertThrows(InvalidEquippableWeapon.class, () -> character3.equip(weapon4));

        // -- WhiteMage
        assertThrows(InvalidEquippableWeapon.class, () -> character4.equip(weapon1));
        assertThrows(InvalidEquippableWeapon.class, () -> character4.equip(weapon2));
        assertThrows(InvalidEquippableWeapon.class, () -> character4.equip(weapon3));
        assertThrows(InvalidEquippableWeapon.class, () -> character4.equip(weapon5));

        // -- BlackMage
        assertThrows(InvalidEquippableWeapon.class, () -> character5.equip(weapon1));
        assertThrows(InvalidEquippableWeapon.class, () -> character5.equip(weapon2));
        assertThrows(InvalidEquippableWeapon.class, () -> character5.equip(weapon3));

    }
}