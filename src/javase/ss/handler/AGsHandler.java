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
import javase.ss.classes.AGs;
import javase.ss.db.DbConnection;

/**
 *
 * @author CC-Student
 */
public class AGsHandler {

    public static ArrayList<AGs> getAllAgs() {
        ArrayList<AGs> agsList = new ArrayList();
        try {
            Connection conn = DbConnection.openConnection();
            String sql = "SELECT AGS.AG_ID, AGS.AG_NAME, AGS.AG_TAG, "
                    + "    AGS.UHRZEIT, AGS.RAUM, "
                    + "    LEHRER.LEHRER_ID, LEHRER.VORNAME AS LEHRER_VORNAME,"
                    + "    LEHRER.NACHNAME AS LEHRER_NACHNAME, "
                    + "    SCHUELER.SCHUELER_ID, SCHUELER.VORNAME "
                    + "    AS SCHUELER_VORNAME, "
                    + "    SCHUELER.NACHNAME AS SCHUELER_NACHNAME"
                    + "    FROM AGS"
                    + "    INNER JOIN SCHUELER_AGS ON "
                    + "    AGS.AG_ID = SCHUELER_AGS.AG_ID"
                    + "    INNER JOIN SCHUELER ON "
                    + "    SCHUELER_AGS.SCHUELER_ID = SCHUELER.SCHUELER_ID"
                    + "    INNER JOIN LEHRER ON "
                    + "    SCHUELER_AGS.LEHRER_ID = LEHRER.LEHRER_ID";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                int agId = rs.getInt("AG_ID");
                String agName = rs.getString("AG_NAME");
                String agTag = rs.getString("AG_TAG");
                String uhrzeit = rs.getString("UHRZEIT");
                String raum = rs.getString("RAUM");
                int lehrerId = rs.getInt("LEHRER_ID");
                String lehrerVorName = rs.getString("LEHRER_VORNAME");
                String lehrerNachName = rs.getString("LEHRER_NACHNAME");
                int schuelerId = rs.getInt("SCHUELER_ID");
                String schuelerVorname = rs.getString("SCHUELER_VORNAME");
                String schuelerNachname = rs.getString("SCHUELER_NACHNAME");

                AGs ag = new AGs(agId, agName, agTag, uhrzeit, raum, lehrerId,
    lehrerVorName,lehrerNachName,schuelerId,schuelerVorname, schuelerNachname);
                agsList.add(ag);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AGsHandler.class.getName()).log(Level.SEVERE, 
                    null, ex);
        }
        return agsList;
    }
    
    
    //-------------------------------------------------------------- select all

    public static void main(String[] args) {
        ArrayList<AGs> agList = AGsHandler.getAllAgs();
        for (AGs ag : agList) {
            System.out.println("AG Id = " + ag.getAgId());
            System.out.println("AG Name = " + ag.getAgName());
            System.out.println("AG Tag = " + ag.getAgTag());
            System.out.println("AG Uhrzeit = " + ag.getUhrzeit());
            System.out.println("AG Raum = " + ag.getRaum());
            System.out.println("Lehrer ID = " + ag.getLehrerId());
            System.out.println("Lehrer Vorname : " + ag.getLehrerVorname());
            System.out.println("Lehrer Nachname : " + ag.getLehrerNachname());
            System.out.println("Schueler ID = " + ag.getSchuelerId());
            System.out.println("Schueler Vorname : " + ag.getSchuelerVorname());
            System.out.println("Schueler Nachname : " + ag.getSchuelerNachname());
            System.out.println("----------------------------------\n");
        }

    }

    public static ArrayList<AGs> getAllAgsWithLehrer() {

        ArrayList<AGs> agList = new ArrayList();
        try {

            Connection conn = DbConnection.openConnection();

            String selectSql = "SELECT AGS.AG_ID, AGS.AG_NAME, AGS.AG_TAG, AGS.UHRZEIT, AGS.RAUM, "
                    + "       LEHRER.VORNAME, LEHRER.NACHNAME"
                    + "         FROM AGS"
                    + "         INNER JOIN SCHUELER_AGS ON AGS.AG_ID = SCHUELER_AGS.AG_ID"
                    + "         INNER JOIN LEHRER ON SCHUELER_AGS.LEHRER_ID = LEHRER.LEHRER_ID";

            PreparedStatement pstmt = conn.prepareStatement(selectSql);

            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                int agID = rs.getInt("AG_ID");
                String agName = rs.getString("AG_NAME");
                String agTag = rs.getString("AG_TAG");
                String uhrzeit = rs.getString("UHRZEIT");
                String raum = rs.getString("RAUM");
                String lehrerVorName = rs.getString("VORNAME");
                String lehrerNachName = rs.getString("NACHNAME");

                //    AGs ag = new AGs(agID, agName, agTag, uhrzeit, raum, lehrerVorName, lehrerNachName);
                //    agList.add(ag);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return agList;
    }
    /*
    public static void main(String[] args) {
        ArrayList<AGs> agList = AGsHandler.getAllAgsWithLehrer();
        for (AGs ag : agList) {
            System.out.println("AG Id = " + ag.getAgId());
            System.out.println("AG Name = " + ag.getAgName());
            System.out.println("AG Tag = " + ag.getAgTag());
            System.out.println("AG Uhrzeit = " + ag.getUhrzeit());
            System.out.println("AG Raum = " + ag.getRaum());
            System.out.println("Lehrer Vorname = " + ag.getVorname());
            System.out.println("Lehrer Nachname = " + ag.getNachname());
            System.out.println("-----------------------------\n");
        }

    }
     */
}
