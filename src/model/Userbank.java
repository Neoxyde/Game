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

    /**
     * JSON utility class to save data to a JSON file.
     */
    private Gson gson;
    
    /**
     * JSON file to store data
     */
    private File file;

    public Userbank()
    {
        userList = new HashMap<>();
    }

    public Userbank(File file)
    {
        //Reference the file
        this.file = file;
        
        if (this.file.exists())
        {
            loadFromJSON(this.file);
        } 
        //If the JSON file is null
        else
        {
            //Create the JSON file
            try
            {
                this.file.createNewFile();
            } catch (IOException ex)
            {
                Logger.getLogger(Userbank.class.getName()).log(Level.SEVERE, null, ex);
            }
            //Create the hashmap.
            userList = new HashMap<>();
        }
    }

    /**
     * Creates a new user and stores it on the HashMap only and only if the
     * Hashmap does not contain a User with the same name already.
     * 
     * @param name The name of the User, used as a key to the HashMap.
     * @return True if there was no User with the specified name on the hashmap,
     * thus having inserted the new User, and false if there was a a key already.
     */
    public boolean addUser(String name)
    {
        if (userList.containsKey(name))
        {
            return false;
        } else
        {
            userList.put(name, new User(name));
            return true;
        }
    }

    /**
     * Gets the user with the specified name, <i>only if<i> the Hashmap has a 
     * User with the specified name.
     * @param name The name of the User, used as a key to the HashMap.
     * @return The user if it was found, or <tt>null</tt> if it wasn't.
     */
    public User getUser(String name)
    {
        if (userList.containsKey(name))
        {
            return userList.get(name);
        } else
        {
            return null;
        }
    }

    /**
     * Gets all the stored users names.
     *
     * @return An String array containing all the names.
     */
    public String[] getUsersNames()
    {
        String[] names = null;
        if (userList.isEmpty())
        {
            return null;
        } else
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
     *
     * @param file The file from which the users are loaded.
     */
    private void loadFromJSON(File file)
    {
        try
        {
            //Create readers
            FileReader reader = new FileReader(file);
            BufferedReader input = new BufferedReader(reader);

            //Set the line
            String line = input.readLine();

            //Set the hashmap from the JSON file.
            if (line != null)
            {
                userList = new Gson().fromJson(line, new TypeToken<HashMap<String, User>>()
                {
                }.getType());
            }
            else
            {
                userList = new HashMap<>();
            }
            
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
     * Saves all the users to a JSON file.
     *
     * @param file The file to which the users will be saved.
     */
    public void saveToJSON(File file)
    {
        try
        {
            gson = new Gson();
            FileWriter fileWriter = new FileWriter(file);
            gson.toJson(userList, fileWriter);
            fileWriter.flush();
            fileWriter.close();
        } catch (IOException ex)
        {
            Logger.getLogger(Userbank.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void saveToJSON()
    {
        try
        {
            gson = new Gson();
            FileWriter fileWriter = new FileWriter(file);
            gson.toJson(userList, fileWriter);
            fileWriter.flush();
            fileWriter.close();
        } catch (IOException ex)
        {
            Logger.getLogger(Userbank.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
