<template>
  <div class="avaleht">
    <div class="logi">
    <label>E-post</label>
    <input type="text" v-model="kasutajanimi"/>
    </div>
    <br>
  <div class="logi">
    <label>Salasõna</label>
    <input type="password" v-model="parool"/>
  </div>
    <br>
    <button v-on:click="login"><img src="">Logi sisse</button>

    <h5>Pole kontot?</h5>
    <GoTo title="Loo uus konto" link="/uuskonto"></GoTo>


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


    }
  }
}
</script>
<style scoped>

</style>


