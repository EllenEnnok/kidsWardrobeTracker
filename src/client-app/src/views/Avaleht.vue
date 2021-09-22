<template>
  <div class="avaleht">

        <label>E-post</label>
        <input type="text" v-model="email"/>
        <br>
        <label>Salasõna</label>
        <input type="password" v-model="password"/>
        <br>
        <button v-on:click="register()">Logi sisse</button>
        <h1>Pole kontot?</h1>
        <button>Loo uus konto</button>

  </div>
</template>

