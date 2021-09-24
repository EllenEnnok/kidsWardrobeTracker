package com.example.kidswardrobe.dto;

import java.sql.Blob;

public class LisaJalatsDto {
    private Integer suurusJalatsid;
    private Integer hooaeg;
    private Integer kategooria;
    private Integer sugu;
    private Integer varv;
    private String lisainfo;
    private String tootja;
    Blob pilt;

    public LisaJalatsDto(Integer suurusJalatsid, Integer hooaeg, Integer kategooria, Integer sugu, Integer varv, String lisainfo, String tootja, Blob pilt) {
        this.suurusJalatsid = suurusJalatsid;
        this.hooaeg = hooaeg;
        this.kategooria = kategooria;
        this.sugu = sugu;
        this.varv = varv;
        this.lisainfo = lisainfo;
        this.tootja = tootja;
        this.pilt = pilt;
    }

    public Integer getSuurusJalatsid() {
        return suurusJalatsid;
    }

    public void setSuurusJalatsid(Integer suurusJalatsid) {
        this.suurusJalatsid = suurusJalatsid;
    }

    public Integer getHooaeg() {
        return hooaeg;
    }

    public void setHooaeg(Integer hooaeg) {
        this.hooaeg = hooaeg;
    }

    public Integer getKategooria() {
        return kategooria;
    }

    public void setKategooria(Integer kategooria) {
        this.kategooria = kategooria;
    }

    public Integer getSugu() {
        return sugu;
    }

    public void setSugu(Integer sugu) {
        this.sugu = sugu;
    }

    public Integer getVarv() {
        return varv;
    }

    public void setVarv(Integer varv) {
        this.varv = varv;
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
