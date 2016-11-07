/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import java.util.Random;

/**
 *
 * @author David Darío Del Prado González
 */
public class Game
{
    //Random utility class
    
    Random random;
    
    
    //Constants
    
    /**
     * 
     */
    public static final int SECOND_POINTS = 30;
    /**
     * The integer to get the add operation
     */
    public static final int OPERATION_ADD = 0;
    /**
     * The integer to get the substraction operation
     */
    public static final int OPERATION_SUB = 1;
    /**
     * The integer to get the multiplication operation
     */
    public static final int OPERATION_TIMES = 2;
    /**
     * The integer to get the division operation
     */
    public static final int OPERATION_DIV = 3;    
    
    
    //Attributes
    
    /**
     * The first operand.
     */
    private int operand1;
    /**
     * The second operand.
     */
    private int operand2;
    /**
     * The operation randomly generated for a level.
     */
    private int operation;
    /**
     * Defines the difficulty for the game.
     */
    private int difficulty;
    
    
    //Logic
    
    public Game()
    {
        //Set the initial difficulty
        difficulty = 10;
        random = new Random();
    }
    
    /**
     * Randomly generates the operands and the operation.
     * <br>
     * The operands number of digits is obtained via difficulty digits - 1.
     */
    public void generateOperation()
    {
        //Generate the operands
        operand1 = difficulty/10 + random.nextInt(difficulty - difficulty/10);
        operand2 = difficulty/10 + random.nextInt(difficulty - difficulty/10);
        
        //Generate the operation
        operation = random.nextInt(4);
    }
    
    /**
     * Increases the difficulty.
     */
    public void increaseDifficulty()
    {
        difficulty *= 10;
    }
    
    /**
     * Resets the difficulty to 10
     */
    public void reset()
    {
        difficulty = 10;
    }

    public int getOperand1()
    {
        return operand1;
    }

    public int getOperand2()
    {
        return operand2;
    }

    public int getOperation()
    {
        return operation;
    }
}
