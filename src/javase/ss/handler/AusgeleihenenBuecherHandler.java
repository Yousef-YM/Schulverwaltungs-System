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
import javase.ss.classes.AusgelieheneBuecher;
import javase.ss.db.DbConnection;

/**
 *
 * @author CC-Student
 */
public class AusgeleihenenBuecherHandler {

    public static AusgelieheneBuecher
            getAllAusgelienenBuecherById(int schuelerId) {
        AusgelieheneBuecher leiBuch = null;
        try {

            Connection conn = DbConnection.openConnection();
            String sql = "SELECT AUSGELIEHENEBUECHER.AUSLEI_ID, "
                    + "    AUSGELIEHENEBUECHER.BUCHTITEL,"
                    + "    SCHUELER.SCHUELER_ID, SCHUELER.VORNAME, "
                    + "    SCHUELER.NACHNAME,"
                    + "    AUSGELIEHENEBUECHER.AUSLEIHDATUM,  "
                    + "    AUSGELIEHENEBUECHER.RUECKGABEDATUM, "
                    + "    AUSGELIEHENEBUECHER.STATUS"
                    + "    FROM AUSGELIEHENEBUECHER "
                    + "    INNER JOIN SCHUELER  "
                    + "    ON AUSGELIEHENEBUECHER.SCHUELER_ID "
                    + "    = SCHUELER.SCHUELER_ID"
                    + "    WHERE AUSGELIEHENEBUECHER.SCHUELER_ID = ?";

            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, schuelerId);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                int ausleiId = rs.getInt("AUSLEI_ID");
                String buchTitel = rs.getString("BUCHTITEL");
                int schueler_Id = rs.getInt("SCHUELER_ID");
                String vorname = rs.getString("VORNAME");
                String nachname = rs.getString("NACHNAME");
                String ausDatum = rs.getString("AUSLEIHDATUM");
                String ruekDatum = rs.getString("RUECKGABEDATUM");
                String status = rs.getString("STATUS");

                leiBuch = new AusgelieheneBuecher(ausleiId, buchTitel, 
                schueler_Id, vorname, nachname, ausDatum, ruekDatum, status);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AusgeleihenenBuecherHandler.class.getName()).
                    log(Level.SEVERE, null, ex);
        }
        return leiBuch;
    }

            
            
    public static void main(String[] args) {

        AusgelieheneBuecher leiBuch = getAllAusgelienenBuecherById(22);

        System.out.println("Ausleihe ID : " + leiBuch.getAusleiId());
        System.out.println("Buch titel : " + leiBuch.getTitel());
        System.out.println("Schueler ID : " + leiBuch.getSchueler_Id());
        System.out.println("Schueler vorname : " + leiBuch.getSchuelerVorname());
        System.out.println("Schueler nachname : " + leiBuch.getSchuelerNachname());
        System.out.println("Ausleihe Datum : " + leiBuch.getAusleiDatum());
        System.out.println("Rueckgabe Datum : " + leiBuch.getRueckgabeDatum());
        System.out.println("Status : " + leiBuch.getStatus());

    }

}
