package com.projetj2e.projetj2e.beans;

public class Personne {
    private int cin;
    private String nom,prenom,mail,sexe, date_naissance;

    public Personne(int cin, String nom, String prenom, String mail, String sexe, String date_naissance) {
        this.cin = cin;
        this.nom = nom;
        this.prenom = prenom;
        this.mail = mail;
        this.sexe = sexe;
        this.date_naissance = date_naissance;
    }

    public int getCin() {
        return cin;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getMail() {
        return mail;
    }

    public String getSexe() {
        return sexe;
    }

    public String getDate_naissance() {
        return date_naissance;
    }
}
