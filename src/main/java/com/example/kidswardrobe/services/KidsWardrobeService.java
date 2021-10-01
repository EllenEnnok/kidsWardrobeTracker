package com.example.kidswardrobe.services;

import com.example.kidswardrobe.dto.*;
import com.example.kidswardrobe.repositories.KidsWardrobeRepository;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.sql.Blob;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

@Service

public class KidsWardrobeService {
    @Autowired
    private KidsWardrobeRepository kidsWardrobeRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;


    public String logiSisse(LoginDto loginDto) {

        String userName = loginDto.getKasutajanimi();
        String parool = loginDto.getParool();
        String encodedPassword = kidsWardrobeRepository.validate(userName);
        boolean isValid = passwordEncoder.matches(parool, encodedPassword);
        if (!isValid) {
            throw new SecurityException("Wrong username or password");
        }

        Date now = new Date();    // tokeni genereerimine
        Date expiration = new Date(now.getTime() + 1000l * 60l * 60l * 24l * 10l);
        JwtBuilder jwtBuilder = Jwts.builder()
                .setExpiration(expiration)
                .setIssuedAt(new Date())
                .setIssuer("issuer")

                .signWith(SignatureAlgorithm.HS256, "secret")
                .claim("username",
                        userName);
        String jwt = jwtBuilder.compact();

        return jwt;

    }


    public void looKonto(LoginDto loginDto) {
        String kasutajanimi = loginDto.getKasutajanimi();
        String parool = loginDto.getParool();
        String encodedParool = passwordEncoder.encode(parool);
        loginDto.setKasutajanimi(kasutajanimi);
        loginDto.setParool(encodedParool);
        kidsWardrobeRepository.looKonto(loginDto);

    }


    public List<EsemeKuvaDto> kuvaKoguKapp(EsemeFilterDto filter) {
        return kidsWardrobeRepository.kuvaRiided(filter);
    }

    public void lisaEseKappi(LisaEseDto lisaEseDto) throws IOException {
        kidsWardrobeRepository.lisaEseKappi(lisaEseDto);
    }


    public static class EsemeKuvaDtoRowMapper implements RowMapper<EsemeKuvaDto> {

        @Override
        public EsemeKuvaDto mapRow(ResultSet resultSet, int i) throws SQLException {
            EsemeKuvaDto result = new EsemeKuvaDto();
            result.setSuurus(resultSet.getString("suurus"));
            result.setKategooria(resultSet.getString("kategooria"));
            result.setPilt(resultSet.getBytes("pilt"));
            result.setId(resultSet.getInt("id"));
            return result;
        }
    }

    public void kustutaEse(KustutaEseDto kustutaEseDto) {

        kidsWardrobeRepository.kustutaEse(kustutaEseDto);
    }

    public void lisaAsukoht(LisaAsukohtDto lisaAsukohtDto) {
        kidsWardrobeRepository.lisaAsukoht(lisaAsukohtDto);
    }

    public EsemeDetailidDto kuvaEsemeDetailid(Integer esemeId) {
        return kidsWardrobeRepository.kuvaEsemeDetailid(esemeId);
    }

    public static class EsemeDetailidRowMapper implements RowMapper<EsemeDetailidDto> {

        @Override
        public EsemeDetailidDto mapRow(ResultSet resultSet, int i) throws SQLException {
            EsemeDetailidDto result = new EsemeDetailidDto();
            result.setEsemeId(resultSet.getInt("id"));
            result.setTyyp(resultSet.getString("tüüp"));
            result.setVarv(resultSet.getString("värv"));
            result.setHooaeg(resultSet.getString("hooaeg"));
            result.setSuurus(resultSet.getString("suurus"));
            result.setSugu(resultSet.getString("sugu"));
            result.setMaterjal(resultSet.getString("materjal"));
            result.setAsukoht(resultSet.getString("asukoht"));
            result.setKategooria(resultSet.getString("kategooria"));
            result.setLisainfo(resultSet.getString("lisainfo"));
            result.setTootja(resultSet.getString("tootja"));
            result.setPilt(resultSet.getBytes("pilt"));
            return result;
        }
    }

    public FiltridDto annaKoikFiltrid() {
        FiltridDto filtrid = new FiltridDto();
        List<KlassifikaatorDto> asukohad = kidsWardrobeRepository.annaKoikAsukohad();
        List<KlassifikaatorDto> hooajad = kidsWardrobeRepository.annaKoikHooajad();
        List<KlassifikaatorDto> kategooriad = kidsWardrobeRepository.annaKoikKategooriad();
        List<KlassifikaatorDto> materjalid = kidsWardrobeRepository.annaKoikMaterjalid();
        List<KlassifikaatorDto> sugu = kidsWardrobeRepository.annaKoikSugu();
        List<KlassifikaatorDto> suurusJalatsid = kidsWardrobeRepository.annaKoikJalatsiSuurused();
        List<KlassifikaatorDto> suurusRiided = kidsWardrobeRepository.annaKoikRiideSuurused();
        List<KlassifikaatorDto> tyybid = kidsWardrobeRepository.annaKoikTyybid();
        List<KlassifikaatorDto> varvid = kidsWardrobeRepository.annaKoikVarvid();

        filtrid.setVarvid(varvid);
        filtrid.setTyybid(tyybid);
        filtrid.setSuurus_riided(suurusRiided);
        filtrid.setSuurus_jalatsid(suurusJalatsid);
        filtrid.setSugu(sugu);
        filtrid.setMaterjalid(materjalid);
        filtrid.setKategooriad(kategooriad);
        filtrid.setHooajad(hooajad);
        filtrid.setAsukohad(asukohad);
        return filtrid;
    }

    public static class KlassifikaatorDtoRowMapper implements RowMapper<KlassifikaatorDto> {

        @Override
        public KlassifikaatorDto mapRow(ResultSet resultSet, int i) throws SQLException {
            KlassifikaatorDto result = new KlassifikaatorDto();
            result.setId(resultSet.getInt("id"));
            result.setNimetus(resultSet.getString("nimetus"));
            return result;
        }
    }
}
