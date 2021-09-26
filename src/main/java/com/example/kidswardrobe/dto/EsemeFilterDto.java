package com.example.kidswardrobe.dto;

public class EsemeFilterDto {
    private Integer hooaegId;
    private Integer kategooriaId;
    private Integer asukohtId;
    private Integer materjalId;
    private Integer suguId;
    private Integer suurusJalatsidId;
    private Integer suurusRiidedId;
    private Integer tyypId;
    private Integer varvId;

    public EsemeFilterDto() {
    }

    public Integer getHooaegId() {
        return hooaegId;
    }

    public void setHooaegId(Integer hooaegId) {
        this.hooaegId = hooaegId;
    }

    public Integer getKategooriaId() {
        return kategooriaId;
    }

    public void setKategooriaId(Integer kategooriaId) {
        this.kategooriaId = kategooriaId;
    }

    public Integer getAsukohtId() {
        return asukohtId;
    }

    public void setAsukohtId(Integer asukohtId) {
        this.asukohtId = asukohtId;
    }

    public Integer getMaterjalId() {
        return materjalId;
    }

    public void setMaterjalId(Integer materjalId) {
        this.materjalId = materjalId;
    }

    public Integer getSuguId() {
        return suguId;
    }

    public void setSuguId(Integer suguId) {
        this.suguId = suguId;
    }

    public Integer getSuurusJalatsidId() {
        return suurusJalatsidId;
    }

    public void setSuurusJalatsidId(Integer suurusJalatsidId) {
        this.suurusJalatsidId = suurusJalatsidId;
    }

    public Integer getSuurusRiidedId() {
        return suurusRiidedId;
    }

    public void setSuurusRiidedId(Integer suurusRiidedId) {
        this.suurusRiidedId = suurusRiidedId;
    }

    public Integer getTyypId() {
        return tyypId;
    }

    public void setTyypId(Integer tyypId) {
        this.tyypId = tyypId;
    }

    public Integer getVarvId() {
        return varvId;
    }

    public void setVarvId(Integer varvId) {
        this.varvId = varvId;
    }

    public EsemeFilterDto(Integer hooaegId, Integer kategooriaId, Integer asukohtId, Integer materjalId, Integer suguId, Integer suurusJalatsidId, Integer suurusRiidedId, Integer tyypId, Integer varvId) {
        this.hooaegId = hooaegId;
        this.kategooriaId = kategooriaId;
        this.asukohtId = asukohtId;
        this.materjalId = materjalId;
        this.suguId = suguId;
        this.suurusJalatsidId = suurusJalatsidId;
        this.suurusRiidedId = suurusRiidedId;
        this.tyypId = tyypId;
        this.varvId = varvId;
    }
}