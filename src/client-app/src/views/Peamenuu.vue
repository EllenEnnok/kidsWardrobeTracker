<template>
  <div @click="toggle" v-on-clickaway="away">
    <slot name="toggler">
      <button>Toggler</button>
    </slot>
    <slot/>
<!--   /* dropdown menu */-->
<!--    <h3>minu asjad</h3>
    <br>
    <button v-on:click="logout">Logi välja</button>-->
  </div>

</template>
<script>

import  { mixin as clickaway } from "vue-clickaway";

export default {
  name: "Peamenüü",
  mixins: [ clickaway ],
  provide () {
    return {
      sharedState: this.sharedState
    }
  },
  data () {
    return {
      sharedState: {
        active: false
      }
    }
  },
  methods: {
    toggle () {
      this.sharedState.active = !this.sharedState.active
    },
    away () {
      this.sharedState.active = false
    }
  }

    /*logout: function () {
      this.$http.post("/peamenuu/logiValja")
      localStorage.removeItem('user-token') // remove on logout
      location.reload();*/
  }



</script>
<style scoped>



</style>