package com.example.studentcampuss.model;

import java.io.Serializable;

public class MataKuliah implements Serializable {

    private String namaMk;
    private int sks;

    public MataKuliah(String namaMk, int sks) {
        this.namaMk = namaMk;
        this.sks = sks;
    }

    public String getNamaMk() {
        return namaMk;
    }

    public void setNamaMk(String namaMk) {
        this.namaMk = namaMk;
    }

    public int getSks() {
        return sks;
    }

    public void setSks(int sks) {
        this.sks = sks;
    }

    @Override
    public String toString() {
        return namaMk + " (" + sks + " SKS)";
    }
}
