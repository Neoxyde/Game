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
     * The maximum bonus points the user can have for solving an operation in time
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
    
    private int solution;
    
    
    
    
    //Logic
    
    public Game()
    {
        //Set the initial difficulty
        difficulty = 10;
        random = new Random();
    }
    
    /**
     * TODO Improve the operation generation
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
        
        //Calculate the solution based on what operation was randomly generated.
        switch (operation)
        {
            case OPERATION_ADD:
                solution = operand1 + operand2;
                break;
            case OPERATION_SUB:
                solution = operand1 - operand2;
                break;
            case OPERATION_TIMES:
                solution = operand1 * operand2;
                break;
            case OPERATION_DIV:
                solution = (int) operand1 / operand2;
                break;
            default:
                throw new AssertionError();
        }
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
    
    public int calculatePoints(int time)
    {
        //Aux variable to store the total points
        int points = 0;
        
        //Assign base points depending of what operation was resolved
        switch (operation)
        {
            case OPERATION_ADD:
                points = 2;
                break;
            case OPERATION_SUB:
                points = 2;
                break;
            case OPERATION_TIMES:
                points = 4;
                break;
            case OPERATION_DIV:
                points = 6;
                break;
            default:
                throw new AssertionError();
        }
        
        //Multiply points and difficulty
        points = points * difficulty;
        
        //Calculate a possible time bonus
        if (time >= 20)
        {
            points = points + (5 * ((int)(points / 10)));
        }
        else if (time < 20 && time >= 10)
        {
            points = points + (3 * ((int)(points / 10)));
        }
        else if (time < 10 && time > 5)
        {
            points = points + (2 * ((int)(points / 2)));
        }
        
        //Return the total points
        return points;
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
    
    public String getStringOperation()
    {
        //Aux variable
        String aux;
        
        //Set the aux string depending of what operation was 
        switch (operation)
        {
            case OPERATION_ADD:
                aux = "+";
                break;
            case OPERATION_SUB:
                aux = "-";
                break;
            case OPERATION_TIMES:
                aux = "x";
                break;
            case OPERATION_DIV:
                aux = "/";
                break;
            default:
                throw new AssertionError();
        }
        
        return aux;
    }

    /**
     * Returns the solution to the current operation
     * @return an integer with the current operation solution
     */
    public int getSolution()
    {
        return solution;
    }
    
    
    
    
}
