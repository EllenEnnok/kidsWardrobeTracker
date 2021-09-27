package com.example.kidswardrobe.dto;

import java.util.List;

public class FiltridDto {
    public List<KlassifikaatorDto> asukohad;
    public List<KlassifikaatorDto> hooajad;
    public List<KlassifikaatorDto> kategooriad;
    public List<KlassifikaatorDto> materjalid;
    public List<KlassifikaatorDto> sugu;
    public List<KlassifikaatorDto> suurus_jalatsid;
    public List<KlassifikaatorDto> suurus_riided;
    public List<KlassifikaatorDto> tyybid;
    public List<KlassifikaatorDto> varvid;


    public List<KlassifikaatorDto> getTyybid() {
        return tyybid;
    }

    public void setTyybid(List<KlassifikaatorDto> tyybid) {
        this.tyybid = tyybid;
    }

    public List<KlassifikaatorDto> getVarvid() {
        return varvid;
    }

    public void setVarvid(List<KlassifikaatorDto> varvid) {
        this.varvid = varvid;
    }



    public List<KlassifikaatorDto> getHooajad() {
        return hooajad;
    }

    public void setHooajad(List<KlassifikaatorDto> hooajad) {
        this.hooajad = hooajad;
    }

    public List<KlassifikaatorDto> getKategooriad() {
        return kategooriad;
    }

    public void setKategooriad(List<KlassifikaatorDto> kategooriad) {
        this.kategooriad = kategooriad;
    }

    public List<KlassifikaatorDto> getMaterjalid() {
        return materjalid;
    }

    public void setMaterjalid(List<KlassifikaatorDto> materjalid) {
        this.materjalid = materjalid;
    }

    public List<KlassifikaatorDto> getSugu() {
        return sugu;
    }

    public void setSugu(List<KlassifikaatorDto> sugu) {
        this.sugu = sugu;
    }

    public List<KlassifikaatorDto> getSuurus_jalatsid() {
        return suurus_jalatsid;
    }

    public void setSuurus_jalatsid(List<KlassifikaatorDto> suurus_jalatsid) {
        this.suurus_jalatsid = suurus_jalatsid;
    }

    public List<KlassifikaatorDto> getSuurus_riided() {
        return suurus_riided;
    }

    public void setSuurus_riided(List<KlassifikaatorDto> suurus_riided) {
        this.suurus_riided = suurus_riided;
    }


    public List<KlassifikaatorDto> getAsukohad() {
        return asukohad;
    }

    public void setAsukohad(List<KlassifikaatorDto> asukohad) {
        this.asukohad = asukohad;
    }
}

