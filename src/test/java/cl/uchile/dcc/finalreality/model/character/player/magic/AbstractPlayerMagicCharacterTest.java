package cl.uchile.dcc.finalreality.model.character.player.magic;

import cl.uchile.dcc.finalreality.exceptions.InvalidEquippableWeapon;
import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import cl.uchile.dcc.finalreality.model.spells.factory.*;
import cl.uchile.dcc.finalreality.model.weapon.Staff;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import static org.junit.jupiter.api.Assertions.*;

class AbstractPlayerMagicCharacterTest {
    BlockingQueue<GameCharacter> queue = new LinkedBlockingQueue<>();
    private BlackMage character1;
    private BlackMage character2;
    private BlackMage character3;
    private WhiteMage character4;
    private WhiteMage character5;

    BlackMage abmage1;
    WhiteMage abmage2;
    BlackMage abmage3;

    @BeforeEach
    public void setUp() throws InvalidStatValueException {
        character1 = new BlackMage("Godfrey", 10, 10, 10, queue);
        character2 = new BlackMage("Godfrey", 10, 10, 10, queue);
        character3 = new BlackMage("Gody", 9, 9, 9, queue);
        character4 = new WhiteMage("Rennala", 10, 10, 10, queue);
        character5 = new WhiteMage("Ranna", 9, 9, 9, queue);

        abmage1 = new BlackMage("Abstract mage de prueba", 100, 100, 100,queue);
        abmage2 = new WhiteMage("", 1, 1, 1000, queue);
        abmage3 = new BlackMage("Abstract mage test", 100, 100, 100, queue);
    }

    @Test
    public void testGetCurrentMp() {
        assertEquals(character1.getCurrentMp(), character1.getCurrentMp());
        assertEquals(character1.getCurrentMp(), character2.getCurrentMp());
        assertNotEquals(character2.getCurrentMp(), character3.getCurrentMp());
        assertEquals(character4.getCurrentMp(), character4.getCurrentMp());
        assertEquals(character1.getCurrentMp(), character4.getCurrentMp());
        assertNotEquals(character1.getCurrentMp(), character5.getCurrentMp());
    }

    @Test
    public void testSetCurrentMp() throws InvalidStatValueException {
        assertEquals(character1.getCurrentMp(), character4.getCurrentMp());
        character4.setCurrentMp(5);
        character1.setCurrentMp(5);
        assertEquals(character1.getCurrentMp(), character4.getCurrentMp());
        character4.setCurrentMp(3);
        character1.setCurrentMp(2);
        assertNotEquals(character1.getCurrentMp(), character4.getCurrentMp());
    }

    @Test
    public void testGetMaxMp() {
        assertEquals(character1.getMaxMp(), character1.getMaxMp());
        assertEquals(character1.getMaxMp(), character2.getMaxMp());
        assertNotEquals(character2.getMaxMp(), character3.getMaxMp());
        assertEquals(character4.getMaxMp(), character4.getMaxMp());
        assertEquals(character1.getMaxMp(), character4.getMaxMp());
        assertNotEquals(character1.getMaxMp(), character5.getMaxMp());
    }

    @Test
    public void setANDgetFactory() {
        Thunderfactory tr = new Thunderfactory();
        abmage1.setFactory(tr);
        assertEquals(abmage1.getFactory(), tr);
        assertNotEquals(abmage1.getFactory(), abmage3.getFactory());
        abmage3.setFactory(tr);
        assertEquals(abmage1.getFactory(), abmage3.getFactory());
    }

    @Test
    public void castmagic() throws InvalidEquippableWeapon {
        Thunderfactory tr = new Thunderfactory();
        HealFactory cu = new HealFactory();
        Staff st = new Staff("staff",20,20,100);
        abmage1.equip(st);
        abmage2.equip(st);
        abmage1.setFactory(tr);
        abmage2.setFactory(cu);
        assertEquals(abmage3.getCurrentHp(), 100);
        abmage1.castmagic(abmage3);
        assertEquals(abmage3.getCurrentHp(), 50);
        abmage2.castmagic(abmage3);
        assertEquals(abmage3.getCurrentHp(), 80);
        abmage2.castmagic(abmage3);
        assertEquals(abmage3.getCurrentHp(), 100);
        abmage1.setFactory(new FireFactory());
        abmage1.castmagic(abmage3);
        assertEquals(abmage3.getCurrentHp(), 50);
        abmage2.setFactory(new ParalysisFactory());
        abmage2.castmagic(abmage2);
        assertTrue(abmage2.getState().isparalized());
        abmage2.setFactory(new PoisonFactory());
        abmage2.castmagic(abmage1);
        assertTrue(abmage1.getState().ispoisoned());
    }
}