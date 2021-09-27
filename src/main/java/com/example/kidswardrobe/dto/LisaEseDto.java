package com.example.kidswardrobe.dto;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.sql.Blob;

public class LisaEseDto {
    private Integer tyyp;
    private Integer hooaeg;
    private Integer riideSuurus;
    private Integer jalatsiSuurus;
    private Integer varv;
    private Integer sugu;
    private Integer materjal;
    private Integer asukoht;
    private Integer kategooria;
    private String lisainfo;
    private String tootja;
    private MultipartFile pilt;

    public Integer getTyyp() {
        return tyyp;
    }

    public void setTyyp(Integer tyyp) {
        this.tyyp = tyyp;
    }

    public Integer getHooaeg() {
        return hooaeg;
    }

    public void setHooaeg(Integer hooaeg) {
        this.hooaeg = hooaeg;
    }

    public Integer getRiideSuurus() {
        return riideSuurus;
    }

    public void setRiideSuurus(Integer riideSuurus) {
        this.riideSuurus = riideSuurus;
    }

    public Integer getJalatsiSuurus() {
        return jalatsiSuurus;
    }

    public void setJalatsiSuurus(Integer jalatsiSuurus) {
        this.jalatsiSuurus = jalatsiSuurus;
    }

    public Integer getVarv() {
        return varv;
    }

    public void setVarv(Integer varv) {
        this.varv = varv;
    }

    public Integer getSugu() {
        return sugu;
    }

    public void setSugu(Integer sugu) {
        this.sugu = sugu;
    }

    public Integer getMaterjal() {
        return materjal;
    }

    public void setMaterjal(Integer materjal) {
        this.materjal = materjal;
    }

    public Integer getAsukoht() {
        return asukoht;
    }

    public void setAsukoht(Integer asukoht) {
        this.asukoht = asukoht;
    }

    public Integer getKategooria() {
        return kategooria;
    }

    public void setKategooria(Integer kategooria) {
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

    public MultipartFile getPilt() {
        return pilt;
    }

    public byte[] getPictureBytes() throws IOException {
        return pilt.getBytes();
    }

    public void setPilt(MultipartFile pilt) {
        this.pilt = pilt;
    }

    public LisaEseDto() {
    }

    public LisaEseDto(Integer tyyp, Integer hooaeg, Integer riideSuurus, Integer jalatsiSuurus, Integer varv, Integer sugu, Integer materjal, Integer asukoht, Integer kategooria, String lisainfo, String tootja, MultipartFile pilt) {
        this.tyyp = tyyp;
        this.hooaeg = hooaeg;
        this.riideSuurus = riideSuurus;
        this.jalatsiSuurus = jalatsiSuurus;
        this.varv = varv;
        this.sugu = sugu;
        this.materjal = materjal;
        this.asukoht = asukoht;
        this.kategooria = kategooria;
        this.lisainfo = lisainfo;
        this.tootja = tootja;
        this.pilt = pilt;
    }
}