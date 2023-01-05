package program;

import java.util.HashMap;

/**
 * Klass för användaren (agent eller admin)
 * User används som inloggad användare. För att komma åt data gällande användaren
 * Har vi skapat denna klass. Här instansierar vi anvndarobjektet och med hjälp av
 * Getters kommer vi kunna plocka ut all information vi behöver för att kunna köra
 * Våra metoder i programklassen.
 * @author Sara
 */
public class User
{
    private final String name;
    private final String date;
    private final boolean isAdmin;
    private final String password;
    private final int area;
    private final String phone;
    private final int id;
    
    //Vi har inga setters utan för att få en User måste vi ta värdet från
    //databasen, (Hashmap) - Detta sätter vi i konstruktorn så när vi skapat
    //User kan vi bara läsa ut infon.
    public User(HashMap<String, String> userdata)
    {
        name = userdata.get("Namn");
        date = userdata.get("Anstallningsdatum");
        // Om Key "Administrator" är lika med "J" (dvs true) sätter vi isAdmin
        // till true.
        isAdmin = "J".equals(userdata.get("Administrator"));
        password = userdata.get("Losenord");
        area = Integer.parseInt(userdata.get("Omrade"));
        phone = userdata.get("Telefon");
        id = Integer.parseInt(userdata.get("Agent_ID"));
    }
    
    public String getName() {
        return name;
    }

    public String getDate() {
        return date;
    }

    public boolean isIsAdmin() {
        return isAdmin;
    }

    public String getPassword() {
        return password;
    }

    public int getArea() {
        return area;
    }

    public String getPhone() {
        return phone;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "User{" + "name=" + name + ", date=" + date + ", isAdmin=" + isAdmin + ", password=" + password + ", area=" + area + ", phone=" + phone + ", id=" + id + '}';
    }
    
    
}
