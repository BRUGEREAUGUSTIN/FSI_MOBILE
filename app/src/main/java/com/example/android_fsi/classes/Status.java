package com.example.android_fsi.classes;

import java.io.Serializable;

public class Status implements Serializable {
    private int id;
    private String libelle;

    public int getId() {
        return id;
    }

    public Status(int id, String libelle) {
        this.id = id;
        this.libelle = libelle;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }
}
