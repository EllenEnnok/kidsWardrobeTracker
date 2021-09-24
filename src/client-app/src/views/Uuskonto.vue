<template>
  <div class="avaleht">

        <label>E-post</label>
        <input type="text" v-model="email"/>
        <br>
        <label>Salasõna</label>
        <input type="password" v-model="password"/>
        <br>
        <button v-on:click="register()">Salvesta</button>

  </div>
</template>

