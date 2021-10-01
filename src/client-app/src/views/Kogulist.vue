<template>
  <div class="kogulist">
    <div class="ui floating message"> Sul on kapis...</div>
    <br>
    <br>
    <div v-show="!detailid" class="esemeKuva" v-for="ese in kategooria" :key="ese.id">

      <img v-if="ese.pilt" :src="getImageSource(ese)" alt="pilt"/>
      <img v-else src="noimage.jpg"/>
      <h1>Kategooria: {{ ese.kategooria }}</h1>
      <h1>Suurus: {{ ese.suurus }}</h1>
      <button id="kuvaDetailidnupp" v-on:click="kuvaDetailid(ese)">Kuva detailid</button>
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

      detailid: null
    }
  },
  mounted() {
    this.uuendaKapp();
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
        this.$http.get("/riidekapp/kuvaKoguKapp")
            .then(response => {
              this.kategooria = response.data;
            }).catch(function (error) {
                console.log(error);
        })
      })
    },
    uuendaKapp() {
      this.$http.get("/riidekapp/kuvaKoguKapp")
          .then(response => {
            this.kategooria = response.data;
          }).catch(function (error) {
        console.log(error);
      });
    },
    getImageSource(ese) {
      return `data:image/png;base64, ${ese.pilt}`;
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
    sulgeDetailid() {
      this.detailid = null;
  
    }
  }
  
}
</script>
