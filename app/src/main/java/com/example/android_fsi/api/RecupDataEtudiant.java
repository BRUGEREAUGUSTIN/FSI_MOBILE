package com.example.android_fsi.api;

import android.os.Parcelable;

import com.example.android_fsi.classes.Etudiant;
import com.example.android_fsi.classes.Notes;

import java.io.Serializable;

public class RecupDataEtudiant implements Serializable {
    private Etudiant etudiant;
    private Notes notes;

    public RecupDataEtudiant(Etudiant etudiant, Notes notes) {
        this.etudiant = etudiant;
        this.notes = notes;
    }

    public Etudiant getEtudiant() {
        return etudiant;
    }

    public void setEtudiant(Etudiant etudiant) {
        this.etudiant = etudiant;
    }

    public Notes getNotes() {
        return notes;
    }

    public void setNotes(Notes notes) {
        this.notes = notes;
    }
}
