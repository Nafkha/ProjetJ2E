package com.projetj2e.projetj2e.beans;

public class Etudiant extends Personne  {
    private int numInsc;
    private String grp;
    private String data_insc;
    private int numGrp;

    public Etudiant(int cin, String nom, String prenom, String mail, String sexe, String date_naissance, int numInsc, String grp, String data_insc, int numGrp) {
        super(cin, nom, prenom, mail, sexe, date_naissance);
        this.numInsc = numInsc;
        this.grp = grp;
        this.data_insc = data_insc;
        this.numGrp = numGrp;
    }

    public int getNumInsc() {
        return numInsc;
    }

    public String getGrp() {
        return grp;
    }

    public String getData_insc() {
        return data_insc;
    }

    public int getNumGrp() {
        return numGrp;
    }
}
