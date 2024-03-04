
import javase.ss.handler.SchuelerHandler;
import java.util.ArrayList;
import javase.ss.classes.Schueler;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author CC-Student
 */
public class TestProjekt {
    
        public static void main(String[] args) {
        

        ArrayList <Schueler> schuelerList = SchuelerHandler.getAllSchueler();
        
        for (Schueler schueler : schuelerList){
            System.out.println("Id = "+schueler.getSchuelerId());
            System.out.println("VorName = "+schueler.getVorname());
            System.out.println("NachName = "+schueler.getNachname());
            System.out.println("Geschlecht = "+schueler.getGeschlecht());
            System.out.println("Geburtstag = "+schueler.getGeburtstag());
           
        }
       
        
    }
    
}
