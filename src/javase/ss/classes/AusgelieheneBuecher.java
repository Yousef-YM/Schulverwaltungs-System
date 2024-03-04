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
public class AusgelieheneBuecher {
    
    private int ausleiId;
    private String titel;
    private int schueler_Id;
    private String schuelerVorname;
    private String schuelerNachname;
    private String ausleiDatum;
    private String rueckgabeDatum;
    private String status;

    public AusgelieheneBuecher(int ausleiId, String titel, int schueler_Id, String schuelerVorname, String schuelerNachname, String ausleiDatum, String rueckgabeDatum, String status) {
        this.ausleiId = ausleiId;
        this.titel = titel;
        this.schueler_Id = schueler_Id;
        this.schuelerVorname = schuelerVorname;
        this.schuelerNachname = schuelerNachname;
        this.ausleiDatum = ausleiDatum;
        this.rueckgabeDatum = rueckgabeDatum;
        this.status = status;
    }
    
    
    

    public int getSchueler_Id() {
        return schueler_Id;
    }

    public void setSchueler_Id(int schueler_Id) {
        this.schueler_Id = schueler_Id;
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

    public String getAusleiDatum() {
        return ausleiDatum;
    }

    public void setAusleiDatum(String ausleiDatum) {
        this.ausleiDatum = ausleiDatum;
    }

    public String getRueckgabeDatum() {
        return rueckgabeDatum;
    }

    public void setRueckgabeDatum(String rueckgabeDatum) {
        this.rueckgabeDatum = rueckgabeDatum;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    
    
    

    public int getAusleiId() {
        return ausleiId;
    }

    public void setAusleiId(int ausleiId) {
        this.ausleiId = ausleiId;
    }

    public String getTitel() {
        return titel;
    }

    public void setTitel(String titel) {
        this.titel = titel;
    }


    
}
