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
public class Lehrer {

    private int lehrerId;
    private String vorname;
    private String nachname;
    private String adresse;
    private String phone;
    private String mail;
    private String rolle;

    public Lehrer(String vorname, String nachname, String adresse, String phone, String mail, String rolle) {
        this.vorname = vorname;
        this.nachname = nachname;
        this.adresse = adresse;
        this.phone = phone;
        this.mail = mail;
        this.rolle = rolle;
    }

    public Lehrer(int lehrerId, String vorname, String nachname, String adresse, String phone, String mail, String rolle) {
        this.lehrerId = lehrerId;
        this.vorname = vorname;
        this.nachname = nachname;
        this.adresse = adresse;
        this.phone = phone;
        this.mail = mail;
        this.rolle = rolle;
    }

    public Lehrer() {
    }

    
    
    public Lehrer(String vorname, String nachname) {
        this.vorname = vorname;
        this.nachname = nachname;
    }

    public int getLehrerId() {
        return lehrerId;
    }

    public void setLehrerId(int lehrerId) {
        this.lehrerId = lehrerId;
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

    public String getRolle() {
        return rolle;
    }

    public void setRolle(String rolle) {
        this.rolle = rolle;
    }

   

}
