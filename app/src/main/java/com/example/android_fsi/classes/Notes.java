package com.example.android_fsi.classes;

import java.io.Serializable;

public class Notes implements Serializable {
    private int id;
    private Bilan1 bilan1;
    private Bilan2 bilan2;

    public Notes(int id, Bilan1 bilan1, Bilan2 bilan2) {
        this.id = id;
        this.bilan1 = bilan1;
        this.bilan2 = bilan2;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Bilan1 getBilan1() {
        return bilan1;
    }

    public void setBilan1(Bilan1 bilan1) {
        this.bilan1 = bilan1;
    }

    public Bilan2 getBilan2() {
        return bilan2;
    }

    public void setBilan2(Bilan2 bilan2) {
        this.bilan2 = bilan2;
    }
}
