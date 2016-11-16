/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

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
     * Maps the hashed correct operations;
     */
    private HashMap<String, Integer> operations;
    
    /**
     * The number of operations
     */
    private int totalOperations;
    
    /**
     * Create a new user with all attributes setted to 0.
     */
    public User()
    {
	//Set variables to 0
        name = "";
        maxPunctuation = 0;
        lastPunctuation = 0;
        operations = new HashMap<>();
        operations.put("+", 0);
        operations.put("-", 0);
        operations.put("x", 0);
        operations.put("/", 0);
        totalOperations = 0;
    }
    
    /**
     * Create a new user with all attributes setted to 0 but the name.
     * @param name User's name.
     */
    public User(String name)
    {
	//Call default constructor.
        this();
	
	//Set the name
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
    
    /**
     * Add a new operation to the resolved operations list the user has.
     * @param operation The type of operation the user resolved
     */
    public void addResolvedOperation(String operation)
    {
        totalOperations++;
        
        //Overwrite the operation and add a resolved operation.
        operations.put(operation, operations.get(operation) + 1);
    }
    
    /**
     * Add a failed operation to the user. Note that this won't add an operation
     * to the operations list the user has.
     */
    public void addWrongOperation()
    {
        totalOperations++;
    }
    
}
