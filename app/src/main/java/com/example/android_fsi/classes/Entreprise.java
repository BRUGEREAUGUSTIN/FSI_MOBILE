package com.example.android_fsi.classes;

import java.io.Serializable;

public class Entreprise implements Serializable {
    private int id;
    private String libelle;
    private String ville;
    private String rue;
    private String telephone;
    private String numEnt;
    private String numeroRue;

    public Entreprise(int id, String libelle, String ville, String rue, String telephone, String numEnt, String numeroRue) {
        this.id = id;
        this.libelle = libelle;
        this.ville = ville;
        this.rue = rue;
        this.telephone = telephone;
        this.numEnt = numEnt;
        this.numeroRue = numeroRue;
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

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getRue() {
        return rue;
    }

    public void setRue(String rue) {
        this.rue = rue;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getNumEnt() {
        return numEnt;
    }

    public void setNumEnt(String numEnt) {
        this.numEnt = numEnt;
    }

    public String getNumeroRue() {
        return numeroRue;
    }

    public void setNumeroRue(String numeroRue) {
        this.numeroRue = numeroRue;
    }
}
