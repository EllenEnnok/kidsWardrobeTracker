<template>
  <div class="kogulist">
    <label>Sul on kapis</label>
    <br>
    <br>

    <div class="esemeKuva" v-for="ese in kategooria" :key="ese.id">

      <img v-if="ese.pilt" :src="getImageSource(ese)" alt="pilt"/>
      <h1>{{ ese.kategooria }}</h1>
      <h1>Suurus: {{ ese.suurus }}</h1>
      <button v-on:click="kuvaDetailid(ese.id)">Kuva detailid</button>
      <button @click="uuendaKapp" v-on:click="kustutaEse(ese.id)">Kustuta ese</button>

    </div>
  </div>

</template>


<script>

export default {

  data: function () {
    return {
      kategooria: ''
      ,
      esemed: []
    }
  },
  mounted() {
    this.$http.get("/riidekapp/kuvaKoguKapp")
        .then(response => {
          this.kategooria = response.data;
        }).catch(function (error) {
      console.log(error);
    })
  },
  methods: {
    getImageSource(ese) {
      return `data:image/png;base64, ${ese.pilt}`;
    },
    kustutaEse(id) {
      this.$http.delete(this.ehitaKustutaEseUrl(id)).then(() => {
        this.uuendaKapp()
      })
    },
    uuendaKapp() {
      this.$http.get(this.ehitaFiltreerimisUrl()).then(response => {
            this.esemed = response.data;
            console.log(response);
          },
      )
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
    kuvaDetailid(id) {
      this.$http.get(this.ehitaEsemeDetailidUrl(id)).then(response => {
        console.log(response)
        window.alert(response.data);
      })
    }
  }
}
</script>
