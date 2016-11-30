/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.HashMap;
import javax.swing.table.AbstractTableModel;


/**
 *
 * @author David Darío Del Prado González
 */
public class User extends AbstractTableModel implements Comparable<User>
{
    /**
     * The number of stats that are relevant for the global rank;
     */
    public static final int GLOBAL_STATS_COUNT = 4;
    
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

    public int getTotalOperations()
    {
        return totalOperations;
    }
    
    public int getResolvedOperations()
    {
        return operations.get("+") + operations.get("-") + operations.get("/") + operations.get("x");
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
        
        // Update the max punctuation if the last punctuation is greater
        if (lastPunctuation > maxPunctuation)
        {
            maxPunctuation = lastPunctuation;
        }
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
        operations.put(operation, (operations.get(operation) + 1));
    }
    
    /**
     * Add a failed operation to the user. Note that this won't add an operation
     * to the operations list the user has.
     */
    public void addWrongOperation()
    {
        totalOperations++;
    }

    @Override
    public int getRowCount()
    {
        return 1;
    }

    @Override
    public int getColumnCount()
    {
        return 4;
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex)
    {
        return false;
    }

    @Override
    public String getColumnName(int column)
    {
        String aux;
        switch (column)
        {
            case 0:
                aux = "Sumas";
                break;
            case 1:
                aux = "Restas";
                break;
            case 2:
                aux = "Multiplicaciones";
                break;
            case 3:
                aux = "Divisiones";
                break;
            default:
                aux = "";
                break;             
        }
        return aux;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex)
    {
        // Auxiliar object to store the values and returning them
        Object aux;
        
        // Show the auxiliar user attribute depending on what column was asked for
        switch (columnIndex)
        {
            case 0:
                aux = operations.get("+");
                break;
            case 1:
                aux = operations.get("-");
                break;
            case 2:
                aux = operations.get("x");
                break;
            default:
                aux = operations.get("/");
                break;
        }
        return aux;
    }

    /**
     * Compares the users for their MaxPunctuation order
     * @param otherUser Other user to be compared with the one that this method belongs to
     * @return Significative integer result of the comparing process
     */
    @Override
    public int compareTo(User otherUser)
    {
        return Integer.compare(maxPunctuation, otherUser.getMaxPunctuation());
    }
    
}
