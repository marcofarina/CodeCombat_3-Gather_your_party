package codeCombat;

import codeCombat.exceptions.DiceFormatException;
import codeCombat.utility.Verbose;

import java.util.Arrays;

public abstract class Character {
    protected final String name;
    protected int health;
    protected final int maxHealth;
    protected int mana;
    protected final int manaGain;
    protected String attackDice;
    protected int attackCost;
    protected int specialActionCost = 1;
    protected int armor = 0;

    protected Character(
            String name,
            int health,
            int mana,
            int manaGain,
            String attackDice,
            int attackCost,
            int specialActionCost,
            int armor
    ) throws IllegalArgumentException {

        //check if attack string is in the correct format: 'xdy'
        if(!attackDice.matches("\\d+d\\d+")) throw new IllegalArgumentException("Invalid attack format");

        if(health < 0 || mana < 0 || manaGain < 0 || attackCost < 1) throw new IllegalArgumentException("Health, mana, and manaGain must be greater than 0. attackCost must be greater than 1.");

        this.name = name;
        this.health = health;
        this.maxHealth = health;
        this.mana = mana;
        this.manaGain = manaGain;
        this.attackDice = attackDice;
        this.attackCost = attackCost;
        this.specialActionCost = specialActionCost;
        this.armor = armor;

        Verbose.print("Character " + name + " created.");
    }

    protected Character(
            String name,
            int health,
            int mana,
            int manaGain,
            String attackDice,
            int attackCost,
            int specialActionCost
    ) throws IllegalArgumentException {
        this(name, health, mana, manaGain, attackDice, attackCost, specialActionCost, 0);
    }

    /**** ACTIONS ****/
    public abstract int action();

    protected abstract int specialAction();

    /*** DAMAGES ***/
    public void takeDamage(int damage) {
        int damageReducedByArmor = damage-armor;
        health -= Math.max(0, damageReducedByArmor);
        Verbose.print("'" + name + "' has taken " + damageReducedByArmor + " damage.");
        if(armor > 0) Verbose.print("The damage was reduced by " + armor +" armor.");
    }

    public int attack() {
        if (mana < attackCost) {
            Verbose.print("'" + name + "' has insufficient mana to perform the attack.");
            return 0;
        }

        int rolls;
        try {
            rolls = Dice.rollsAndSum(attackDice);
        } catch (DiceFormatException e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }

        mana -= attackCost;

        Verbose.print("'" + name + "' is dealing " + rolls + " damage.");
        return rolls;
    }

    public String getAttackDice() {
        return attackDice;
    }

    /*** HEALTH ***/
    public int getHealth() {
        return health;
    }

    /*** MANA ***/
    public int getMana() {
        return mana;
    }

    public int getManaGain() {
        return manaGain;
    }

    public void rechargeMana() {
        mana += manaGain;
    }

    /*** CHARACTER INFO ***/
    public String getName(){
        return name;
    }

    public boolean isAlive() {
        return health > 0;
    }

    @Override
    public String toString() {
        return "Character{" +
                "name='" + name + "'" +
                ", life=" + health +
                ", armor=" + armor +
                ", mana=" + mana +
                ", manaGain=" + manaGain +
                ", attackCost=" + attackCost +
                ", attackDice='" + attackDice + "'" +
                '}';
    }
}