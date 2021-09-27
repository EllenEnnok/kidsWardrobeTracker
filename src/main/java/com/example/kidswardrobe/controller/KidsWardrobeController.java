package com.example.kidswardrobe.controller;

import com.example.kidswardrobe.dto.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.kidswardrobe.services.KidsWardrobeService;

import java.util.List;

@RestController
public class KidsWardrobeController {
    @Autowired
    private KidsWardrobeService kidsWardrobeService;

    @GetMapping("/riidekapp/kuvaKoguKapp")   // ilma filtrita kuvab kogu kapi sisu (id, suurus, kategooria, pilt) filtreerimise voimalus tuleb vastava tabeli id j2rgi (hooaeg, varv, sugu jne)
    public List<EsemeKuvaDto> kuvaKoguKapp(
            @RequestParam(required = false) Integer hooaegId,
            @RequestParam(required = false) Integer kategooriaId,
            @RequestParam(required = false) Integer asukohtId,
            @RequestParam(required = false) Integer materjalId,
            @RequestParam(required = false) Integer suguId,
            @RequestParam(required = false) Integer suurusJalatsidId,
            @RequestParam(required = false) Integer suurusRiidedId,
            @RequestParam(required = false) Integer tyypId,
            @RequestParam(required = false) Integer varvId
    ) {
        EsemeFilterDto filter = new EsemeFilterDto();
        filter.setHooaegId(hooaegId);
        filter.setKategooriaId(kategooriaId);
        filter.setAsukohtId(asukohtId);
        filter.setMaterjalId(materjalId);
        filter.setSuguId(suguId);
        filter.setSuurusJalatsidId(suurusJalatsidId);
        filter.setSuurusRiidedId(suurusRiidedId);
        filter.setTyypId(tyypId);
        filter.setVarvId(varvId);

       return kidsWardrobeService.kuvaKoguKapp(filter);
    }


    @PostMapping("/riidekapp/lisaEseKappi")
    public void lisaEseKappi(@RequestBody LisaEseDto lisaEseDto) {
        kidsWardrobeService.lisaEseKappi(lisaEseDto);

    }
    @PostMapping ("/avaleht/logiSisse")
    public String logiSisse(@RequestBody LoginDto loginDto) {
        return kidsWardrobeService.logiSisse(loginDto);
    }

    @PostMapping("/uuskonto/looKonto")
    public void looKonto(@RequestBody LoginDto loginDto) {
        kidsWardrobeService.looKonto(loginDto);
    }



    @DeleteMapping("/riidekapp/kustutaEse")
    public void kustutaEse(@RequestParam Integer esemeId) {
        KustutaEseDto kustutaEseDto = new KustutaEseDto();
        kustutaEseDto.setEsemeId(esemeId);
        kidsWardrobeService.kustutaEse(kustutaEseDto);
    }

    @PostMapping("/riidekapp/lisaAsukoht")
    public void lisaAsukoht(@RequestBody LisaAsukohtDto lisaAsukohtDto) {
        kidsWardrobeService.lisaAsukoht(lisaAsukohtDto);
    }

    @GetMapping("/riidekapp/kuvaEsemeDetailid")
    public EsemeDetailidDto kuvaEsemeDetailid(@RequestParam Integer esemeId){
        return kidsWardrobeService.kuvaEsemeDetailid(esemeId);
    }

    @GetMapping("/riidekapp/annaKoikFiltrid")
    public FiltridDto annaKoikFiltrid() {
        return kidsWardrobeService.annaKoikFiltrid();
    }






}

