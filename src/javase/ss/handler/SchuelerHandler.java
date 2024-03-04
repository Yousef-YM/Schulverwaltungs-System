/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javase.ss.handler;

import javase.ss.db.DbConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javase.ss.classes.Schueler;

/**
 *
 * @author CC-Student
 */
public class SchuelerHandler {

    //----------------------------------------------------------------- insert
    
    public static void insertSchueler(Schueler schueler) {
        try {
            Connection conn = DbConnection.openConnection();

            String sql = "INSERT INTO SCHUELER"
                    + "    (VORNAME, NACHNAME, GEBURTSTAG, GESCHLECHT, "
                    + "    VATERNAME, "
                    + "    MUTTERNAME, ADRESSE, PHONE, MAIL) "
                    + "    VALUES "
                    + "    ( ?, ?, ?, ?, ?, ?, ?, ?, ?)";

            PreparedStatement pstmt = conn.prepareStatement(sql);

            pstmt.setString(1, schueler.getVorname());
            pstmt.setString(2, schueler.getNachname());
            pstmt.setString(3, schueler.getVaterName());
            pstmt.setString(4, schueler.getMutterName());
            pstmt.setString(5, schueler.getGeburtstag());
            pstmt.setString(6, schueler.getGeschlecht());
            pstmt.setString(7, schueler.getAdresse());
            pstmt.setString(8, schueler.getPhone());
            pstmt.setString(9, schueler.getMail());

            pstmt.executeUpdate();

            conn.commit();

        } catch (SQLException ex) {
            Logger.getLogger(SchuelerHandler.class.getName()).log(Level.SEVERE,
                    null, ex);
        }
    }

    /* Test insert
    public static void main(String[] args) {

        Schueler schueler = new Schueler("NNNN", "MMM", "AA", "VV",
                "05.05.2005", null, null, "65463", null, null);
        insertSchueler(schueler);
    }
     */
    //----------------------------------------------------------------- Update
    
    public static void updateSchueler(Schueler schueler) {
        try {
            Connection conn = DbConnection.openConnection();

            String sql = " UPDATE SCHUELER"
                    + "    SET VORNAME = ?, "
                    + "        NACHNAME = ?, "
                    + "        GEBURTSTAG = ?, "
                    + "        GESCHLECHT = ?, "
                    + "        VATERNAME = ?, "
                    + "        MUTTERNAME = ?, "
                    + "        ADRESSE = ?, "
                    + "        PHONE = ?, "
                    + "        MAIL = ?, "
                    + "        LEHRER_ID = ?"
                    + "    WHERE SCHUELER_ID = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);

            pstmt.setString(1, schueler.getVorname());
            pstmt.setString(2, schueler.getNachname());
            pstmt.setString(3, schueler.getGeburtstag());
            pstmt.setString(4, schueler.getGeschlecht());
            pstmt.setString(5, schueler.getVaterName());
            pstmt.setString(6, schueler.getMutterName());
            pstmt.setString(7, schueler.getAdresse());
            pstmt.setString(8, schueler.getPhone());
            pstmt.setString(9, schueler.getMail());
            if (schueler.getLehrerId() != null) {
                pstmt.setInt(10, schueler.getLehrerId());
            } else {
                pstmt.setNull(10, Types.INTEGER);
            }
            pstmt.setInt(11, schueler.getSchuelerId());
            pstmt.executeUpdate();
            conn.commit();

        } catch (SQLException ex) {
            Logger.getLogger(LehrerHandler.class.getName()).log(Level.SEVERE,
                    null, ex);
        }
    }

    /*
    public static void main(String[] args) {
        Schueler schueler = new Schueler(51, "Marcel", "M Nachname", "M", "W", 
                null, null, null, null, null, 22);

        updateSchueler(schueler);
    }
     */
//----------------------------------------------------------------- Delete
    
    
    public static void deleteSchueler(int schueler) {

        try {

            Connection conn = DbConnection.openConnection();

            String sql = "DELETE SCHUELER"
                    + "   WHERE SCHUELER_ID = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, schueler);

            pstmt.executeUpdate();

            conn.commit();

        } catch (SQLException ex) {
            Logger.getLogger(LehrerHandler.class.getName()).log(Level.SEVERE,
                    null, ex);
        }

    }

    
    
