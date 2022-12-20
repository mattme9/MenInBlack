package program;

import db.Database;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import oru.inf.InfException;

/**
 * Detta är huvudklassen som håller all "logik", alltså funktioner.
 * Denna klass tar en Database, som är final av anledningen att när vi skapar
 * Program vill vi att Database som vi angett aldrig ändras.
 * 
 * Här finns alla metoder för att göra ändringar/läsa data från db.
 * 
 * @author Sara
 */
public class Program
{
    private final Database database;
    
    private User user;
    
    public Program(final Database database)
    {
        this.database = database;
    }
    
    public String getUserName()
    {
        if(!isLoggedIn())
        {
            System.err.println("Not logged in!");
            return null;
        }
        
        try
        {
            return database.getAgentNameById(user.getId());
        }
        catch (InfException ex)
        {
            System.err.println("Could not get username, reason: " + ex.getMessage());
            return null;
        }
    }
    
    public void logIn(int id, String password)
    {
        if(user != null)
        {
            System.out.println("Already logged in, log out first.");
            return;
        }
        
        try
        {
            user = database.logIn(id, password);
            System.out.println("Logged in as " + user.getName());
        }
        catch(InfException e)
        {
            System.err.println("Could not login, wrong username or password");
        }
    }
    
    public void printLoggedInUser()
    {
        if(user == null)
        {
            System.err.println("Youre not logged in!");
            return;
        }
        System.out.println(user.toString());
    }
    
    public void logOut()
    {
        user = null;
        System.out.println("You have logged out!");
    }
    
    public boolean isLoggedIn()
    {
        return user != null;
    }
    
    public void changePassword(String password)
    {
        if(!isLoggedIn())
        {
            System.err.println("Log in first!");
            return;
        }
        
        try
        {
            database.changePassword(user, password);
        }
        catch (InfException ex)
        {
            System.err.println("Could not change password, reason: " + ex.getMessage());
        }
    }
    
    public void printAllAgents()
    {
        try
        {
            ArrayList<HashMap<String, String>> agents = database.listAllAgents();
            for(var map : agents)
            {
                for(var entry : map.entrySet())
                {
                    System.out.println(entry.getKey() + "=" + entry.getValue());
                }
                System.out.println("\n");
            }
        }
        catch (InfException ex)
        {
            System.err.println("WOPS");
        }
    }
}
