package program;

import java.util.HashMap;

/**
 *
 * @author Sara Johansson, Mattias Messerer
 */
public class UserAlien
{
    private final int id;
    private final String name;
    private final String date;
    private final String password;
    private final int area;
    private final String phone;
    private final int contact;
    
    
    public UserAlien(HashMap<String, String> userdata)
    {
        System.out.println(userdata.toString());
        id = Integer.parseInt(userdata.get("Alien_ID"));
        name = userdata.get("Namn");
        date = userdata.get("Registreringsdatum");
        password = userdata.get("Losenord");
        area = Integer.parseInt(userdata.get("Plats"));
        phone = userdata.get("Telefon");
        contact = Integer.parseInt(userdata.get("Ansvarig_Agent"));
    }
    
    public int getContact(){
        return contact;
    }
    
    public String getName()
    {
        return name;
    }
    
    public int getId()
    {
        return id;    
    }
}
