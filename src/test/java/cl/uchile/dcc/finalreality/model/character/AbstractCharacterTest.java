package cl.uchile.dcc.finalreality.model.character;

import cl.uchile.dcc.finalreality.exceptions.InvalidEquippableWeapon;
import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.model.character.enemies.Enemy;
import cl.uchile.dcc.finalreality.model.character.player.common.Knight;
import cl.uchile.dcc.finalreality.model.character.player.magic.BlackMage;
import cl.uchile.dcc.finalreality.model.weapon.Staff;
import cl.uchile.dcc.finalreality.model.weapon.Sword;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import static org.junit.jupiter.api.Assertions.*;

class AbstractCharacterTest {
    BlockingQueue<GameCharacter> queue = new LinkedBlockingQueue<>();
    private Knight character1;
    private Knight character2;
    private Knight character3;
    private BlackMage character4;
    private BlackMage character5;
    private BlackMage character6;
    private Enemy character7;
    private Enemy character8;
    private Enemy character9;
    private Sword weapon1;
    private Staff weapon2;

    @BeforeEach
    public void setUp() throws InvalidStatValueException {
        character1 = new Knight("Malenia", 10, 10, queue);
        character2 = new Knight("Malenia", 10, 10, queue);
        character3 = new Knight("Melania", 9, 9, queue);
        character4 = new BlackMage("Godfrey", 10, 10, 10, queue);
        character5 = new BlackMage("Godfrey", 10, 10, 10, queue);
        character6 = new BlackMage("Gody", 9, 9, 9, queue);
        character7 = new Enemy("Blaidd", 10, 10, 10, 10, queue);
        character8 = new Enemy("Blaidd", 10, 10, 10, 10, queue);
        character9 = new Enemy("Blai", 9, 9, 9, 9, queue);

        weapon1 = new Sword("Hand of Melania", 10, 5);
        weapon2 = new Staff("Crystal Staff", 10, 20,5);
    }

    @Test
    public void testGetName() {
        assertEquals(character1.getName(), character1.getName());
        assertEquals(character1.getName(), character2.getName());
        assertNotEquals(character2.getName(), character3.getName());
        assertEquals(character4.getName(), character4.getName());
        assertEquals(character4.getName(), character5.getName());
        assertNotEquals(character4.getName(), character6.getName());
        assertEquals(character7.getName(), character7.getName());
        assertEquals(character7.getName(), character8.getName());
        assertNotEquals(character7.getName(), character9.getName());
        assertNotEquals(character1.getName(), character4.getName());
        assertNotEquals(character1.getName(), character7.getName());
    }

    @Test
    public void testGetCurrentHp() {
        assertEquals(character1.getCurrentHp(), character1.getCurrentHp());
        assertEquals(character1.getCurrentHp(), character2.getCurrentHp());
        assertNotEquals(character2.getCurrentHp(), character3.getCurrentHp());
        assertEquals(character4.getCurrentHp(), character4.getCurrentHp());
        assertEquals(character4.getCurrentHp(), character5.getCurrentHp());
        assertNotEquals(character4.getCurrentHp(), character6.getCurrentHp());
        assertEquals(character7.getCurrentHp(), character7.getCurrentHp());
        assertEquals(character7.getCurrentHp(), character8.getCurrentHp());
        assertNotEquals(character7.getCurrentHp(), character9.getCurrentHp());
        assertEquals(character3.getCurrentHp(), character6.getCurrentHp());
        assertEquals(character6.getCurrentHp(), character9.getCurrentHp());
    }

    @Test
    public void testGetMaxHp() {
        assertEquals(character1.getMaxHp(), character1.getMaxHp());
        assertEquals(character1.getMaxHp(), character2.getMaxHp());
        assertNotEquals(character2.getMaxHp(), character3.getMaxHp());
        assertEquals(character4.getMaxHp(), character4.getMaxHp());
        assertEquals(character4.getMaxHp(), character5.getMaxHp());
        assertNotEquals(character4.getMaxHp(), character6.getMaxHp());
        assertEquals(character7.getMaxHp(), character7.getMaxHp());
        assertEquals(character7.getMaxHp(), character8.getMaxHp());
        assertNotEquals(character7.getMaxHp(), character9.getMaxHp());
        assertEquals(character3.getMaxHp(), character6.getMaxHp());
        assertEquals(character6.getMaxHp(), character9.getMaxHp());
    }

    @Test
    public void testGetDefense() {
        assertEquals(character1.getDefense(), character1.getDefense());
        assertEquals(character1.getDefense(), character2.getDefense());
        assertNotEquals(character2.getDefense(), character3.getDefense());
        assertEquals(character4.getDefense(), character4.getDefense());
        assertEquals(character4.getDefense(), character5.getDefense());
        assertNotEquals(character4.getDefense(), character6.getDefense());
        assertEquals(character7.getDefense(), character7.getDefense());
        assertEquals(character7.getDefense(), character8.getDefense());
        assertNotEquals(character7.getDefense(), character9.getDefense());
        assertEquals(character3.getDefense(), character6.getDefense());
        assertEquals(character6.getDefense(), character9.getDefense());
    }

    @Test
    public void testSetCurrentHp() throws InvalidStatValueException {
        assertEquals(character1.getCurrentHp(), character2.getCurrentHp());
        character2.setCurrentHp(5);
        character1.setCurrentHp(5);
        assertEquals(character1.getCurrentHp(), character2.getCurrentHp());
        character2.setCurrentHp(3);
        character1.setCurrentHp(2);
        assertNotEquals(character1.getCurrentHp(), character2.getCurrentHp());
        assertEquals(character4.getCurrentHp(), character5.getCurrentHp());
        character4.setCurrentHp(5);
        character5.setCurrentHp(5);
        assertEquals(character4.getCurrentHp(), character5.getCurrentHp());
        character4.setCurrentHp(3);
        character5.setCurrentHp(2);
        assertNotEquals(character4.getCurrentHp(), character5.getCurrentHp());
        assertEquals(character7.getCurrentHp(), character8.getCurrentHp());
        character7.setCurrentHp(5);
        character8.setCurrentHp(5);
        assertEquals(character7.getCurrentHp(), character8.getCurrentHp());
        character7.setCurrentHp(3);
        character8.setCurrentHp(2);
        assertNotEquals(character7.getCurrentHp(), character8.getCurrentHp());
    }

    @Test
    void waitTurn() throws InterruptedException, InvalidEquippableWeapon {
        character1.equip(weapon1);
        character4.equip(weapon2);
        character1.waitTurn();
        character4.waitTurn();
        character7.waitTurn();
        int count = 0;
        Thread.sleep(6000);
        while (!queue.isEmpty()) {
            // Pops and prints the names of the characters of the queue to illustrate the turns
            // order
            if (count==0){
                assertEquals(queue.poll().toString(), character1.toString());
                count++;
            } else if (count==1){
                assertEquals(queue.poll().toString(), character7.toString());
                count++;
            } else {
                assertEquals(queue.poll().toString(), character4.toString());
            }
        }
    }
}