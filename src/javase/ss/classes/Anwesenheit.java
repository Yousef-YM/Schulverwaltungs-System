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
public class Anwesenheit {
    
    private int anwesenheitId;
    private int schuelerId;
    private String schuelerVorname;
    private String schuelerNachname;
    private String fehltagDatum;
    private String fehltagTag;
    private String grund;
    private String entschuldigt;

    public Anwesenheit(int anwesenheitId, int schuelerId, String schuelerVorname, String schuelerNachname, String fehltagDatum, String fehltagTag, String grund, String entschuldigt) {
        this.anwesenheitId = anwesenheitId;
        this.schuelerId = schuelerId;
        this.schuelerVorname = schuelerVorname;
        this.schuelerNachname = schuelerNachname;
        this.fehltagDatum = fehltagDatum;
        this.fehltagTag = fehltagTag;
        this.grund = grund;
        this.entschuldigt = entschuldigt;
    }

    public Anwesenheit() {
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
    
    
    public int getAnwesenheitId() {
        return anwesenheitId;
    }

    public void setAnwesenheitId(int anwesenheitId) {
        this.anwesenheitId = anwesenheitId;
    }

    public String getFehltagDatum() {
        return fehltagDatum;
    }

    public void setFehltagDatum(String fehltagDatum) {
        this.fehltagDatum = fehltagDatum;
    }

    public String getFehltagTag() {
        return fehltagTag;
    }

    public void setFehltagTag(String fehltagTag) {
        this.fehltagTag = fehltagTag;
    }

    public String getGrund() {
        return grund;
    }

    public void setGrund(String grund) {
        this.grund = grund;
    }

    public String getEntschuldigt() {
        return entschuldigt;
    }

    public void setEntschuldigt(String entschuldigt) {
        this.entschuldigt = entschuldigt;
    }

    public int getSchuelerId() {
        return schuelerId;
    }

    public void setSchuelerId(int schuelerId) {
        this.schuelerId = schuelerId;
    }
    
    
    
    
    
}
