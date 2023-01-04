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
 * Denna klass syfte är att prata SQL med databasen.
 * Varför vi har en egen klass för detta är för att vi inte vill skriva
 * SQL i programmet, utan skapar metoder här med SQL som program anropar
 * 
 * Här hämtar vi bara data, program gör saker med datat.
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
    
    public String getAgentNameById(int id) throws InfException
    {
        return db.fetchSingle("SELECT Namn FROM agent WHERE Agent_ID=" + id);
    }
    
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
    
    public UserAlien changePasswordAlien (UserAlien userAlien, String newPasswordA) throws InfException
    {
        db.update("UPDATE alien SET Losenord='" + newPasswordA + "' WHERE Alien_ID=" + userAlien.getId());
        return logInAlien(userAlien.getId(), newPasswordA);
    }
    
    public User changePassword(User user, String newPassword) throws InfException
    {
        db.update("UPDATE agent SET Losenord='" + newPassword + "' WHERE Agent_ID=" + user.getId());
        return logIn(user.getId(), newPassword);
    }
    
    public ArrayList<HashMap<String, String>> listAllAgents() throws InfException
    {
        return db.fetchRows("SELECT * FROM agent");
    }
    
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
                + "Registreringsdatum < '"+start+"' AND "
                + "Registreringsdatum > '"+slut+"'";
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
