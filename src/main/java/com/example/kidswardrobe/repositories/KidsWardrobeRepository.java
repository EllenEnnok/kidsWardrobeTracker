package com.example.kidswardrobe.repositories;

import com.example.kidswardrobe.dto.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import com.example.kidswardrobe.services.KidsWardrobeService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class KidsWardrobeRepository {
    @Autowired
    private NamedParameterJdbcTemplate JdbcTemplate;


    public String validate(String userName) {
        String sql = "SELECT parool FROM kasutaja WHERE kasutajanimi = :userName";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("userName", userName);
        String vastus = JdbcTemplate.queryForObject(sql, paramMap, String.class);
        return vastus;
    }

    public void looKonto(LoginDto loginDto) {
        String sql = "INSERT INTO kasutaja (kasutajanimi, parool)" +
                "VALUES (:kasutajanimi, :parool)";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("kasutajanimi", loginDto.getKasutajanimi());
        paramMap.put("parool", loginDto.getParool());

        JdbcTemplate.update(sql, new MapSqlParameterSource(paramMap));
    }
    public List<EsemeKuvaDto> kuvariided(EsemeFilterDto filter) {
        String sql = "SELECT " +
                "riideese.id as id," +
                "suuruse_vahemik as suurus," +
                "kategooria," +
                "pilt" +
                " FROM riideese " +
                "LEFT JOIN suurus_riided ON riideese.suurus_riided_id = suurus_riided.id " +
                "LEFT JOIN kategooria ON riideese.kategooria_id = kategooria.id " +
                "WHERE 1 = 1 ";

        return addFilterValueToSql(sql, filter);
    }


    public List<EsemeKuvaDto> kuvaJalatsid(EsemeFilterDto filter) {

        String sql = "SELECT" +
                " jalatsid.id," +
                "suurus," +
                "kategooria," +
                "pilt" +
                " FROM jalatsid " +
                "LEFT JOIN suurus_jalatsid ON jalatsid.suurus_jalatsid_id = suurus_jalatsid.id " +
                "LEFT JOIN kategooria ON jalatsid.kategooria_id = kategooria.id " +
                "WHERE 1 = 1 ";

        return addFilterValueToSql(sql, filter);
    }


    public List<EsemeKuvaDto> addFilterValueToSql(String sql, EsemeFilterDto filter) {

        Map<String, Object> map = new HashMap<>();
        if (filter.getHooaeg() != null) {
            sql = sql + " AND hooaeg_id = :hooaegId";
            map.put("hooaegId", filter.getHooaeg());
        }

        if (filter.getKategooria() != null) {
            sql = sql + " AND kategooria_id = :kategooriaId";
            map.put("kategooriaId", filter.getKategooria());
        }
        List<EsemeKuvaDto> vastus = JdbcTemplate.query(sql, map, new KidsWardrobeService.EsemeKuvaDtoRowMapper());
        return vastus;
    }


    public void lisaRiietusKappi(LisaRiietusDto lisaRiietusDto) {
        String sql = "INSERT INTO riideese (tüüp_id, hooaeg_id, suurus_riided_id, värv_id," +
                " sugu_id, materjal_id, kategooria_id, lisainfo, tootja, asukoht_id)" +
                " VALUES (:tyyp, :hooaeg, :riideSuurus, :värv, :sugu, :materjal, :kategooria, :lisainfo, :tootja, :asukoht)";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("tyyp", lisaRiietusDto.getTyyp());
        paramMap.put("hooaeg", lisaRiietusDto.getHooaeg());
        paramMap.put("riideSuurus", lisaRiietusDto.getRiideSuurus());
        paramMap.put("värv", lisaRiietusDto.getVarv());
        paramMap.put("sugu", lisaRiietusDto.getSugu());
        paramMap.put("materjal", lisaRiietusDto.getMaterjal());
        paramMap.put("kategooria", lisaRiietusDto.getKategooria());
        paramMap.put("lisainfo", lisaRiietusDto.getLisainfo());
        paramMap.put("tootja", lisaRiietusDto.getTootja());
        paramMap.put("asukoht", lisaRiietusDto.getAsukoht());
        paramMap.put("pilt", lisaRiietusDto.getPilt());

        JdbcTemplate.update(sql, new MapSqlParameterSource(paramMap));

    }

    public void lisaJalatsidKappi(LisaJalatsDto lisaJalatsDto) {
        String sql = "INSERT INTO jalatsid (suurus_jalatsid_id, hooaeg_id, kategooria_id, sugu_id, värv_id, lisainfo, tootja, pilt)" +
                "VALUES (:jalatsiSuurus, :hooaeg, :kategooria, :sugu, :värv, :lisainfo, :tootja, :pilt)";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("jalatsiSuurus", lisaJalatsDto.getSuurusJalatsid());
        paramMap.put("hooaeg", lisaJalatsDto.getHooaeg());
        paramMap.put("kategooria", lisaJalatsDto.getKategooria());
        paramMap.put("sugu", lisaJalatsDto.getSugu());
        paramMap.put("värv", lisaJalatsDto.getVarv());
        paramMap.put("lisainfo", lisaJalatsDto.getLisainfo());
        paramMap.put("tootja", lisaJalatsDto.getTootja());
        paramMap.put("pilt", lisaJalatsDto.getPilt());

        JdbcTemplate.update(sql, new MapSqlParameterSource(paramMap));

    }
}
