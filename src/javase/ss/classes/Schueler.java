/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javase.ss.classes;



/**
 *
 * @author CC-Student
 */
public class Schueler {
    
    private int schuelerId;
    private String vorname;
    private String nachname;
    private String vaterName;
    private String mutterName;
    private String geburtstag;
    private String geschlecht;
    private String adresse;
    private String phone;
    private String mail;
    private Integer lehrerId;
    
    
        public Schueler(int schuelerId, String vorname, String nachname, 
            String vaterName, String mutterName, String geburtstag, 
            String geschlecht, String adresse, String phone, String mail, 
            Integer lehrerId) {
        this.schuelerId = schuelerId;
        this.vorname = vorname;
        this.nachname = nachname;
        this.vaterName = vaterName;
        this.mutterName = mutterName;
        this.geburtstag = geburtstag;
        this.geschlecht = geschlecht;
        this.adresse = adresse;
        this.phone = phone;
        this.mail = mail;
        this.lehrerId = lehrerId;
    }
    
    

    public Schueler(String vorname, String nachname, String vaterName, 
            String mutterName, String geburtstag, String geschlecht, 
            String adresse, String phone, String mail) {
        
        this.vorname = vorname;
        this.nachname = nachname;
        this.vaterName = vaterName;
        this.mutterName = mutterName;
        this.geburtstag = geburtstag;
        this.geschlecht = geschlecht;
        this.adresse = adresse;
        this.phone = phone;
        this.mail = mail;
        //this.lehrerId = lehrer;
    }

    public Schueler(String vorname, String nachname, String vaterName, String mutterName, String geburtstag, String geschlecht, String adresse, String phone, String mail, Integer lehrerId) {
        this.vorname = vorname;
        this.nachname = nachname;
        this.vaterName = vaterName;
        this.mutterName = mutterName;
        this.geburtstag = geburtstag;
        this.geschlecht = geschlecht;
        this.adresse = adresse;
        this.phone = phone;
        this.mail = mail;
        this.lehrerId = lehrerId;
    }





    public Schueler() {
    }

   

    public int getSchuelerId() {
        return schuelerId;
    }

    public void setSchuelerId(int schuelerId) {
        this.schuelerId = schuelerId;
    }





    public String getVorname() {
        return vorname;
    }

    public void setVorname(String vorname) {
        this.vorname = vorname;
    }

    public String getNachname() {
        return nachname;
    }

    public void setNachname(String nachname) {
        this.nachname = nachname;
    }

    public String getVaterName() {
        return vaterName;
    }

    public void setVaterName(String vaterName) {
        this.vaterName = vaterName;
    }

    public String getMutterName() {
        return mutterName;
    }

    public void setMutterName(String mutterName) {
        this.mutterName = mutterName;
    }

    public String getGeburtstag() {
        return geburtstag;
    }

    public void setGeburtstag(String geburtstag) {
        this.geburtstag = geburtstag;
    }

   

    public String getGeschlecht() {
        return geschlecht;
    }

    public void setGeschlecht(String geschlecht) {
        this.geschlecht = geschlecht;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public Integer getLehrerId() {
        return lehrerId;
    }

    public void setLehrerId(Integer lehrerId) {
        this.lehrerId = lehrerId;
    }

 
    
    
}
