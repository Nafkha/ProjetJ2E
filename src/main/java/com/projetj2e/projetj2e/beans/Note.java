package com.projetj2e.projetj2e.beans;

public class Note {
    private String Mat;
    private int Etu;
    private double Note;
    private String Type;

    public Note(String mat, int etu, double note, String type) {
        Mat = mat;
        Etu = etu;
        Note = note;
        Type = type;
    }

    public String getMat() {
        return Mat;
    }

    public int getEtu() {
        return Etu;
    }

    public double getNote() {
        return Note;
    }

    public String getType() {
        return Type;
    }
}
