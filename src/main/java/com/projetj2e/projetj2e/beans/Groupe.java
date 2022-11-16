package com.projetj2e.projetj2e.beans;

public class Groupe {
    private String idGrp,niveau,diplome,specialite;
    private int numGrp;

    public Groupe(String idGrp, String niveau, String diplome, String specialite, int numGrp) {
        this.idGrp = idGrp;
        this.niveau = niveau;
        this.diplome = diplome;
        this.specialite = specialite;
        this.numGrp = numGrp;
    }

    public String getIdGrp() {
        return idGrp;
    }

    public String getNiveau() {
        return niveau;
    }

    public String getDiplome() {
        return diplome;
    }

    public String getSpecialite() {
        return specialite;
    }

    public int getNumGrp() {
        return numGrp;
    }
}
