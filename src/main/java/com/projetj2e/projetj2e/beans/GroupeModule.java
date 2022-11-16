package com.projetj2e.projetj2e.beans;

public class GroupeModule {
    private String idGM,nomGM;
    private double coefGM;
    private String grp;

    public GroupeModule(String idGM, String nomGM, double coefGM, String grp) {
        this.idGM = idGM;
        this.nomGM = nomGM;
        this.coefGM = coefGM;
        this.grp = grp;
    }

    public String getIdGM() {
        return idGM;
    }

    public String getNomGM() {
        return nomGM;
    }

    public double getCoefGM() {
        return coefGM;
    }

    public String getGrp() {
        return grp;
    }
}
