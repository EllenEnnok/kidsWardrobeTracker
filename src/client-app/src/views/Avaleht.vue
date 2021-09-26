<template>

  <div class="avaleht">
    <label>E-post</label>
    <input type="text" v-model="email"/>
    <br>
    <label>Salasõna</label>
    <input type="password" v-model="password"/>
    <br>
    <button v-on:click="login">Logi sisse</button>

    <h1>Pole kontot?</h1>
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
      password: "",
      email: ""
    }
  },
  methods: {
    login: function () {

      localStorage.setItem('user-token', token) // store the token
      let token;
      this.$http.defaults.headers.common['Authorization'] = "Bearer " + token
    }
  },
    logout: function () {

    localStorage.removeItem('user-token') // remove on logout
    location.reload();

  }

}

</script>


