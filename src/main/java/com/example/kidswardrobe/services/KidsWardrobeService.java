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
            return null;
        }

        Date now = new Date();    // tokeni genereerimine
        Date expiration = new Date(now.getTime() + 1000l*60l*60l*24l*10l);
        JwtBuilder jwtBuilder = Jwts.builder()
                .setExpiration(expiration)
                .setIssuedAt(new Date())
                .setIssuer("issuer")

                .signWith(SignatureAlgorithm.HS256,"secret")
                .claim("username",
                        userName);
        String jwt = jwtBuilder.compact();

        return jwt;

    }


    public void looKonto(LoginDto loginDto){
        String kasutajanimi = loginDto.getKasutajanimi();
        String parool = loginDto.getParool();
        String encodedParool = passwordEncoder.encode(parool);
        loginDto.setKasutajanimi(kasutajanimi);
        loginDto.setParool(encodedParool);
        kidsWardrobeRepository.looKonto(loginDto);

    }


    public List<EsemeKuvaDto> kuvaKoguKapp(EsemeFilterDto filter) {
        List<EsemeKuvaDto> riided = kuvariided(filter);
        List<EsemeKuvaDto> jalatsid = kuvaJalatsid(filter);

        riided.addAll(jalatsid);  // liidab kokku jalatsi ja riiete listid yheks listiks
        return riided;
    }

    public List<EsemeKuvaDto> kuvariided(EsemeFilterDto filter) {
        return kidsWardrobeRepository.kuvariided(filter);
    }

    public List<EsemeKuvaDto> kuvaJalatsid(EsemeFilterDto filter) {
        return kidsWardrobeRepository.kuvaJalatsid(filter);
    }

    public void lisaRiietusKappi(LisaRiietusDto lisaRiietusDto) {
        kidsWardrobeRepository.lisaRiietusKappi(lisaRiietusDto);
    }

    public void lisaJalatsidKappi(LisaJalatsDto lisaJalatsDto) {
        kidsWardrobeRepository.lisaJalatsidKappi(lisaJalatsDto);
    }

    public static class KuvaKoikRiidedDtoRowMapper implements RowMapper<KuvaKoikRiidedDto> {
        public KuvaKoikRiidedDto mapRow(ResultSet resultSet, int i) throws SQLException {
            KuvaKoikRiidedDto result = new KuvaKoikRiidedDto();
            result.setSuurus(resultSet.getString("suurusRiided"));
            result.setKategooria(resultSet.getString("kategooria"));
            result.setPilt((Blob) resultSet.getBlob("pilt"));
            result.setId(resultSet.getInt("id"));
            return result;
        }
    }

    public static class KuvaKoikJalatsidDtoRowMapper implements RowMapper<KuvaKoikJalatsidDto> {

        @Override
        public KuvaKoikJalatsidDto mapRow(ResultSet resultSet, int i) throws SQLException {
            KuvaKoikJalatsidDto result = new KuvaKoikJalatsidDto();
            result.setSuurus(resultSet.getString("suurusJalatsid"));
            result.setKategooria(resultSet.getString("kategooria"));
            result.setPilt((Blob) resultSet.getBlob("pilt"));
            result.setId(resultSet.getInt("id"));
            return result;
        }
    }

    public static class EsemeKuvaDtoRowMapper implements RowMapper<EsemeKuvaDto> {

        @Override
        public EsemeKuvaDto mapRow(ResultSet resultSet, int i) throws SQLException {
            EsemeKuvaDto result = new EsemeKuvaDto();
            result.setSuurus(resultSet.getString("suurus"));
            result.setKategooria(resultSet.getString("kategooria"));
            result.setPilt((Blob) resultSet.getBlob("pilt"));
            result.setId(resultSet.getInt("id"));
            return result;
        }
    }

    public void kustutaEse(KustutaEseDto kustutaEseDto) {
        kidsWardrobeRepository.kustutaEse(kustutaEseDto);
    }

}
