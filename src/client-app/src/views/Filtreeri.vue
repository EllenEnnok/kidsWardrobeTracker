<template>
  <div>
  <div>

    <label>Tüüp</label>
    <select v-model="filter.tyypId" class="ui dropdown">
      <option :value="null">----</option>
      <option :key="tyyp.id" v-for="tyyp in klassifikaatorid.tyybid" :value="tyyp.id">{{ tyyp.nimetus }}</option>
    </select>
    <br>
    <br>

    <label>Kategooria</label>
    <select v-model="filter.kategooriaId" class="ui dropdown">
      <option :value="null">----</option>
      <option :key="kategooria.id" v-for="kategooria in klassifikaatorid.kategooriad" :value="kategooria.id">
        {{ kategooria.nimetus }}
      </option>
    </select>
    <br>
    <br>

    <label>Jalatsite suurus</label>
    <select v-model="filter.suurusJalatsidId" class="ui dropdown">
      <option :value="null">----</option>
      <option :key="suurusJalatsid.id" v-for="suurusJalatsid in klassifikaatorid.suurus_jalatsid"
              :value="suurusJalatsid.id">{{ suurusJalatsid.nimetus }}
      </option>

    </select>
    <br>
    <br>

    <label>Riiete suurus</label>
    <select v-model="filter.suurusRiidedId" class="ui dropdown">
      <option :value="null">----</option>
      <option :key="suurusRiided.id" v-for="suurusRiided in klassifikaatorid.suurus_riided" :value="suurusRiided.id">
        {{ suurusRiided.nimetus }}
      </option>

    </select>
    <br>
    <br>


    <label>Hooaeg</label>
    <select v-model="filter.hooaegId" class="ui dropdown">
      <option :value="null">----</option>
      <option :key="hooaeg.id" v-for="hooaeg in klassifikaatorid.hooajad" :value="hooaeg.id">{{ hooaeg.nimetus }}
      </option>

    </select>
    <br>
    <br>

    <label>Värv</label>
    <select v-model="filter.varvId" class="ui dropdown">
      <option :value="null">----</option>
      <option :key="varv.id" v-for="varv in klassifikaatorid.varvid" :value="varv.id">{{ varv.nimetus }}</option>
    </select>

    <br>
    <br>

    <label>Sugu</label>
    <select v-model="filter.suguId" class="ui dropdown">
      <option :value="null">----</option>
      <option :key="sugu.id" v-for="sugu in klassifikaatorid.sugu" :value="sugu.id">{{ sugu.nimetus }}</option>
    </select>
    <br>
    <br>

    <label>Materjal</label>

    <select v-model="filter.materjalId" class="ui dropdown">
      <option :value="null">----</option>
      <option :key="materjal.id" v-for="materjal in klassifikaatorid.materjalid" :value="materjal.id">
        {{ materjal.nimetus }}
      </option>
    </select>


    <br>
    <br>

    <label>Asukoht</label>
    <select v-model="filter.asukohtId" class="ui dropdown">
      <option :value="null">----</option>
      <option :key="asukoht.id" v-for="asukoht in klassifikaatorid.asukohad" :value="asukoht.id">{{ asukoht.nimetus }}
      </option>
    </select>

    <br>
    <br>

    <br>
    <button @click="uuendaKapp">Filtreeri</button>
    <br>
    <br>


    </div>

    <div v-show="!detailid" class="esemeKuva" v-for="ese in esemed" :key="ese.id">

      <img v-if="ese.pilt" :src="getImageSource(ese)" alt="pilt"/>
      <img v-else src="noimage.jpg"/>
      <h1>Kategooria: {{ ese.kategooria }}</h1>
      <h1>Suurus: {{ ese.suurus }}</h1>


      <button id="kuvaDetailidnupp" v-on:click="kuvaDetailid(ese)">Kuva detailid</button>
      <button id="kustutanupp" v-on:click="kustutaEse(ese.id)">Kustuta</button>


    </div>

    <DetailidModaal v-if="detailid" :detailid="detailid" v-on:close="sulgeDetailid" />
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
      },
      esemed: [],
      detailid: null,
      Asukoht: {
        id: '',
        asukoht: ''
      }
    }
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
        this.uuendaKapp()
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
