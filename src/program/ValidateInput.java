/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package program;

import java.time.LocalDate;

/**
 * Valideringsklass för användarinput.
 * @author Sara
 */

public class ValidateInput 
{
    /**
     * Validerar att en Sträng är ett datum - alltså i formatet YYYY-MM-DD.
     * @param input
     * @return true om datum är i rätt format. 
     */
    public static boolean isValidDate(String input)
    {
        try
        {
          LocalDate.parse(input);
          return true;
        }
        catch(Exception ex)
        {
            return false;
        }
    }
    
    public static boolean isValidPassword(String input)
    {
        if(input == null || input.trim().isEmpty() || input.length()>7)
        {
            return false;
        }
        return true;
    }
    
    public static boolean isValidQuery(String input)
    {
        if(input == null || input.trim().isEmpty())
        {
            return false;
        }

        return !(input.contains("DELETE") ||
                input.contains("SELECT") ||
                input.contains("ADD") ||
                input.contains("DROP") ||
                input.contains("TABLE") ||
                input.contains("WHERE"));
    }
}
