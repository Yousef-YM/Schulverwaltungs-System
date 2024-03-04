/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javase.ss.handler;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javase.ss.classes.Lehrer;
import javase.ss.db.DbConnection;

/**
 *
 * @author CC-Student
 */
public class LehrerHandler {

    //----------------------------------------------------------------- insert
    public static void insertLehrer(Lehrer lehrer) {

        try {

            Connection conn = DbConnection.openConnection();

            String sql = "insert into Lehrer"
                    + "    (VORNAME, NACHNAME, ADRESSE, PHONE, MAIL, ROLLE)"
                    + "    values"
                    + "    (?, ?, ?, ?, ?, ?)";

            PreparedStatement pstmt = conn.prepareStatement(sql);

            pstmt.setString(1, lehrer.getVorname());
            pstmt.setString(2, lehrer.getNachname());
            pstmt.setString(3, lehrer.getAdresse());
            pstmt.setString(4, lehrer.getPhone());
            pstmt.setString(5, lehrer.getMail());
            pstmt.setString(6, lehrer.getRolle());

            pstmt.executeUpdate();

            conn.commit();

        } catch (SQLException ex) {
            Logger.getLogger(LehrerHandler.class.getName()).log(Level.SEVERE,
                    null, ex);
        }

    }

    /* Test insert
    public static void main(String[] args) {
        Lehrer lehrer = new Lehrer("Mhd", "Mhd Nachname",
                "Musterstraße 55, 12345 Frankfurt",
                "+49 111 12345678", "mhd.mueller@example.com", "Deutsch % Sachunterricht");

        insertLehrer(lehrer);

    }
     */
    //----------------------------------------------------------------- Update
    
    public static void updateLehrer(Lehrer lehrer) {
        try {
            //1
            Connection conn = DbConnection.openConnection();
            //2
            String sql = "UPDATE LEHRER"
                    + "   SET VORNAME = ?,"
                    + "     NACHNAME = ?,"
                    + "     ADRESSE = ?,"
                    + "     PHONE = ?,"
                    + "     MAIL = ?,"
                    + "     ROLLE = ?"
                    + "   WHERE LEHRER_ID = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);

            pstmt.setString(1, lehrer.getVorname());
            pstmt.setString(2, lehrer.getNachname());
            pstmt.setString(3, lehrer.getAdresse());
            pstmt.setString(4, lehrer.getPhone());
            pstmt.setString(5, lehrer.getMail());
            pstmt.setString(6, lehrer.getRolle());
            pstmt.setInt(7, lehrer.getLehrerId());

            //3
            pstmt.executeUpdate();

            //4
            conn.commit();

        } catch (SQLException ex) {
            Logger.getLogger(LehrerHandler.class.getName()).log(Level.SEVERE,
                    null, ex);
        }

    }

