package com.example.android_fsi.classes;

import java.io.Serializable;

public class Classe implements Serializable {
    private int id;
    private String libelle;

    public Classe(int id, String libelle) {
        this.id = id;
        this.libelle = libelle;
    }



    public int getId() {
        return id;
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
