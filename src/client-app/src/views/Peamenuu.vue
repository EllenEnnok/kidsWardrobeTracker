<template>
  <div class="menuu">
    <button v-on:click="logout">Logi välja</button>
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
    logout: function () {

      this.$http.post("/avaleht/logiVälja")
      localStorage.removeItem('user-token') // remove on logout
      location.reload();
    }
  }
}
</script>
<style scoped>
body {
  cursor: pointer;
  text-transform: capitalize;
  background-size: auto;
  background-color: #4ad295; /*ei kuva */
}
label {
  display: inline-block;
  width: 70px;
  margin-right: 30px;
  text-align: right;
  color: #2c3e50;
}


</style>