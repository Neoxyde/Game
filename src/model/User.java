/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import game.Game;
import java.util.HashMap;


/**
 *
 * @author David Darío Del Prado González
 */
public class User
{
    /**
     * The user's name.
     */
    private String name;
    
    /**
     * The user's max puntuation.
     */
    private int maxPunctuation;
    
    /**
     * The user's last puntuation.
     */
    private int lastPunctuation;
    
    /**
     * Maps the hashed operations;
     */
    private HashMap<String, Integer> operations;
    
    /**
     * The number of operations
     */
    private int totalOperations;
    
    public User()
    {
        name = "";
        maxPunctuation = 0;
        lastPunctuation = 0;
        operations = new HashMap<>();
        operations.put("+", 0);
        operations.put("-", 0);
        operations.put("*", 0);
        operations.put("/", 0);
        totalOperations = 0;
    }
    
    public User(String name)
    {
        this();
        this.name = name;
    }

    public String getName()
    {
        return name;
    }

    public int getMaxPunctuation()
    {
        return maxPunctuation;
    }

    public int getLastPunctuation()
    {
        return lastPunctuation;
    }

    public int getTotalOperation()
    {
        return totalOperations;
    }
    
    public int getResolvedOperation(String operation)
    {
        return operations.get(operation);
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public void setMaxPunctuation(int maxPunctuation)
    {
        this.maxPunctuation = maxPunctuation;
    }

    public void setLastPunctuation(int lastPunctuation)
    {
        this.lastPunctuation = lastPunctuation;
    }

    public void setTotalOperation(int totalOperation)
    {
        this.totalOperations = totalOperation;
    }
    
    public void addResolvedOperation(String operation)
    {
        totalOperations++;
        
        //Overwrite the operation and add a resolved operation.
        operations.put(operation, operations.get(operation) + 1);
    }
    
    public void addWrongOperation()
    {
        totalOperations++;
    }
    
}
