package com.example.android_fsi.classes;

import java.io.Serializable;

public class Bilan1 implements Serializable {
    private float noteOral;
    private float noteDossier;
    private float noteEntreprise;
    private String date;
    private String commentaire;

    public Bilan1(float noteOral, float noteDossier, float noteEntreprise, String date, String commentaire) {
        this.noteOral = noteOral;
        this.noteDossier = noteDossier;
        this.noteEntreprise = noteEntreprise;
        this.date = date;
        this.commentaire = commentaire;
    }

    public float getNoteOral() {
        return noteOral;
    }

    public void setNoteOral(float noteOral) {
        this.noteOral = noteOral;
    }

    public float getNoteDossier() {
        return noteDossier;
    }

    public void setNoteDossier(float noteDossier) {
        this.noteDossier = noteDossier;
    }

    public float getNoteEntreprise() {
        return noteEntreprise;
    }

    public void setNoteEntreprise(float noteEntreprise) {
        this.noteEntreprise = noteEntreprise;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getCommentaire() {
        return commentaire;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }
}
