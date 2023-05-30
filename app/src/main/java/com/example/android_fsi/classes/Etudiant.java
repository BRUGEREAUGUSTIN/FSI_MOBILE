package com.example.android_fsi.classes;

import com.example.android_fsi.classes.Classe;
import com.example.android_fsi.classes.Entreprise;
import com.example.android_fsi.classes.Mds;
import com.example.android_fsi.classes.Professeur;
import com.example.android_fsi.classes.Specialite;

import java.io.Serializable;

public class Etudiant implements Serializable {
    private int id;
    private String prenom;
    private String nom;
    private String login;
    private String ville;
    private String rue;
    private String cp;
    private String numeroRue;
    private String telephone;
    private String email;
    private Classe classe;
    private Specialite specialite;
    private Entreprise entreprise;
    private Professeur professeur;
    private Mds mds;

    public Etudiant(int id, String prenom, String nom, String login, String ville, String rue, String cp, String numeroRue, String telephone, String email, Classe classe, Specialite specialite, Entreprise entreprise, Professeur professeur, Mds mds) {
        this.id = id;
        this.prenom = prenom;
        this.nom = nom;
        this.login = login;
        this.ville = ville;
        this.rue = rue;
        this.cp = cp;
        this.numeroRue = numeroRue;
        this.telephone = telephone;
        this.email = email;
        this.classe = classe;
        this.specialite = specialite;
        this.entreprise = entreprise;
        this.professeur = professeur;
        this.mds = mds;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
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

    public String getCp() {
        return cp;
    }

    public void setCp(String cp) {
        this.cp = cp;
    }

    public String getNumeroRue() {
        return numeroRue;
    }

    public void setNumeroRue(String numeroRue) {
        this.numeroRue = numeroRue;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Classe getClasse() {
        return classe;
    }

    public void setClasse(Classe classe) {
        this.classe = classe;
    }

    public Specialite getSpecialite() {
        return specialite;
    }

    public void setSpecialite(Specialite specialite) {
        this.specialite = specialite;
    }

    public Entreprise getEntreprise() {
        return entreprise;
    }

    public void setEntreprise(Entreprise entreprise) {
        this.entreprise = entreprise;
    }

    public Professeur getProfesseur() {
        return professeur;
    }

    public void setProfesseur(Professeur professeur) {
        this.professeur = professeur;
    }

    public Mds getMds() {
        return mds;
    }

    public void setMds(Mds mds) {
        this.mds = mds;
    }
}
