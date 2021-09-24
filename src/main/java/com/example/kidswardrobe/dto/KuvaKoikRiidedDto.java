package com.example.kidswardrobe.dto;

import java.sql.Blob;

public class KuvaKoikRiidedDto {
    int id;
    String suurus;
    String kategooria;
    Blob pilt;

    public KuvaKoikRiidedDto() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSuurus() {
        return suurus;
    }

    public void setSuurus(String suurus) {
        this.suurus = suurus;
    }

    public String getKategooria() {
        return kategooria;
    }

    public void setKategooria(String kategooria) {
        this.kategooria = kategooria;
    }

    public Blob getPilt() {
        return pilt;
    }

    public void setPilt(Blob pilt) {
        this.pilt = pilt;
    }
}
