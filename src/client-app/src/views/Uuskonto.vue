<template>
  <div class="avaleht">

    <label>E-post</label>
    <input type="text" v-model="kasutajanimi"/>
    <br>
    <label>Salasõna</label>
    <input type="password" v-model="parool"/>
    <br>
    <button v-on:click="looKonto">Salvesta</button>

  </div>
</template>
<script>

export default {

  data: function () {
    return {
      kasutajanimi: '',
      parool: ''
    }
  },
  methods: {
    looKonto: function () {
      this.$http.post("/uuskonto/looKonto",
          {kasutajanimi: this.kasutajanimi, parool: this.parool})
          .then(response => {
            console.log(response);
            this.$router.push("/riidekapp");
          })
          .catch(function (error) {
            console.log(error);
          })
    }
  }
}
</script>


