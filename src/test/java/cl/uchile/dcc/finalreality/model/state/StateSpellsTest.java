package cl.uchile.dcc.finalreality.model.state;

import cl.uchile.dcc.finalreality.exceptions.InvalidState;
import cl.uchile.dcc.finalreality.model.character.enemies.Enemy;
import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import cl.uchile.dcc.finalreality.model.spells.factory.*;
import cl.uchile.dcc.finalreality.model.character.player.magic.BlackMage;
import cl.uchile.dcc.finalreality.model.character.player.magic.WhiteMage;
import cl.uchile.dcc.finalreality.model.weapon.Staff;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import static org.junit.jupiter.api.Assertions.*;

public class StateSpellsTest {
    Enemy enemyv;
    Enemy enemyt;
    Enemy enemyf;
    Enemy enemyc;
    Enemy enemyp;
    BlackMage truenomage;
    BlackMage fuegomage;
    WhiteMage curamage;
    WhiteMage paralisismage;
    WhiteMage venenomage;
    BlockingQueue<GameCharacter> queue = new LinkedBlockingQueue<>();
    Staff staff;

    @BeforeEach
    public void setUp() throws Exception {
        enemyv = new Enemy("", 100, 100, 10000, 100, queue);
        enemyt = new Enemy("", 100, 100, 10000, 100, queue);
        enemyf = new Enemy("", 100, 100, 10000, 100, queue);
        enemyc = new Enemy("", 100, 100, 10000, 100, queue);
        enemyp = new Enemy("", 100, 100, 10000, 100, queue);
        staff = new Staff("", 100,100,100);
        truenomage = new BlackMage("", 100, 100, 100, queue);
        truenomage.setFactory(new Thunderfactory());
        truenomage.equip(staff);
        fuegomage = new BlackMage("", 100, 100, 100, queue);
        fuegomage.setFactory(new FireFactory());
        fuegomage.equip(staff);
        curamage = new WhiteMage("", 100, 100, 100, queue);
        curamage.setFactory(new HealFactory());
        curamage.equip(staff);
        paralisismage = new WhiteMage("", 100, 100, 100, queue);
        paralisismage.setFactory(new ParalysisFactory());
        paralisismage.equip(staff);
        venenomage = new WhiteMage("", 100, 100, 100, queue);
        venenomage.setFactory(new PoisonFactory());
        venenomage.equip(staff);
    }

    @Test
    public void paralize() {
        paralisismage.castmagic(enemyp);
        assertTrue(enemyp.isparalized());
        assertFalse(enemyp.isnormal());
        assertFalse(enemyp.isburned());
        assertFalse(enemyp.ispoisoned());
        assertThrows(InvalidState.class, () -> enemyp.poison());
        assertThrows(InvalidState.class, () -> enemyp.burn());
    }

    @Test
    public void burn() {
        fuegomage.castmagic(enemyf);
        assertTrue(enemyf.isburned());
        assertFalse(enemyf.isnormal());
        assertFalse(enemyf.isparalized());
        assertFalse(enemyf.ispoisoned());
        assertThrows(InvalidState.class, () -> enemyf.poison());
        assertThrows(InvalidState.class, () -> enemyf.paralize());
    }

    @Test
    public void poison() {
        venenomage.castmagic(enemyv);
        assertTrue(enemyv.ispoisoned());
        assertFalse(enemyv.isnormal());
        assertFalse(enemyv.isparalized());
        assertFalse(enemyv.isburned());
        assertThrows(InvalidState.class, () -> enemyv.burn());
        assertThrows(InvalidState.class, () -> enemyv.paralize());
    }

    @Test
    public void normal() {
        assertFalse(enemyv.ispoisoned());
        assertTrue(enemyv.isnormal());
        assertFalse(enemyv.isparalized());
        assertFalse(enemyv.isburned());
    }
}