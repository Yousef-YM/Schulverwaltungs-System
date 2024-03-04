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
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javase.ss.classes.Note;
import javase.ss.db.DbConnection;

/**
 *
 * @author CC-Student
 */


public class NotenHandler {

    public static ArrayList<Note> gettAllNoten() {
        ArrayList<Note> noteList = new ArrayList();
        try {
            Connection conn = DbConnection.openConnection();

            String sql = "SELECT SCHUELER.VORNAME "
                    + "   AS SCHUELER_VORNAME, SCHUELER.NACHNAME "
                    + "   AS SCHUELER_NACHNAME, "
                    + "   LEHRER.VORNAME AS LEHRER_VORNAME, LEHRER.NACHNAME "
                    + "   AS LEHRER_NACHNAME, "
                    + "   NOTE.FACH_NOTE, NOTE.TESTDATUM, NOTE.NOTE_NOTE "
                    + "   FROM NOTE "
                    + "   JOIN SCHUELER ON "
                    + "   NOTE.SCHUELER_ID = SCHUELER.SCHUELER_ID "
                    + "   JOIN LEHRER ON "
                    + "   NOTE.LEHRER_ID = LEHRER.LEHRER_ID";

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                String schuelerVorname = rs.getString("SCHUELER_VORNAME");
                String schuelerNachname = rs.getString("SCHUELER_NACHNAME");
                String lehrerVorname = rs.getString("LEHRER_VORNAME");
                String lehrerNachname = rs.getString("LEHRER_NACHNAME");
                String fachNote = rs.getString("FACH_NOTE");
                String testdatum = rs.getString("TESTDATUM");
                double noteNote = rs.getDouble("NOTE_NOTE");

                Note note = new Note(noteNote, testdatum, fachNote, 
                        schuelerVorname,
                        schuelerNachname, lehrerVorname, lehrerNachname);
                noteList.add(note);
            }
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return noteList;
    }

    
    /*
public static void main(String[] args) {
    ArrayList<Note> notenList = NotenHandler.gettAllNoten();
    for (Note note : notenList) {
        System.out.println("Schueler Name : " + note.getSchuelerVorname() + " " + note.getSchuelerNachname());
        System.out.println("Lehrer Name = " + note.getLehrerVorname() + " " + note.getLehrerNachname());
        System.out.println("Fach  = " + note.getFachNote());
        System.out.println("Datum = " + note.getTestDatum());
        System.out.println("Note  = " + note.getNoteNote());
        System.out.println("---------------------------------\n");
    }
}*/
    
    
    public static Note getNotenInfoById(int schuelerId) throws SQLException {
        Note note = null;

        try {
            Connection conn = DbConnection.openConnection();
            String sql = "SELECT SCHUELER.SCHUELER_ID, SCHUELER.VORNAME "
                    + "   AS SCHUELER_VORNAME, "
                    + "   SCHUELER.NACHNAME AS SCHUELER_NACHNAME, "
                    + "   LEHRER.LEHRER_ID, LEHRER.VORNAME AS LEHRER_VORNAME, "
                    + "   LEHRER.NACHNAME AS LEHRER_NACHNAME, "
                    + "   NOTE.FACH_NOTE, NOTE.TESTDATUM, NOTE.NOTE_NOTE "
                    + "   FROM NOTE "
                    + "   JOIN SCHUELER ON "
                    + "   NOTE.SCHUELER_ID = SCHUELER.SCHUELER_ID "
                    + "   JOIN LEHRER ON NOTE.LEHRER_ID = LEHRER.LEHRER_ID"
                    + "   WHERE SCHUELER.SCHUELER_ID = ?";

            PreparedStatement pstmt = conn.prepareStatement(sql);

            pstmt.setInt(1, schuelerId);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                String schuelerVorname = rs.getString("SCHUELER_VORNAME");
                String schuelerNachname = rs.getString("SCHUELER_NACHNAME");
                String lehrerVorname = rs.getString("LEHRER_VORNAME");
                String lehrerNachname = rs.getString("LEHRER_NACHNAME");
                String fachNote = rs.getString("FACH_NOTE");
                String testdatum = rs.getString("TESTDATUM");
                double noteNote = rs.getDouble("NOTE_NOTE");

                note = new Note(noteNote, testdatum, fachNote, schuelerVorname,
                        schuelerNachname, lehrerVorname, lehrerNachname);

            }

        } catch (SQLException ex) {
            Logger.getLogger(NotenHandler.class.getName()).log(Level.SEVERE,
                    null, ex);
        }
        return note;
    }

    public static void main(String[] args) {

        try {
            Note note = getNotenInfoById(4);

            System.out.println("Schueler Name : " + note.getSchuelerVorname() + " " + note.getSchuelerNachname());
            System.out.println("Lehrer Name = " + note.getLehrerVorname() + " " + note.getLehrerNachname());
            System.out.println("Fach  = " + note.getFachNote());
            System.out.println("Datum = " + note.getTestDatum());
            System.out.println("Note  = " + note.getNoteNote());
            System.out.println("---------------------------------\n");

        } catch (SQLException ex) {
            Logger.getLogger(NotenHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
