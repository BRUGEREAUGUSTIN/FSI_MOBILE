package com.example.android_fsi.classes;

import java.io.Serializable;

public class Bilan2 implements Serializable {
    private float noteOral;
    private float noteDossier;
    private String date;
    private String commentaire;

    public Bilan2(float noteOral, float noteDossier, String date, String commentaire) {
        this.noteOral = noteOral;
        this.noteDossier = noteDossier;
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
