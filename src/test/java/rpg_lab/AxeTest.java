package rpg_lab;

// import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import rpg_lab.Axe;
import rpg_lab.Dummy;

import static org.junit.Assert.*;

public class AxeTest {

    private static final int ATTACK = 13;
    private static final int DURABILITY = 42;
    private static final int HEALTH = 100;
    private static final int EXPERIENCE = 200;

    private Axe axe;
    private Dummy dummy;

    @Before
    public void setUp() {
        this.axe = new Axe(ATTACK, DURABILITY);
        this.dummy = new Dummy(HEALTH, EXPERIENCE);
    }

    // each test is a separate method
    // all those methods must be public and return nothing (void) without access modifier
    // the name of the method tests must be very descriptive
    @Test
    // the annotation @Test is for Maven to recognise that this method is a test. Otherwise, there is no way this method to be recognised as such.
    public void create_Axe_With_Correct_Values_For_Attack_And_Durability() {
        assertEquals(ATTACK, axe.getAttackPoints());
        assertEquals(DURABILITY, axe.getDurabilityPoints());
    }

    @Test
    public void Attack_checking_DurabilityPoints_Are_Enough() {
        axe.attack(dummy);

        assertEquals(DURABILITY - 1, axe.getDurabilityPoints());
    }

    @Test(expected = IllegalStateException.class)
    public void Attack_With_Broken_Weapon_Should_Fail_Durability_Low() {
        this.axe = new Axe(ATTACK, 0);
        axe.attack(dummy);
        // junit5 syntax (works for this version as well)
        // String message = assertThrows(IllegalStateException.class, ()->axe.attack(dummy)).getMessage();
        // assertEquals("Axe is broken.", message);
    }
}
