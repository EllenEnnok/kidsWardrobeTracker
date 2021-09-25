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
        filter.setHooaeg(hooaegId);
        filter.setKategooria(kategooriaId);
        filter.setAsukoht(asukohtId);
        filter.setMaterjal(materjalId);
        filter.setSugu(suguId);
        filter.setSuurusJalatsid(suurusJalatsidId);
        filter.setSuurusRiided(suurusRiidedId);
        filter.setTyyp(tyypId);
        filter.setVarv(varvId);

       return kidsWardrobeService.kuvaKoguKapp(filter);
    }

    @GetMapping("/riidekapp/kuvaKoikRiided")        //kuvab koik riideesemed (id, suurus, kategooria, pilt)
    public List<EsemeKuvaDto> kuvariided() {
        return kidsWardrobeService.kuvariided(new EsemeFilterDto());
    }

    @GetMapping("/riidekapp/kuvaKoikJalatsid")      //kuvab k6ik jalatsid (id, suurus, kategooria, pilt)
    public List<EsemeKuvaDto> kuvaJalatsid() {
        return kidsWardrobeService.kuvaJalatsid(new EsemeFilterDto());
    }

    @PostMapping("/riidekapp/lisaRiietusKappi")     // lisab riietuse riideeseme tabelisse (vali 1 v mitu sisendit, id on autoincr.)
    public void lisaRiietusKappi(@RequestBody LisaRiietusDto lisaRiietusDto) {
        kidsWardrobeService.lisaRiietusKappi(lisaRiietusDto);
    }
    @PostMapping("/riidekapp/lisaJalatsidKappi")    // lisab jalatsi jalatsi tabelisse (vali 1 v mitu sisendit, id on autoincr.)
    public void lisaJalatsidKappi(@RequestBody LisaJalatsDto lisaJalatsDto) {
        kidsWardrobeService.lisaJalatsidKappi(lisaJalatsDto);
    }

    @GetMapping("/riidekapp/logiSisse")
    public String logiSisse(@RequestBody LoginDto loginDto) {
        return kidsWardrobeService.logiSisse(loginDto);
    }

    @PostMapping("/riidekapp/looKonto")
    public void looKonto(@RequestBody LoginDto loginDto) {
        kidsWardrobeService.looKonto(loginDto);
    }


    @DeleteMapping("/riidekapp/kustutaEse")
    public void kustutaEse(@RequestParam(required = false) Integer jalatsidId,
                           @RequestParam(required = false) Integer riidedId) {
        KustutaEseDto kustutaEseDto = new KustutaEseDto();
        kustutaEseDto.setJalatsidId(jalatsidId);
        kustutaEseDto.setRiidedId(riidedId);
        kidsWardrobeService.kustutaEse(kustutaEseDto);
    }



}

