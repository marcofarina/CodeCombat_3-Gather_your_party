package codeCombat;

import codeCombat.characters.*;

public class Main {
    public static void main(String[] args) {
        try {
            Barbarian hero = new Barbarian("Wulfgar", 150, 10, 5, "2d6", 4, 10);
            Barbarian villain = new Barbarian("Bowser", 150, 10, 5, "1d12", 4, 10);

            System.out.println("Start of combat between " + hero.getName() + " and " + villain.getName());

            while (hero.isAlive() && villain.isAlive()) {
                int damage = hero.action();
                villain.takeDamage(damage);
                hero.rechargeMana();

                damage = villain.action();
                hero.takeDamage(damage);
                villain.rechargeMana();


                System.out.println("\n");
            }

            if (!hero.isAlive()) {
                System.out.println(hero.getName() + " is defeated. " + villain.getName() + " wins.");
            } else {
                System.out.println(villain.getName() + " is defeated. " + hero.getName() + " wins.");
            }

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

}
