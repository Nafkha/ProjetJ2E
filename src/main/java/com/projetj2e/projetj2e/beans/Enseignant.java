package com.projetj2e.projetj2e.beans;

public class Enseignant extends Personne{
    private int cnss;

    public Enseignant(int cin, String nom, String prenom, String mail, String sexe, String date_naissance, int cnss) {
        super(cin, nom, prenom, mail, sexe, date_naissance);
        this.cnss = cnss;
    }



    public int getCnss() {
        return cnss;
    }
}
