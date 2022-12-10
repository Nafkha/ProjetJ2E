package com.projetj2e.projetj2e.beans;

public class Matiere {
    private String idMat;
    private String nomMat;
    private double coef;
    private int ens;
    private String gm;
    private int nbnotes;

    public Matiere() {
    }

    public void setIdMat(String idMat) {
        this.idMat = idMat;
    }

    public void setNomMat(String nomMat) {
        this.nomMat = nomMat;
    }

    public void setCoef(double coef) {
        this.coef = coef;
    }

    public void setEns(int ens) {
        this.ens = ens;
    }

    public void setGm(String gm) {
        this.gm = gm;
    }

    public void setNbnotes(int nbnotes) {
        this.nbnotes = nbnotes;
    }

    public Matiere(String idMat, String nomMat, double coef, int ens, String gm, int nbnotes) {
        this.idMat = idMat;
        this.nomMat = nomMat;
        this.coef = coef;
        this.ens = ens;
        this.gm = gm;
        this.nbnotes = nbnotes;
    }

    public String getIdMat() {
        return idMat;
    }

    public String getNomMat() {
        return nomMat;
    }

    public double getCoef() {
        return coef;
    }

    public int getEns() {
        return ens;
    }

    public String getGm() {
        return gm;
    }

    public int getNbnotes() {
        return nbnotes;
    }
}
