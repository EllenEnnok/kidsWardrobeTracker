<template>

  <div class="">
    </div>
</template>

<script>

export default {
  components: {
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


