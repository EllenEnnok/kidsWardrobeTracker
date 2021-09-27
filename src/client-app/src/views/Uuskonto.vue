<template>
  <div class="avaleht">

        <label>E-post</label>
        <input type="text" v-model="email"/>
        <br>
        <label>Salasõna</label>
        <input type="password" v-model="password"/>
        <br>
        <button v-on:click="salvesta()">Salvesta</button>

  </div>
</template>
<script>
export default {
  name: 'uuskonto',
  data: function () {
    return {
      email
    }
  }

}
</script>

