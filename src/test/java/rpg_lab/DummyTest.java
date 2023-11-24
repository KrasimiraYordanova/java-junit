package rpg_lab;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DummyTest {

    private static final int HEALTH = 100;
    private static final int EXPERIENCE = 200;

    private static final int ATTACK_POINTS = 7;

    private Dummy dummy;

    @Before
    public void setUp() {
        this.dummy = new Dummy(HEALTH, EXPERIENCE);
    }

    @Test
    public void takeAttack_If_Alive_Dummy_Decrease_Health_When_Attacked() {
        dummy.takeAttack(ATTACK_POINTS);
        assertEquals(HEALTH - ATTACK_POINTS, dummy.getHealth());
    }

    @Test (expected = IllegalStateException.class)
    public void takeAttack_If_Not_Alive_Dummy_Throw_Exception_When_Attacked() {
        this.dummy = new Dummy(0, EXPERIENCE);
        dummy.takeAttack(ATTACK_POINTS);
    }

    @Test
    public void giveExperience_Dummy_Gives_Experience_When_Dead() {
        this.dummy = new Dummy(0, EXPERIENCE);
        int actualExperience = dummy.giveExperience();
        assertEquals(EXPERIENCE, actualExperience);
    }

    @Test (expected = IllegalStateException.class)
    public void giveExperience_Dummy_Throws_Exception_When_Not_Dead() {
       dummy.giveExperience();
    }

    @Test
    public void isDead_Dummy_Health_Zero() {
        this.dummy = new Dummy(0, EXPERIENCE);
        boolean isDead = dummy.isDead();
        assertTrue(isDead);
    }

    @Test
    public void isDead_Dummy_Health_Zero_Or_Below() {
        this.dummy = new Dummy(-5, EXPERIENCE);
        boolean isDead = dummy.isDead();
        assertTrue(isDead);
    }

    @Test
    public void isDead_Dummy_Alive() {
        boolean isDead = dummy.isDead();
        assertFalse(isDead);
    }
}