/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javase.ss.classes;
import javase.ss.classes.Lehrer;
/**
 *
 * @author CC-Student
 */
public class AGs {
    
    private int agId;
    private String agName;
    private String agTag;
    private String uhrzeit;
    private String raum;
    private int lehrerId;
    private String lehrerVorname;
    private String lehrerNachname;
    private int schuelerId;
    private String schuelerVorname;
    private String schuelerNachname;


    public AGs(int agId, String agName, String agTag, String uhrzeit, String raum, 
            int lehrerId, String lehrerVorname, String lehrerNachname, 
            int schuelerId, String schuelerVorname, String schuelerNachname) {
        this.agId = agId;
        this.agName = agName;
        this.agTag = agTag;
        this.uhrzeit = uhrzeit;
        this.raum = raum;
        this.lehrerId = lehrerId;
        this.lehrerVorname = lehrerVorname;
        this.lehrerNachname = lehrerNachname;
        this.schuelerId = schuelerId;
        this.schuelerVorname = schuelerVorname;
        this.schuelerNachname = schuelerNachname;
    }
    
    
    
    
/*
    public AGs(int agId, String agName, String agTag, String uhrzeit, String raum, 
            Lehrer lehrerId, Lehrer vorname, Lehrer nachname, int schuelerId,   
            Schueler schuelerVorname, Schueler schuelerNachname) {
        super(vorname, nachname);
        this.agId = agId;
        this.agName = agName;
        this.agTag = agTag;
        this.uhrzeit = uhrzeit;
        this.raum = raum;
        this.schuelerId = schuelerId;
        this.lehrerId = lehrerId;
        this.schuelerVorname = schuelerVorname;
    }
*/


    public String getLehrerNachname() {
        return lehrerNachname;
    }

    public void setLehrerNachname(String lehrerNachname) {
        this.lehrerNachname = lehrerNachname;
    }

    public String getSchuelerNachname() {
        return schuelerNachname;
    }

    public void setSchuelerNachname(String schuelerNachname) {
        this.schuelerNachname = schuelerNachname;
    }
    
    
    


    public int getAgId() {
        return agId;
    }

    public void setAgId(int agId) {
        this.agId = agId;
    }

    public String getAgName() {
        return agName;
    }

    public void setAgName(String agName) {
        this.agName = agName;
    }

    public String getAgTag() {
        return agTag;
    }

    public void setAgTag(String agTag) {
        this.agTag = agTag;
    }

    public String getUhrzeit() {
        return uhrzeit;
    }

    public void setUhrzeit(String uhrzeit) {
        this.uhrzeit = uhrzeit;
    }

    public String getRaum() {
        return raum;
    }

    public void setRaum(String raum) {
        this.raum = raum;
    }

    public int getSchuelerId() {
        return schuelerId;
    }

    public void setSchuelerId(int schuelerId) {
        this.schuelerId = schuelerId;
    }

    public int getLehrerId() {
        return lehrerId;
    }

    public void setLehrerId(int lehrerId) {
        this.lehrerId = lehrerId;
    }

    public String getLehrerVorname() {
        return lehrerVorname;
    }

    public void setLehrerVorname(String lehrerVorname) {
        this.lehrerVorname = lehrerVorname;
    }

    public String getSchuelerVorname() {
        return schuelerVorname;
    }

    public void setSchuelerVorname(String schuelerVorname) {
        this.schuelerVorname = schuelerVorname;
    }


    

}