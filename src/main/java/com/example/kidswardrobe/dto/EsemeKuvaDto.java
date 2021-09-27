package com.example.kidswardrobe.dto;

import java.sql.Blob;
import java.util.Base64;

public class EsemeKuvaDto {
    int id;
    String suurus;
    String kategooria;
    String piltBase64;

    public String getSuurus() {
        return suurus;
    }

    public void setSuurus(String suurus) {
        this.suurus = suurus;
    }

    public EsemeKuvaDto(int id, String suurus, String kategooria, String pilt) {
        this.id = id;
        this.suurus = suurus;
        this.kategooria = kategooria;
        this.piltBase64 = pilt;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public EsemeKuvaDto() {

    }

    public String getKategooria() {
        return kategooria;
    }

    public void setKategooria(String kategooria) {
        this.kategooria = kategooria;
    }

    public String getPilt() {
        return piltBase64;
    }

    public void setPilt(byte[] piltBytes) {
        if (piltBytes == null) {
            return;
        }
        this.piltBase64 = Base64.getEncoder().encodeToString(piltBytes);
    }
}
