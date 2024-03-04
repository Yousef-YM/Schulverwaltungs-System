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
import java.util.logging.Level;
import java.util.logging.Logger;
import javase.ss.classes.Anwesenheit;
import javase.ss.db.DbConnection;

/**
 *
 * @author CC-Student
 */
public class AnwesenheitsHandler {

    public static Anwesenheit getAnwesenheitsInfoById(int schueler) {
        Anwesenheit anwesen = null;

        try {
            Connection conn = DbConnection.openConnection();
            String sql = "SELECT ANWESENHEIT.ANWESENHEIT_ID, "
                    + "    SCHUELER.SCHUELER_ID, "
                    + "    SCHUELER.VORNAME, SCHUELER.NACHNAME, "
                    + "    ANWESENHEIT.FEHLTAG_DATUM, ANWESENHEIT.FEHLTAG_TAG,"
                    + "    ANWESENHEIT.GRUND, ANWESENHEIT.ENTSCHULDIGT "
                    + "    FROM ANWESENHEIT"
                    + "    INNER JOIN SCHUELER ON "
                    + "    ANWESENHEIT.SCHUELER_ID = SCHUELER.SCHUELER_ID"
                    + "    WHERE SCHUELER.SCHUELER_ID = ?";

            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, schueler);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                int anwesenhetsId = rs.getInt("ANWESENHEIT_ID");
                int schuelerId = rs.getInt("SCHUELER_ID");
                String schuelerVorname = rs.getString("VORNAME");
                String schuelerNachname = rs.getString("NACHNAME");
                String fehlTagDatum = rs.getString("FEHLTAG_DATUM");
                String fehlTag_Tag = rs.getString("FEHLTAG_TAG");
                String grund = rs.getString("GRUND");
                String entschuldigt = rs.getString("ENTSCHULDIGT");

                anwesen = new Anwesenheit(anwesenhetsId, schuelerId,  
                schuelerVorname, schuelerNachname, fehlTagDatum, fehlTag_Tag, 
                        grund, entschuldigt);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AnwesenheitsHandler.class.getName()).
                    log(Level.SEVERE, null, ex);
        }
        return anwesen;
    }

    
    public static void main(String[] args) {

        Anwesenheit anwesen = getAnwesenheitsInfoById(22);

        System.out.println("Anwesenheeits ID : " + anwesen.getAnwesenheitId());
        System.out.println("Schueler ID : " + anwesen.getSchuelerId());
        System.out.println("VorName des Schuelers : " + anwesen.getSchuelerVorname());
        System.out.println("Nachname des Schuelers : " + anwesen.getSchuelerNachname());
        System.out.println("FehlTag Datum : " + anwesen.getFehltagDatum());
        System.out.println("FehlTag Tag : " + anwesen.getFehltagTag());
        System.out.println("Grund : " + anwesen.getGrund());
        System.out.println("Entschuldigt : " + anwesen.getEntschuldigt());

    }

}
