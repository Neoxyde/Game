/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author David Darío Del Prado González
 */
public class Userbank
{
    /**
     * Contains all the users, hashed by their names.
     */
    private HashMap<String, User> userList;
    
    private Gson gson;
    
    public Userbank()
    {
	userList = new HashMap<>();
    }
    
    public Userbank(File file)
    {
	//If the JSON file is not null
	if (file.exists())
	{
	    loadFromJSON(file);
	}
	//If the JSON file is null
	else
	{
	    //Create the hashmap.
	    userList = new HashMap<>();
	}
    }
    
    public boolean addUser(String name)
    {
	if (userList.containsKey(name))
	{
	    return false;
	}
	else
	{
	    userList.put(name, new User(name));
	    return true;
	}
    }
    
    public User getUser(String name)
    {
	if (userList.containsKey(name))
	{
	    return userList.get(name);
	}
	else
	{
	    return null;
	}
    }
    
    /**
     * Gets all the stored users names.
     * @return An String array containing all the names.
     */
    public String[] getUsersNames()
    {
	String[] names = null;
	if (userList.isEmpty())
	{
	    return null;
	}
	else
	{
	    return userList.keySet().toArray(names);
	}
    }

    public HashMap<String, User> getHashMap()
    {
	return userList;
    }

    /**
     * Loads all the users from a JSON file.
     * @param file The file from which the users are loaded.
     */
    private void loadFromJSON(File file)
    {
	try
	{
	    //Create readers
	    FileReader reader = new FileReader(file);
	    BufferedReader bufferedReader = new BufferedReader(reader);

	    //Set the line
	    String line = bufferedReader.readLine();

	    //Set the hashmap from the JSON file.
	    userList = new Gson().fromJson(line, new TypeToken<HashMap<String, User>>()
	    {
	    }.getType());

	    //Close the reader.
	    reader.close();
	} catch (FileNotFoundException ex)
	{
	    Logger.getLogger(Userbank.class.getName()).log(Level.SEVERE, null, ex);
	} catch (IOException ex)
	{
	    Logger.getLogger(Userbank.class.getName()).log(Level.SEVERE, null, ex);
	}
    }
    
    /**
     * Saves all the users to a JSON file
     * @param file The file to which the users will be saved.
     */
    public void saveToJSON(File file)
    {
	try
	{
	    Gson gson = new  Gson();
	    FileWriter fileWriter = new FileWriter(file);
	    gson.toJson(userList,fileWriter);
	    fileWriter.flush();
	    fileWriter.close();
	} catch (IOException ex)
	{
	    Logger.getLogger(Userbank.class.getName()).log(Level.SEVERE, null, ex);
	} 
    }
    
    
    
    
}
