package com.example.kidswardrobe.repositories;

import com.example.kidswardrobe.dto.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import com.example.kidswardrobe.services.KidsWardrobeService;

import java.io.IOException;
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

    public List<EsemeKuvaDto> kuvaRiided(EsemeFilterDto filter) {
        String sql = "SELECT " +
                "esemed.id as id," +
                "COALESCE(suurus_riided.suuruse_vahemik, cast(suurus_jalatsid.suurus as varchar)) as suurus," +
                "kategooria," +
                "pilt" +
                " FROM esemed " +
                "LEFT JOIN suurus_riided ON esemed.suurus_riided_id = suurus_riided.id " +
                "LEFT JOIN suurus_jalatsid ON esemed.suurus_jalatsid_id = suurus_jalatsid.id " +
                "LEFT JOIN kategooria ON esemed.kategooria_id = kategooria.id "+
                "WHERE 1 = 1 ";


        HashMap<String, Object> paramMap = new HashMap<>();

        sql = createSqlFromFilter(sql, paramMap, filter);

        List<EsemeKuvaDto> vastus = JdbcTemplate.query(sql, paramMap, new KidsWardrobeService.EsemeKuvaDtoRowMapper());
        return vastus;
    }


    public String createSqlFromFilter(String sql, HashMap<String, Object> paramMap, EsemeFilterDto filter) {
        if (filter.getHooaegId() != null) {
            sql = sql + " AND hooaeg_id = :hooaegId";
            paramMap.put("hooaegId", filter.getHooaegId());
        }
        if (filter.getKategooriaId() != null) {
            sql = sql + " AND kategooria_id = :kategooriaId";
            paramMap.put("kategooriaId", filter.getKategooriaId());
        }
        if (filter.getAsukohtId() != null) {
            sql = sql + " AND asukoht_id = :asukohtId";
            paramMap.put("asukohtId", filter.getAsukohtId());
        }
        if (filter.getSuguId() != null) {
            sql = sql + " AND sugu_id = :suguId";
            paramMap.put("suguId", filter.getSuguId());
        }
        if (filter.getMaterjalId() != null) {
            sql = sql + " AND materjal_id = :materjalId";
            paramMap.put("materjalId", filter.getMaterjalId());
        }
        if (filter.getTyypId() != null ) {
            sql = sql + " AND tüüp_id = :tyypId";
            paramMap.put("tyypId", filter.getTyypId());
        }
        if (filter.getVarvId() != null ) {
            sql = sql + " AND värv_id = :varvId";
            paramMap.put("varvId", filter.getVarvId());
        }
        if (filter.getSuurusRiidedId() != null ) {
            sql = sql + " AND suurus_riided_id = :suurusRiidedId";
            paramMap.put("suurusRiidedId", filter.getSuurusRiidedId());
        }
        if (filter.getSuurusJalatsidId() != null ) {
            sql = sql + " AND suurus_jalatsid_id = :suurusJalatsidId";
            paramMap.put("suurusJalatsidId", filter.getSuurusJalatsidId());
        }

        return sql;
    }

    public void lisaEseKappi(LisaEseDto lisaEseDto) throws IOException {
        String sql = "INSERT INTO esemed (tüüp_id, hooaeg_id, suurus_riided_id, suurus_jalatsid_id, värv_id," +
                " sugu_id, materjal_id, kategooria_id, lisainfo, tootja, asukoht_id, pilt)" +
                " VALUES (:tyyp, :hooaeg, :riideSuurus, :jalatsiSuurus, :värv, :sugu, :materjal, :kategooria, :lisainfo, :tootja, :asukoht, :pilt)";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("tyyp", lisaEseDto.getTyyp());
        paramMap.put("hooaeg", lisaEseDto.getHooaeg());
        paramMap.put("riideSuurus", lisaEseDto.getRiideSuurus());
        paramMap.put("jalatsiSuurus", lisaEseDto.getJalatsiSuurus());
        paramMap.put("värv", lisaEseDto.getVarv());
        paramMap.put("sugu", lisaEseDto.getSugu());
        paramMap.put("materjal", lisaEseDto.getMaterjal());
        paramMap.put("kategooria", lisaEseDto.getKategooria());
        paramMap.put("lisainfo", lisaEseDto.getLisainfo());
        paramMap.put("tootja", lisaEseDto.getTootja());
        paramMap.put("asukoht", lisaEseDto.getAsukoht());
        paramMap.put("pilt", lisaEseDto.getPictureBytes());

        JdbcTemplate.update(sql, new MapSqlParameterSource(paramMap));

    }


    public void kustutaEse(KustutaEseDto kustutaEseDto) {

        String sql = "DELETE FROM esemed WHERE id = :esemeId";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("esemeId", kustutaEseDto.getEsemeId());
        JdbcTemplate.update(sql, new MapSqlParameterSource(paramMap));

    }

    public void lisaAsukoht(LisaAsukohtDto lisaAsukohtDto) {
        String sql = "INSERT INTO asukoht (asukoht)" +
                "VALUES (:asukoht) ";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("asukoht", lisaAsukohtDto.getAsukoht());
        JdbcTemplate.update(sql, new MapSqlParameterSource(paramMap));
    }

    public EsemeDetailidDto kuvaEsemeDetailid(Integer esemeId){
        String sql = "SELECT " +
                "esemed.id as id, "+
                " COALESCE(suurus_riided.suuruse_vahemik, cast(suurus_jalatsid.suurus as varchar)) as suurus," +
                " kategooria," +
                " tüüp.nimetus as tüüp," +
                " hooaeg," +
                " värv," +
                " sugu," +
                " materjal," +
                " asukoht," +
                " lisainfo," +
                " tootja," +
                " pilt" +
                " FROM esemed " +
                " LEFT JOIN suurus_riided ON esemed.suurus_riided_id = suurus_riided.id " +
                " LEFT JOIN suurus_jalatsid ON esemed.suurus_jalatsid_id = suurus_jalatsid.id " +
                " LEFT JOIN asukoht ON esemed.asukoht_id = asukoht.id " +
                " LEFT JOIN hooaeg ON esemed.hooaeg_id = hooaeg.id " +
                " LEFT JOIN materjal ON esemed.materjal_id = materjal.id " +
                " LEFT JOIN sugu ON esemed.sugu_id = sugu.id " +
                " LEFT JOIN tüüp ON esemed.tüüp_id = tüüp.id " +
                " LEFT JOIN värv ON esemed.värv_id = värv.id " +
                " LEFT JOIN kategooria ON esemed.kategooria_id = kategooria.id " +
                "WHERE esemed.id = :esemeId";


        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("esemeId", esemeId);
        EsemeDetailidDto vastus = JdbcTemplate.queryForObject(sql, paramMap, new KidsWardrobeService.EsemeDetailidRowMapper());
        return vastus;
    }

    public List<KlassifikaatorDto> annaKoikAsukohad(){
        String sql = "SELECT id, asukoht as nimetus FROM asukoht";
        List<KlassifikaatorDto> vastus = JdbcTemplate.query(sql, new KidsWardrobeService.KlassifikaatorDtoRowMapper());
        return vastus;
    }
    public List<KlassifikaatorDto> annaKoikHooajad(){
        String sql = "SELECT id, hooaeg as nimetus FROM hooaeg";
        List<KlassifikaatorDto> vastus = JdbcTemplate.query(sql, new KidsWardrobeService.KlassifikaatorDtoRowMapper());
        return vastus;
    }
    public List<KlassifikaatorDto> annaKoikKategooriad(){
        String sql = "SELECT id, kategooria as nimetus FROM kategooria";
        List<KlassifikaatorDto> vastus = JdbcTemplate.query(sql, new KidsWardrobeService.KlassifikaatorDtoRowMapper());
        return vastus;
    }
    public List<KlassifikaatorDto> annaKoikMaterjalid(){
        String sql = "SELECT id, materjal as nimetus FROM materjal";
        List<KlassifikaatorDto> vastus = JdbcTemplate.query(sql, new KidsWardrobeService.KlassifikaatorDtoRowMapper());
        return vastus;
    }
    public List<KlassifikaatorDto> annaKoikSugu(){
        String sql = "SELECT id, sugu as nimetus FROM sugu";
        List<KlassifikaatorDto> vastus = JdbcTemplate.query(sql, new KidsWardrobeService.KlassifikaatorDtoRowMapper());
        return vastus;
    }
    public List<KlassifikaatorDto> annaKoikJalatsiSuurused(){
        String sql = "SELECT id, suurus as nimetus FROM suurus_jalatsid";
        List<KlassifikaatorDto> vastus = JdbcTemplate.query(sql, new KidsWardrobeService.KlassifikaatorDtoRowMapper());
        return vastus;
    }
    public List<KlassifikaatorDto> annaKoikRiideSuurused(){
        String sql = "SELECT id, suuruse_vahemik as nimetus FROM suurus_riided";
        List<KlassifikaatorDto> vastus = JdbcTemplate.query(sql, new KidsWardrobeService.KlassifikaatorDtoRowMapper());
        return vastus;
    }
    public List<KlassifikaatorDto> annaKoikTyybid(){
        String sql = "SELECT id, nimetus FROM tüüp";
        List<KlassifikaatorDto> vastus = JdbcTemplate.query(sql, new KidsWardrobeService.KlassifikaatorDtoRowMapper());
        return vastus;
    }
    public List<KlassifikaatorDto> annaKoikVarvid(){
        String sql = "SELECT id, värv as nimetus FROM värv";
        List<KlassifikaatorDto> vastus = JdbcTemplate.query(sql, new KidsWardrobeService.KlassifikaatorDtoRowMapper());
        return vastus;
    }







}
