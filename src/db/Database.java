/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package db;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import oru.inf.InfDB;
import oru.inf.InfException;
import program.User;
import program.UserAlien;

/**
 * Vi har skapat en egen databasklass i detta projekt. 
 * Denna klass har som syfte är att komminucera via MySQL med databasen.
 * Vi har valt att göra på detta sätt för att undvika att skriva SQL-frågor i programmet.
 * Vi skapar alltså metoder med SQL som sedan kan anropas från vår programklass.
 * 
 * Vi hämtar alltså endast ut data från denna klass. Eftersom data bara hämtas ut så har 
 * vi valt att göra våra fält som "final". Detta innebär att när vi satt värden i fälten så
 * kommer de inte gå att förändra. De blir som låsta. Detta kan ses som en säkerbetsåtgärd.
 * 
 * @author Sara
 */
public class Database
{
    private static final String NAME = "mibdb";
    private static final String PORT = "3306";
    private static final String USER = "mibdba";
    private static final String PASSWORD = "mibkey";
    
    private final InfDB db;
    
    public Database() throws InfException
    {
        db = new InfDB(NAME, PORT, USER, PASSWORD);
    }
    
    //Metod som hämtar agenters namn utifrån ID. Metoden tar en int som parameter och returnerar en rad
    //Från databasen där ID matchar den parameter som skickats in.
    public String getAgentNameById(int id) throws InfException
    {
        return db.fetchSingle("SELECT Namn FROM agent WHERE Agent_ID=" + id);
    }
    
    //Metod som tar in en int (som användarnamn) samt en String (som lösenord) som parametrar.
    //
    
    public User logIn(int id, String password) throws InfException
    {
        String query = "SELECT * FROM agent WHERE Agent_ID=" + id + " AND Losenord='" + password + "'";
        HashMap<String, String> user = db.fetchRow(query);
        if(user.isEmpty()) {
            return null;
        }
        return new User(user);
        
    }
    
    public UserAlien logInAlien(int id, String password) throws InfException
    {
        String query = "SELECT * FROM alien WHERE Alien_ID=" + id + " AND Losenord='" + password + "'";
        HashMap<String, String> user = db.fetchRow(query);
        if(user.isEmpty()) {
            return null;
        }
        return new UserAlien(user);
    }
    
    //Metod som låter en alien-användare byta lösenord. Denna metod tar in en UserAlien 
    //Samt en String (lösenord) som parametrar. 
    public UserAlien changePasswordAlien (UserAlien userAlien, String newPasswordA) throws InfException
    {
        db.update("UPDATE alien SET Losenord='" + newPasswordA + "' WHERE Alien_ID=" + userAlien.getId());
        return logInAlien(userAlien.getId(), newPasswordA);
    }
    
    //Samma som ovanstående metod men för Agent samt Admin, tar istället in en User som parameter.
    public User changePassword(User user, String newPassword) throws InfException
    {
        db.update("UPDATE agent SET Losenord='" + newPassword + "' WHERE Agent_ID=" + user.getId());
        return logIn(user.getId(), newPassword);
    }
    
    //En metod för att lista alla agenter samt information om den, vi kör denna direkt programmet 
    //Startar för att ha snabb tillgång till användarnamn samt lösenord. Denna metod returnerar en 
    //ArrayList.
    public ArrayList<HashMap<String, String>> listAllAgents() throws InfException
    {
        return db.fetchRows("SELECT * FROM agent");
    }
    
    //Metod som returnerar en lista utav Strings. 
    public List<String> listAllPlatserBenamning () throws InfException
    {
        return db.fetchColumn("SELECT Benamning FROM Plats");
    }
    
    public List<String> listAllAgentsName() throws InfException
    {
        return db.fetchColumn("SELECT Namn FROM agent");
    }
    
    public List<String> listAllAliensByPlats(String plats) throws InfException
    {
        String query ="SELECT Namn FROM alien as a\n" +
                    "JOIN plats p on p.Plats_ID = a.Alien_ID WHERE p.Benamning = '" + plats + "';";
        return db.fetchColumn(query);
    }
    
    public List<String> listRegistratedAliens(String start, String slut) throws InfException
    {
        String query = "SELECT Namn FROM alien WHERE "
                + "Registreringsdatum > '"+start+"' AND "
                + "Registreringsdatum < '"+slut+"'";
        return db.fetchColumn(query);
    }
    
    public List<String> listAliensByRace(String race) throws InfException
    {
        String query = "SELECT Namn FROM alien AS ID\n" +
                       "JOIN "+ race +" x on x.Alien_ID = ID.Alien_ID";
        return db.fetchColumn(query);
    }
    
    public List<String> listAlienQuery(String query) throws InfException
    {
        return db.fetchColumn(query);
    }
}
