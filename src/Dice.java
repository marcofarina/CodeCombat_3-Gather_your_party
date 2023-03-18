package codeCombat;

import codeCombat.exceptions.DiceFormatException;
import codeCombat.utility.Verbose;

import java.util.Arrays;
import java.util.Random;

public class Dice {
    // Prevent instantiation of the class
    private Dice() {}

    /**
     * Rolls a specified number of dice with a specified number of faces each.
     * The dice notation should be in the format 'xdy', where x is the number of dice
     * and y is the number of faces per die. Both x and y must be positive integers.
     *
     * @param diceNotation the notation of the dice to be rolled
     * @return an array of integers representing the result of each roll
     * @throws DiceFormatException if the dice notation is not in the correct format (xdy) or if the number of dice
     * specified is outside the valid range of values
     * @throws IllegalArgumentException if the dice notation string is null
     */
    public static int[] roll(String diceNotation) throws DiceFormatException, IllegalArgumentException {
        if (diceNotation == null) {
            throw new IllegalArgumentException("diceNotation cannot be null");
        }
        String[] parts = diceNotation.split("d");
        if (parts.length != 2) {
            throw new DiceFormatException("Invalid dice notation format: " + diceNotation);
        }

        int numberOfDice;
        int numberOfFaces;
        try {
            numberOfDice = Integer.parseInt(parts[0]);
            numberOfFaces = Integer.parseInt(parts[1]);
        } catch (NumberFormatException e) {
            throw new DiceFormatException("Invalid dice notation format: " + diceNotation, e);
        }

        if (numberOfDice <= 0 || numberOfDice > 100) {
            throw new DiceFormatException("Number of dice must be between 1 and 100: " + diceNotation);
        }

        int[] rolls = new int[numberOfDice];
        Random random = new Random();
        for (int i = 0; i < numberOfDice; i++) {
            rolls[i] = random.nextInt(numberOfFaces) + 1;
        }
        return rolls;
    }

    /**
     * Rolls a specified number of dice with a specified number of faces each and returns the sum of the rolls.
     *
     * @param diceNotation the notation of the dice to be rolled
     * @return the sum of the rolls
     * @throws DiceFormatException if the dice notation is not in the correct format
     * @throws DiceFormatException if the dice notation is not in the correct format (xdy) or if the number of dice
     * specified is outside the valid range of values
     * @throws IllegalArgumentException if the dice notation string is null
     */
    public static int rollsAndSum(String diceNotation) throws DiceFormatException,
            IllegalArgumentException {
        if (diceNotation == null) {
            throw new IllegalArgumentException("diceNotation cannot be null");
        }
        int[] rolls = roll(diceNotation);
        Verbose.print(Arrays.toString(rolls));
        int sum = 0;
        for (int roll : rolls) {
            sum += roll;
        }
        return sum;
    }
}