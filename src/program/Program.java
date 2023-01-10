package program;

import db.Database;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import oru.inf.InfException;

/**
 * Detta är vår egentliga huvudklass - eller vår "javaböna". Denna klass innehåller
 * all "logik" och därav alla funktioner. Man kan säga att denna klass används för
 * att transporta data från databasen. Här har vi instansierat databasklassen så att
 * vi kan hämta data däirfrån.
 * 
 * Vi instansierar även våra klasser User samt UserAlien för att kunna använda oss
 * utav data från dem i våra metoder vi bygger här. User och UserAlien används som 
 * inloggade användare.
 * 
 * Här har vi skapat upp alla metoder som behövs för att göra ändringar/läsa data från db.
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
    
    // Metod för att kolla om en User är administratör eller inte.
    public boolean isAdmin()
    {
        return user != null && user.isIsAdmin();
    }
    
    // Metod för att hämta ut användarnamn på User (agent/admin) 
    // Och UserAlien (alien). Metoden kollar först om någon är inloggad alls.
    // Om man är inloggad som user/userAlien returnerar metoden
    // användarnamnet för denne.
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
    
    // Get-metod som hämtar data om Aliens kontaktperson. Metoden anropar 
    // Databasen för att hämta kontaktID för en alien och namnet på denne.
    // Om detta inte finns har vi en "catch" som kommer att skriva ut aktuellt
    // Felmeddelande i terminalen samt retuernera en tomsträng.
    public String getAlienContact(){
        try {
            return database.getAgentNameById(alien.getContact());
        } catch (InfException ex) {
            System.err.println("Error: " + ex.getMessage());
            return "";
        }
    }
    
    // Två metoder för att kolla om man är inloggad som agent eller alein.
    public boolean isLoggedInAsAgent()
    {
        return user != null;
    }
    
    public boolean isLoggedInAsAlien()
    {
        return alien != null;
    }
    
    // Två metoder som hmtar och listar namn på alla agenter och platser.
    // Kör metoden från databasen som listar namn på alla agenter. 
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
    
    // Metod för 
    public void logIn(String name, String password)
    {
        if(user != null || alien != null)
        {
            System.out.println("Already logged in, log out first.");
            return;
        }
        
        try
        {
            user = database.logIn(name, password);
            if(user == null) {
                alien = database.logInAlien(name, password);
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
    
    public boolean doesAgentExist(String agentName)
    {
        return database.doesAgentExist(agentName);
    }
    
     public boolean doesAlienExist(String alienName)
    {
        return database.doesAgentExist(alienName);
    }
}
