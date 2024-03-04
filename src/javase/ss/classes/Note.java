/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javase.ss.classes;

import java.sql.Date;

/**
 *
 * @author CC-Student
 */
public class Note {
    
    private int noteId;
    private double noteNote;
    private String testDatum;
    private String fachNote;
    private String schuelerVorname;
    private String schuelerNachname;
    private String lehrerVorname;
    private String lehrerNachname;

    public Note(double noteNote, String testDatum, String fachNote, String schuelerVorname, String schuelerNachname, String lehrerVorname, String lehrerNachname) {
        this.noteNote = noteNote;
        this.testDatum = testDatum;
        this.fachNote = fachNote;
        this.schuelerVorname = schuelerVorname;
        this.schuelerNachname = schuelerNachname;
        this.lehrerVorname = lehrerVorname;
        this.lehrerNachname = lehrerNachname;
    }

    public int getNoteId() {
        return noteId;
    }

    public void setNoteId(int noteId) {
        this.noteId = noteId;
    }

    public double getNoteNote() {
        return noteNote;
    }

    public void setNoteNote(double noteNote) {
        this.noteNote = noteNote;
    }

    public String getTestDatum() {
        return testDatum;
    }

    public void setTestDatum(String testDatum) {
        this.testDatum = testDatum;
    }

    public String getFachNote() {
        return fachNote;
    }

    public void setFachNote(String fachNote) {
        this.fachNote = fachNote;
    }

    public String getSchuelerVorname() {
        return schuelerVorname;
    }

    public void setSchuelerVorname(String schuelerVorname) {
        this.schuelerVorname = schuelerVorname;
    }

    public String getSchuelerNachname() {
        return schuelerNachname;
    }

    public void setSchuelerNachname(String schuelerNachname) {
        this.schuelerNachname = schuelerNachname;
    }

    public String getLehrerVorname() {
        return lehrerVorname;
    }

    public void setLehrerVorname(String lehrerVorname) {
        this.lehrerVorname = lehrerVorname;
    }

    public String getLehrerNachname() {
        return lehrerNachname;
    }

    public void setLehrerNachname(String lehrerNachname) {
        this.lehrerNachname = lehrerNachname;
    }
    
  
    
    
}
