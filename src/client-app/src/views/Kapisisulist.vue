<template>
  <div class="kapisiulist">
    <div class="ui floating message"> Sul on kapis...</div>
    <br>
    <br>

    <div v-show="!detailid" class="esemeKuva" v-for="ese in kategooria" :key="ese.id">


      <img v-if="ese.pilt" :src="getImageSource(ese)" alt="pilt"/>
      <img v-else src="noimage.jpg"/>
      <h1>Kategooria: {{ ese.kategooria }}</h1>
      <h1>Suurus: {{ ese.suurus }}</h1>
      <button v-on:click="kuvaDetailid(ese)">Kuva detailid</button>
      <button v-on:click="kustutaEse(ese.id)">Kustuta</button>


    </div>
    <DetailidModaal v-if="detailid" :detailid="detailid" v-on:close="sulgeDetailid"/>
  </div>

</template>


<script>
import DetailidModaal from "../components/DetailidModaal";


export default {
  components: {
    DetailidModaal
  },

  data: function () {
    return {
      kategooria: ''
      ,
      esemed: [],
      detailid: null,
      filter: {
        asukohtId: null,
        materjalId: null,
        suguId: null,
        hooaegId: null,
        kategooriaId: null,
        suurusJalatsidId: null,
        suurusRiidedId: null,
        tyypId: null,
        varvId: null
      },
      klassifikaatorid: {
        asukohad: [],
        materjalid: [],
        sugu: [],
        hooajad: [],
        kategooriad: [],
        suurusJalatsid: [],
        suurusRiided: [],
        tyybid: [],
        varvid: []
      }
    }
  },
  mounted() {
    let muutuja = this.$route.query.id
    this.$http.get("/riidekapp/kuvaKoguKapp?kategooriaId=" + muutuja)
        .then(response => {
          this.kategooria = response.data;
        }).catch(function (error) {
      console.log(error);
    })
  },
  methods: {
    kuvaDetailid(ese) {
      this.$http.get(this.ehitaEsemeDetailidUrl(ese.id)).then(response => {
        console.log(response.data)
        this.detailid = response.data;
      })
    },
    kustutaEse(id) {
      this.$http.delete(this.ehitaKustutaEseUrl(id)).then(() => {
        let muutuja = this.$route.query.id
        this.$http.get("/riidekapp/kuvaKoguKapp?kategooriaId=" + muutuja)
            .then(response => {
              this.kategooria = response.data;
            }).catch(function (error) {
          console.log(error);
        })
      })
    },
    sulgeDetailid() {
      this.detailid = null;
    },
    getImageSource(ese) {
      return `data:image/png;base64, ${ese.pilt}`;
    },

    uuendaKlassifikaatorid: function () {
      this.$http.get('/riidekapp/annaKoikFiltrid').then((response) => {
        console.log(response.data)
        this.klassifikaatorid = response.data
      });
    },
    ehitaEsemeDetailidUrl(id) {
      let baseUrl = '/riidekapp/kuvaEsemeDetailid?';
      if (id) {
        baseUrl += `&esemeId=${id}`;
      }
      return baseUrl;
    },
    ehitaKustutaEseUrl(id) {
      let baseUrl = '/riidekapp/kustutaEse?';
      if (id) {
        baseUrl += `&esemeId=${id}`;
      }
      return baseUrl;
    },
    ehitaFiltreerimisUrl() {
      let baseUrl = '/riidekapp/kuvaKoguKapp?';
      if (this.filter.asukohtId) {
        baseUrl += `&asukohtId=${this.filter.asukohtId}`;
      }
      if (this.filter.hooaegId) {
        baseUrl += `&hooaegId=${this.filter.hooaegId}`;
      }
      if (this.filter.kategooriaId) {
        baseUrl += `&kategooriaId=${this.filter.kategooriaId}`;
      }
      if (this.filter.materjalId) {
        baseUrl += `&materjalId=${this.filter.materjalId}`;
      }
      if (this.filter.suguId) {
        baseUrl += `&suguId=${this.filter.suguId}`;
      }
      if (this.filter.suurusJalatsidId) {
        baseUrl += `&suurusJalatsidId=${this.filter.suurusJalatsidId}`;
      }
      if (this.filter.suurusRiidedId) {
        baseUrl += `&suurusRiidedId=${this.filter.suurusRiidedId}`;
      }
      if (this.filter.tyypId) {
        baseUrl += `&tyypId=${this.filter.tyypId}`;
      }
      if (this.filter.varvId) {
        baseUrl += `&varvId=${this.filter.varvId}`;
      }
      return baseUrl;
    },

    uuendaKapp() {
      this.$http.get(this.ehitaFiltreerimisUrl()).then(response => {
            this.esemed = response.data;
            console.log(response);
          },
      )
    }
  }
  ,
  created() {
    this.uuendaKlassifikaatorid();
  }
}
</script>
