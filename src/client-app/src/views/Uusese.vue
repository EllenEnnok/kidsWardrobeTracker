<template>
  <div class="body">
    <label>Tüüp</label>
    <select v-model="uusEse.tyyp">
      <option :value="null">----</option>
      <option :key="tyyp.id" v-for="tyyp in klassifikaatorid.tyybid" :value="tyyp.id">{{ tyyp.nimetus }}</option>
    </select>
    <br>
    <br>
    <label>Kategooria</label>
    <select v-model="uusEse.kategooria">
      <option :value="null">----</option>
      <option :key="kategooria.id" v-for="kategooria in klassifikaatorid.kategooriad" :value="kategooria.id">
        {{ kategooria.nimetus }}
      </option>

    </select>
    <br>
    <br>
    <label>Riietuse suurus</label>
    <select v-model="uusEse.riideSuurus">
      <option :value="null">----</option>
      <option :key="suurusRiided.id" v-for="suurusRiided in klassifikaatorid.suurus_riided" :value="suurusRiided.id">
        {{ suurusRiided.nimetus }}
      </option>
    </select>
    <br>
    <br>
    <label>Jalatsi suurus</label>
    <select v-model="uusEse.jalatsiSuurus">
      <option :value="null">----</option>
      <option :key="suurusJalatsid.id" v-for="suurusJalatsid in klassifikaatorid.suurus_jalatsid"
              :value="suurusJalatsid.id">{{ suurusJalatsid.nimetus }}
      </option>
    </select>
    <br>
    <br>
    <label>Hooaeg</label>
    <select v-model="uusEse.hooaeg">
      <option :value="null">----</option>
      <option :key="hooaeg.id" v-for="hooaeg in klassifikaatorid.hooajad" :value="hooaeg.id">{{ hooaeg.nimetus }}
      </option>
    </select>
    <br>
    <br>
    <label>Värv</label>
    <select v-model="uusEse.varv">
      <option :value="null">----</option>
      <option :key="varv.id" v-for="varv in klassifikaatorid.varvid" :value="varv.id">{{ varv.nimetus }}</option>
    </select>
    <br>
    <br>
    <label>Sugu</label>
    <select v-model="uusEse.sugu">
      <option :value="null">----</option>
      <option :key="sugu.id" v-for="sugu in klassifikaatorid.sugu" :value="sugu.id">{{ sugu.nimetus }}</option>
    </select>
    <br>
    <br>
    <label>Materjal</label>
    <select v-model="uusEse.materjal">
      <option :value="null">----</option>
      <option :key="materjal.id" v-for="materjal in klassifikaatorid.materjalid" :value="materjal.id">
        {{ materjal.nimetus }}
      </option>
    </select>
    <br>
    <br>
    <label>Asukoht</label>
    <select v-model="uusEse.asukoht">
      <option :value="null">----</option>
      <option :key="asukoht.id" v-for="asukoht in klassifikaatorid.asukohad" :value="asukoht.id">{{ asukoht.nimetus }}
      </option>
    </select>
    <input placeholder="Lisa uus asukoht" v-model="Asukoht.asukoht">
    <button v-on:click="lisaAsukoht()">Lisa</button>
    <br>
    <br>
    <label>Lisainfo</label>
    <input v-model="uusEse.lisainfo" type="text"/>
    <br>
    <br>
    <label>Tootja</label>
    <input v-model="uusEse.tootja" type="text"/>
    <br>
    <br>


    <label>Pilt</label>
    <input type="file" @change="onFileSelected"/>

    <br>
    <br>
    <button @click="salvestaEse">Salvesta</button>

  </div>
</template>
<script>
export default {
  name: 'HelloWorld',
  data() {
    return {
      selectedFile: null,
      klassifikaatorid: {
        asukohad: [],
        materjalid: [],
        sugu: [],
        hooajad: [],
        kategooriad: [],
        suurus_jalatsid: [],
        suurus_riided: [],
        tyybid: [],
        varvid: []
      },
      esemed: [],
      Asukoht: {
        id: '',
        asukoht: ''
      },
      uusEse: {
        asukoht: null,
        materjal: null,
        sugu: null,
        hooaeg: null,
        kategooria: null,
        jalatsiSuurus: null,
        riideSuurus: null,
        tyyp: null,
        varv: null,
        lisainfo: null,
        tootja: null
      }
    }
  },
  methods: {

    lisaAsukoht: function () {
      this.$http.post("/riidekapp/lisaAsukoht", {
        id: '',
        asukoht: this.Asukoht.asukoht
      })
          .then(() => {
            this.uuendaKlassifikaatorid();
          })

    },

    onFileSelected(event) {
      this.selectedFile = event.target.files[0]
    },

    uuendaKlassifikaatorid: function () {
      this.$http.get('/riidekapp/annaKoikFiltrid').then((response) => {
        console.log(response.data)
        this.klassifikaatorid = response.data
      })
    },

    salvestaEse: function () {
      const formData = new FormData();
      Object.keys(this.uusEse).forEach(key => {
        if (this.uusEse[key]) {
          formData.append(key, this.uusEse[key]);
        }
      });
      formData.append("pilt", this.selectedFile);
      this.$http.post('/riidekapp/lisaEseKappi', formData);
      console.log(formData);
    }
  },
  created() {
    this.uuendaKlassifikaatorid();
  }
}
</script>

