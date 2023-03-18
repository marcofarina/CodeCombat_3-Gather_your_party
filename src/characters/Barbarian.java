package codeCombat.characters;

import codeCombat.Dice;
import codeCombat.Character;
import codeCombat.exceptions.DiceFormatException;
import codeCombat.utility.Verbose;

public class Barbarian extends Character {

    public Barbarian(String name, int health, int mana, int manaGain, String attackDice, int attackCost, int specialActionCost) throws IllegalArgumentException {
        super(name, health, mana, manaGain, attackDice, attackCost, specialActionCost, 2);
    }

    public int action() {
        if (mana >= specialActionCost) return specialAction();
        else return attack();
    }
    @Override
    public int specialAction() {
        int damage = attack();

        int roll;
        try{
            roll = Dice.roll("1d6")[0];
        } catch (DiceFormatException e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
        Verbose.print("Special action roll: " + roll);

        int wound = (int) Math.floor(0.2 * getHealth());

        if (roll == 5 || roll == 6) {
            Verbose.print(name + " is performing a double attack.");
            damage += attack();
        } else if (roll == 3 || roll == 4) {
            Verbose.print(name + " is performing a double attack but his rage costs him " + wound + " life points.");
            takeDamage(wound);
            damage += attack();
        } else if (roll == 1 || roll == 2) {
            takeDamage(wound);
            Verbose.print("Barbarian is charging forward, but he miss the second attack and get "+wound+" damages.");
        } else {
            Verbose.print("Invalid roll value!");
            return 0;
        }
        return damage;
    }
}