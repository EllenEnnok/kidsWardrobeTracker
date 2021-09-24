package com.example.kidswardrobe.dto;

public class LoginDto {
    private String kasutajanimi;
    private String parool;

    public LoginDto(String kasutajanimi, String parool) {
        this.kasutajanimi = kasutajanimi;
        this.parool = parool;
    }

    public LoginDto() {

    }

    public String getKasutajanimi() {
        return kasutajanimi;
    }

    public void setKasutajanimi(String kasutajanimi) {
        this.kasutajanimi = kasutajanimi;
    }

    public String getParool() {
        return parool;
    }

    public void setParool(String parool) {
        this.parool = parool;
    }
}