    /*
    //Test delete
    public static void main(String[] args) {
        deleteSchueler(52);
    }
     */
//------------------------------------------------------------------ select all
// select schueler
    
    
    public static ArrayList<Schueler> getAllSchueler() {

        ArrayList<Schueler> schuelerList = new ArrayList();
        try {
            Connection conn = DbConnection.openConnection();
            String sql = "SELECT SCHUELER_ID, VORNAME, NACHNAME, GEBURTSTAG, "
                    + "    GESCHLECHT, VATERNAME, "
                    + "    MUTTERNAME, ADRESSE, PHONE, MAIL, LEHRER_ID "
                    + "    FROM SCHUELER";

            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                int schuelerId = rs.getInt("SCHUELER_ID");
                String vorname = rs.getString("VORNAME");
                String nachname = rs.getString("NACHNAME");
                String geburtstag = rs.getString("GEBURTSTAG");
                String geschlecht = rs.getString("GESCHLECHT");
                String vaterName = rs.getString("VATERNAME");
                String mutterName = rs.getString("MUTTERNAME");
                String adresse = rs.getString("ADRESSE");
                String phone = rs.getString("PHONE");
                String mail = rs.getString("MAIL");
                int lehrerId = rs.getInt("LEHRER_ID");

                Schueler schueler = new Schueler(schuelerId, vorname, nachname,
                        vaterName, mutterName, geburtstag, geschlecht, adresse,
                        phone, mail, lehrerId);

                schuelerList.add(schueler);
            }
        } catch (SQLException ex) {
            Logger.getLogger(SchuelerHandler.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        return schuelerList;
    }

    
    /*Test select all 
    public static void main(String[] args) {
        ArrayList<Schueler> schuelerList = SchuelerHandler.getAllSchueler();
        for (Schueler schueler : schuelerList) {
            System.out.println("Id = " + schueler.getSchuelerId());
            System.out.println("VorName = " + schueler.getVorname());
            System.out.println("NachName = " + schueler.getNachname());
            System.out.println("Geschlecht = " + schueler.getGeschlecht());
            System.out.println("Geburtstag = " + schueler.getGeburtstag());
            System.out.println("Vater Name = " + schueler.getVaterName());
            System.out.println("Mutter Name = " + schueler.getMutterName());
            System.out.println("Adresse = " + schueler.getAdresse());
            System.out.println("Phone = " + schueler.getPhone());
            System.out.println("Mail = " + schueler.getMail());
            System.out.println("Lehrer ID = " + schueler.getLehrerId());
            System.out.println("---------------------------------\n");
        }
    }
     */
    public static Schueler getSchuelerById(int schuelerId) {

        Schueler schueler = null;

        try {
            Connection conn = DbConnection.openConnection();
            String sql = "SELECT SCHUELER_ID, VORNAME, NACHNAME, GEBURTSTAG, "
                    + "    GESCHLECHT, VATERNAME, "
                    + "    MUTTERNAME, ADRESSE, PHONE, MAIL, LEHRER_ID "
                    + "    FROM SCHUELER"
                    + "    WHERE SCHUELER_ID = ?";

            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, schuelerId);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                String vorname = rs.getString("VORNAME");
                String nachname = rs.getString("NACHNAME");
                String geburtstag = rs.getString("GEBURTSTAG");
                String geschlecht = rs.getString("GESCHLECHT");
                String vaterName = rs.getString("VATERNAME");
                String mutterName = rs.getString("MUTTERNAME");
                String adresse = rs.getString("ADRESSE");
                String phone = rs.getString("PHONE");
                String mail = rs.getString("MAIL");
                int lehrerId = rs.getInt("LEHRER_ID");

                schueler = new Schueler(vorname, nachname, geburtstag,
                        geschlecht, vaterName, mutterName, adresse, phone,
                        mail, lehrerId);
            }

        } catch (SQLException ex) {
            Logger.getLogger(SchuelerHandler.class.getName()).log(Level.SEVERE,
                    null, ex);
        }

        return schueler;
        
    }


    /*
    public static void main(String[] args) {

        Schueler schueler = getSchuelerById(4);

        System.out.println("ID = " + schueler.getSchuelerId());
        System.out.println("Vorname = " + schueler.getVorname());
        System.out.println("Nachname = " + schueler.getNachname());
        System.out.println("Geburtstag = " + schueler.getGeburtstag());
        System.out.println("Geschlecht = " + schueler.getGeschlecht());
        System.out.println("Vater = " + schueler.getVaterName());
        System.out.println("Mutter = " + schueler.getMutterName());
        System.out.println("Adresse = " + schueler.getAdresse());
        System.out.println("Phone = " + schueler.getPhone());
        System.out.println("Mail = " + schueler.getMail());
        System.out.println("Lehrer ID = " + schueler.getLehrerId());
         

    }
     */
}
