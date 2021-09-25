package com.example.kidswardrobe.repositories;

import com.example.kidswardrobe.dto.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import com.example.kidswardrobe.services.KidsWardrobeService;
import org.springframework.web.bind.annotation.RequestParam;

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

        HashMap<String, Object> map = new HashMap<>();

        sql = createSqlForRiided(sql, map, filter);

        List<EsemeKuvaDto> vastus = JdbcTemplate.query(sql, map, new KidsWardrobeService.EsemeKuvaDtoRowMapper());
        return vastus;
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

        HashMap<String, Object> map = new HashMap<>();

        sql = createSqlForJalatsid(sql, map, filter);

        List<EsemeKuvaDto> vastus = JdbcTemplate.query(sql, map, new KidsWardrobeService.EsemeKuvaDtoRowMapper());
        return vastus;
    }

    public String createSqlForRiided(String sql, HashMap<String, Object> paramMap, EsemeFilterDto filter) {
        sql = createSqlFromFilter(sql, paramMap, filter);
        if (filter.getSuurusRiided() != null ) {
            sql = sql + " AND suurus_riided_id = :suurusRiidedId ";
            paramMap.put("suurusRiidedId", filter.getSuurusRiided());
        }

        return sql;
    }

    public String createSqlForJalatsid(String sql, HashMap<String, Object> paramMap, EsemeFilterDto filter) {
        sql = createSqlFromFilter(sql, paramMap, filter);
        if (filter.getSuurusJalatsid() != null ) {
            sql = sql + " AND suurus_jalatsid_id = :suurusJalatsidId ";
            paramMap.put("suurusJalatsidId", filter.getSuurusJalatsid());
        }

        return sql;
    }

    public String createSqlFromFilter(String sql, HashMap<String, Object> paramMap, EsemeFilterDto filter) {
        if (filter.getHooaeg() != null) {
            sql = sql + " AND hooaeg_id = :hooaegId";
            paramMap.put("hooaegId", filter.getHooaeg());
        }
        if (filter.getKategooria() != null) {
            sql = sql + " AND kategooria_id = :kategooriaId";
            paramMap.put("kategooriaId", filter.getKategooria());
        }
        if (filter.getAsukoht() != null) {
            sql = sql + " AND asukoht_id = :asukohtId";
            paramMap.put("asukohtId", filter.getAsukoht());
        }
        if (filter.getSugu() != null) {
            sql = sql + " AND sugu_id = :suguId";
            paramMap.put("suguId", filter.getSugu());
        }
        if (filter.getMaterjal() != null) {
            sql = sql + " AND materjal_id = :materjalId";
            paramMap.put("materjalId", filter.getMaterjal());
        }
        if (filter.getTyyp() != null ) {
            sql = sql + " AND tüüp_id = :tyypId";
            paramMap.put("tyypId", filter.getTyyp());
        }
        if (filter.getVarv() != null ) {
            sql = sql + " AND värv_id = :varvId";
            paramMap.put("varvId", filter.getVarv());
        }

        return sql;
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

    public void kustutaEse(KustutaEseDto kustutaEseDto) {


        if (kustutaEseDto.getRiidedId() != null) {
            String sql = "DELETE FROM riideese WHERE id = :riidedId";
            Map<String, Object> paramMap = new HashMap<>();
            paramMap.put("riidedId", kustutaEseDto.getRiidedId());
            JdbcTemplate.update(sql, new MapSqlParameterSource(paramMap));
        }
        if (kustutaEseDto.getJalatsidId() != null) {
            String sql = "DELETE FROM jalatsid WHERE id = :jalatsidId";
            Map<String, Object> paramMap = new HashMap<>();
            paramMap.put("jalatsidId", kustutaEseDto.getJalatsidId());
            JdbcTemplate.update(sql, new MapSqlParameterSource(paramMap));
        }
    }
}
