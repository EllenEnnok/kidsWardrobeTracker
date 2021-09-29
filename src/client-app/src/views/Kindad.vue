<template>
  <div class="kindad">
    <label>Sul on kapis</label>

    <div class="esemeKuva" v-for="ese in kategooria" :key="ese.id">

      <img v-if="ese.pilt" :src="getImageSource(ese)" alt="pilt"/>
      <h1>{{ ese.kategooria }}</h1>
      <h1>Suurus: {{ ese.suurus }}</h1>

      <!--
            <button @click="uuendaKapp" v-on:click="kustutaEse(ese.id)">Kustuta ese</button>
      -->

    </div>
  </div>

</template>


<script>

export default {

  data: function () {
    return {
      kategooria: ''
    }
  },
  mounted() {
    this.$http.get("/riidekapp/kuvaKoguKapp?kategooriaId=8")
        .then(response => {
          this.kategooria = response.data;
        }).catch(function (error) {
      console.log(error);
    })
  },
  methods: {
    getImageSource(ese) {
      return `data:image/png;base64, ${ese.pilt}`;
    }
  }
}
</script>