    /*
    //Test insert
    public static void main(String[] args) {
        Lehrer lehrer = new Lehrer(24, "MM", "Max Nachname",
                "Musterstraße 36, 12345 Frankfurt",
                "+49 111 12345678", "max.mueller@example.com", "Sport");

        updateLehrer(lehrer);
    }
     */
    //----------------------------------------------------------------- Delete
    
    
    public static void deleteLehrer(int lehrerId) {
        try {
            Connection conn = DbConnection.openConnection();

            String sql = "DELETE LEHRER"
                    + "   WHERE LEHRER_ID = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, lehrerId);

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
        deleteLehrer(41);
    }
     */
    //-------------------------------------------------------------- select all
    
    
    public static ArrayList<Lehrer> getAllLehrer() {

        ArrayList<Lehrer> lehrerList = new ArrayList();

        try {
            Connection conn = DbConnection.openConnection();
            String sql = "SELECT "
                    + "  LEHRER_ID, VORNAME, NACHNAME, ADRESSE, PHONE, "
                    + "  MAIL, ROLLE"
                    + "  FROM LEHRER";

            PreparedStatement pstmt = conn.prepareStatement(sql);

            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                int lehrerId = rs.getInt("LEHRER_ID");
                String vorname = rs.getString("VORNAME");
                String nachname = rs.getString("NACHNAME");
                String adresse = rs.getString("ADRESSE");
                String phone = rs.getString("PHONE");
                String mail = rs.getString("MAIL");
                String rolle = rs.getString("ROLLE");

                Lehrer lehrer = new Lehrer(lehrerId, vorname, nachname,
                        adresse, phone, mail, rolle);

                lehrerList.add(lehrer);
            }

        } catch (SQLException ex) {
            Logger.getLogger(LehrerHandler.class.getName()).log(Level.SEVERE, 
                    null, ex);
        }

        return lehrerList;
    }

    
    /*
    //Test getAllLehrer  
    public static void main(String[] args) {
        ArrayList<Lehrer> lehrerList = getAllLehrer();
        for(Lehrer lehrer : lehrerList){
            System.out.println("Id : "+lehrer.getLehrerId());
            System.out.println("Vorname : "+lehrer.getVorname());
            System.out.println("Nachname : "+lehrer.getNachname());
            System.out.println("Adresse : "+lehrer.getAdresse());
            System.out.println("Phone : "+lehrer.getPhone());
            System.out.println("E-Mail : "+lehrer.getMail());
            System.out.println("Rolle : "+lehrer.getRolle());
            System.out.println("------------------------------");
        }
     
    }
     */
    //----------------------------------------------------
    //----------------------------------------------------
    
    
    public static Lehrer getLehrerById(int lehrerId) {
        Lehrer lehrer = null;

        try {
            Connection conn = DbConnection.openConnection();
            String sql = "SELECT "
                    + "    LEHRER_ID, VORNAME, NACHNAME, ADRESSE, PHONE, "
                    + "    MAIL, ROLLE"
                    + "    FROM LEHRER"
                    + "    WHERE LEHRER_ID = ?";

            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, lehrerId);

            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                String vorname = rs.getString("VORNAME");
                String nachname = rs.getString("NACHNAME");
                String adresse = rs.getString("ADRESSE");
                String phone = rs.getString("PHONE");
                String mail = rs.getString("MAIL");
                String rolle = rs.getString("ROLLE");

                lehrer = new Lehrer(vorname, nachname,
                        adresse, phone, mail, rolle);

            }

        } catch (SQLException ex) {
            Logger.getLogger(LehrerHandler.class.getName()).log(Level.SEVERE, 
                    null, ex);
        }

        return lehrer;

    }

    
    
    /*
    //Test delete
    public static void main(String[] args) {
        Lehrer lehrer = getLehrerById(22);
            System.out.println("Vorname : "+lehrer.getVorname());
            System.out.println("Nachname : "+lehrer.getNachname());
            System.out.println("Adresse : "+lehrer.getAdresse());
            System.out.println("Phone : "+lehrer.getPhone());
            System.out.println("E-Mail : "+lehrer.getMail());
            System.out.println("Rolle : "+lehrer.getRolle());
            
    }
     */
    
    
    public static ArrayList<Lehrer> getAllVertretung() {

        ArrayList<Lehrer> lehrerList = new ArrayList();

        try {
            Connection conn = DbConnection.openConnection();
            String sql = "SELECT "
                    + "  LEHRER_ID, VORNAME, NACHNAME, ADRESSE, PHONE, "
                    + "  MAIL, ROLLE"
                    + "  FROM LEHRER"
                    + "  WHERE UPPER(LEHRER.ROLLE) = UPPER('Vertretung')";

            PreparedStatement pstmt = conn.prepareStatement(sql);

            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                int lehrerId = rs.getInt("LEHRER_ID");
                String vorname = rs.getString("VORNAME");
                String nachname = rs.getString("NACHNAME");
                String adresse = rs.getString("ADRESSE");
                String phone = rs.getString("PHONE");
                String mail = rs.getString("MAIL");
                String rolle = rs.getString("ROLLE");

                Lehrer lehrer = new Lehrer(lehrerId, vorname, nachname,
                        adresse, phone, mail, rolle);

                lehrerList.add(lehrer);
            }

        } catch (SQLException ex) {
            Logger.getLogger(LehrerHandler.class.getName()).log(Level.SEVERE, 
                    null, ex);
        }

        return lehrerList;
    }
    
    

    public static void main(String[] args) {
        ArrayList<Lehrer> lehrerList = getAllLehrer();
        for (Lehrer lehrer : lehrerList) {
            System.out.println("Id : " + lehrer.getLehrerId());
            System.out.println("Vorname : " + lehrer.getVorname());
            System.out.println("Nachname : " + lehrer.getNachname());
            System.out.println("Adresse : " + lehrer.getAdresse());
            System.out.println("Phone : " + lehrer.getPhone());
            System.out.println("E-Mail : " + lehrer.getMail());
            System.out.println("Rolle : " + lehrer.getRolle());
            System.out.println("------------------------------");

        }

    }
}
