package rpg_lab;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class HeroTest {

    private static final String NAME = "Jared";
    private static final int EXPERIENCE = 200;

    private Hero hero;

    @Test
    public void attack_Hero_Gets_Experience_When_Target_Dead() {

        // creating an anonymous instance of the dependency needed
        // it returns void so we can implement it without writing anything
        Weapon fakeWeapon = new Weapon() {
            @Override
            public void attack(Target target) {

            }
        };

        Target fakeTarget = new Target() {
            @Override
            public boolean isDead() {
                return true;
            }

            @Override
            public int giveExperience() {
                return EXPERIENCE;
            }

            @Override
            public void takeAttack(int attackPoints) {

            }
        };

        this.hero = new Hero(NAME, fakeWeapon);
        this.hero.attack(fakeTarget);
        assertEquals(EXPERIENCE, this.hero.getExperience());
    }

}