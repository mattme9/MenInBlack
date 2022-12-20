package app;

import db.Database;
import program.Program;

/**
 *
 * @author Sara
 */
public class Main
{
    //main är det första som startas, därför skapar vi program med
    //alla metoder, som tar en ny Database som kopplar mot mySql
    public static void main(String args[]) throws Exception
    {
        //Här skapar vi upp all kod/funktioner vi kommer tänkas använda
        Program program = new Program(new Database());

        program.printAllAgents();
    }
}
