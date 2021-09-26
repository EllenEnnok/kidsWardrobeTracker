package com.example.kidswardrobe.dto;

import java.sql.Blob;

public class EsemeDetailidDto {
    private String tyyp;
    private String hooaeg;
    private String suurus;
    private String varv;
    private String sugu;
    private String materjal;
    private String asukoht;
    private String kategooria;
    private String lisainfo;
    private String tootja;
    private Blob pilt;
    private Integer esemeId;

    public EsemeDetailidDto() {

    }

    public Integer getEsemeId() {
        return esemeId;
    }

    public void setEsemeId(Integer esemeId) {
        this.esemeId = esemeId;
    }

    public EsemeDetailidDto(String tyyp, String hooaeg, String suurus, String varv, String sugu, String materjal, String asukoht, String kategooria, String lisainfo, String tootja, Blob pilt, Integer esemeId) {
        this.tyyp = tyyp;
        this.hooaeg = hooaeg;
        this.suurus = suurus;
        this.varv = varv;
        this.sugu = sugu;
        this.materjal = materjal;
        this.asukoht = asukoht;
        this.kategooria = kategooria;
        this.lisainfo = lisainfo;
        this.tootja = tootja;
        this.pilt = pilt;
        this.esemeId = esemeId;
    }

    public String getTyyp() {
        return tyyp;
    }

    public void setTyyp(String tyyp) {
        this.tyyp = tyyp;
    }

    public String getHooaeg() {
        return hooaeg;
    }

    public void setHooaeg(String hooaeg) {
        this.hooaeg = hooaeg;
    }

    public String getSuurus() {
        return suurus;
    }

    public void setSuurus(String suurus) {
        this.suurus = suurus;
    }

    public String getVarv() {
        return varv;
    }

    public void setVarv(String varv) {
        this.varv = varv;
    }

    public String getSugu() {
        return sugu;
    }

    public void setSugu(String sugu) {
        this.sugu = sugu;
    }

    public String getMaterjal() {
        return materjal;
    }

    public void setMaterjal(String materjal) {
        this.materjal = materjal;
    }

    public String getAsukoht() {
        return asukoht;
    }

    public void setAsukoht(String asukoht) {
        this.asukoht = asukoht;
    }

    public String getKategooria() {
        return kategooria;
    }

    public void setKategooria(String kategooria) {
        this.kategooria = kategooria;
    }

    public String getLisainfo() {
        return lisainfo;
    }

    public void setLisainfo(String lisainfo) {
        this.lisainfo = lisainfo;
    }

    public String getTootja() {
        return tootja;
    }

    public void setTootja(String tootja) {
        this.tootja = tootja;
    }

    public Blob getPilt() {
        return pilt;
    }

    public void setPilt(Blob pilt) {
        this.pilt = pilt;
    }
}
