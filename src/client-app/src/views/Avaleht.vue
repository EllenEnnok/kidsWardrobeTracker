<template>

  <div class="avaleht">
    <label>E-post</label>
    <input type="text" v-model="kasutajanimi"/>
    <br>
    <label>Salasõna</label>
    <input type="password" v-model="parool"/>
    <br>
    <button v-on:click="login">Logi sisse</button>

    <h1>Pole kontot?</h1>
    <GoTo title="Loo uus konto" link="/uuskonto"></GoTo>

    <button v-on:click="logout">Logi välja</button>
  </div>
</template>

<script>
import GoTo from '../components/GoTo.vue'
export default {
  components: {
    GoTo
  },
  data: function () {
    return {
      kasutajanimi: '',
      parool: ''
    }
  },
  methods: {
    login: function () {
      this.$http.post("/avaleht/logiSisse",
          {kasutajanimi: this.kasutajanimi, parool: this.parool})
          .then(response => {
            let token = response.data

            localStorage.setItem('user-token', token) // store the token
            this.$http.defaults.headers.common['Authorization'] = "Bearer " + token
            console.log(response);
            this.$router.push("/riidekapp");
            location.reload();
          })
          .catch(function (error) {
            console.log(error);
          })


    },
    logout: function () {
      this.$http.post("/avaleht/logikonto")
      localStorage.removeItem('user-token') // remove on logout
      location.reload();
    }
  }
}
</script>
<style scoped>

</style>


