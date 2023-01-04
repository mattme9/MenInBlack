package program;

import db.Database;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
    private UserAlien alien;
    
    public Program(final Database database)
    {
        this.database = database;
    }
    
    public boolean isAdmin()
    {
        return user != null && user.isIsAdmin();
    }
    
    public String getUserName()
    {
        if(!isLoggedIn())
        {
            System.err.println("Not logged in!");
            return null;
        }
        
        if(isLoggedInAsAgent())
        {
            return user.getName();
        }
        else if(isLoggedInAsAlien())
        {           
            return alien.getName();
        }
        else
        {
            return "";
        }
    }
    
    public String getAlienContact(){
        try {
            return database.getAgentNameById(alien.getContact());
        } catch (InfException ex) {
            System.err.println("Error: " + ex.getMessage());
            return "";
        }
    }
    
    public boolean isLoggedInAsAgent()
    {
        return user != null;
    }
    
    public boolean isLoggedInAsAlien()
    {
        return alien != null;
    }
    
    public List<String> getAllAgents()
    {
        try {
            
            return database.listAllAgentsName();
        } catch (InfException ex) {
            Logger.getLogger(Program.class.getName()).log(Level.SEVERE, null, ex);
            return new ArrayList<>();
        }
    }
    
    public List<String> getAllPlatser()
    {
           try {
               
               return database.listAllPlatserBenamning();
           } catch (InfException ex) {
               Logger.getLogger(Program.class.getName()).log(Level.SEVERE, null, ex);
               return new ArrayList<>();
           }
    }
    public void logIn(int id, String password)
    {
        if(user != null || alien != null)
        {
            System.out.println("Already logged in, log out first.");
            return;
        }
        
        try
        {
            user = database.logIn(id, password);
            if(user == null) {
                alien = database.logInAlien(id, password);
            }
            
        }
        catch(InfException e)
        {
            
                System.err.println("Could not login, wrong username or password");
            
        }
    }
    
    public void printLoggedInUser()
    {
        if(user != null)
        {
            System.out.println(user.toString());
        }
        if(alien != null)
        {
            System.out.println(alien.toString());
        }
        System.out.println("is not logged in!");
    }
    
    public void logOut()
    {
        user = null;
        alien = null;
        System.out.println("You have logged out!");
    }
    
    public boolean isLoggedIn()
    {
        return user != null || alien != null;
    }
    
    public boolean changePassword(String password)
    {
        if(!isLoggedIn())
        {
            System.err.println("Log in first!");
            return false;
        }
        
        try
        {
            if(isLoggedInAsAgent())
            {
                user = database.changePassword(user, password);
                return true;
            }
            else if(isLoggedInAsAlien())
            {
                alien = database.changePasswordAlien(alien, password);
                return true;
            }
            else
            {
                return false;
            }
        }
        catch (InfException ex)
        {
            System.err.println("Could not change password, reason: " + ex.getMessage());
            return false;
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
    
    public List<String> listAliensByPlats(String plats)
    {
        try
        {
            return database.listAllAliensByPlats(plats);
        }
        catch (InfException ex)
        {
             return new ArrayList<>();    
        }
    }
    
    public List<String> listRegistratedAliens(String start, String slut)
    {
        try
        {
            return database.listRegistratedAliens(start, slut);
        }
        catch(InfException ex)
        {
            return new ArrayList();
        }
    }
    
    public List<String> listAliensByRace(String race)
    {
        try 
        {
            return database.listAliensByRace(race);
        }
        catch (InfException ex)
        {
            return new ArrayList<>();
        }
    }
}
