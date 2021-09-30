<template>

  <div id="app" class="container">
  <Header/>
    <div id="nav">
      <router-link to="/"><i class="fa fa-home"></i>Avaleht</router-link> |
      <router-link v-if="token" to="/riidekapp"><i class="flaticon-baby-body"></i>Riidekapp</router-link> |
      <router-link v-if="token" to="/filtreeri">Filtreeri</router-link> |
      <router-link v-if="token" to="/otsi">
        <input class="form-control mr-sm-2" type="search" placeholder="Otsi" aria-label="Otsi">
          <button>Otsi</button>
      </router-link> |
      <router-link><i class="fa fa-bars"></i>
        <option>Logi välja</option>
      </router-link>

    </div><router-view/>
=======
  <div class="app">
<!--    <div class="container">-->
      <Header></Header>
      <div class="nav">
        <router-link to="/">
          <img src="home.svg">Avaleht
        </router-link>
        |
        <router-link to="/riidekapp">
          <img src="public/wardrobe.svg">
          Riidekapp
        </router-link>
        |
        <router-link to="/filtreeri"><img src="public/magnifying-glass.svg">Filtreeri</router-link>
        |
        <router-link to="/otsi">
          <input class="form-control mr-sm-2" type="search" placeholder="Otsi" aria-label="Otsi">
          <button><img src="public/magnifying-glass-1.svg">Otsi</button>
        </router-link>
        |
        <router-link to="/peamenuu"><i class="fa fa-bars"></i></router-link>


        <router-view/>
      </div>
<!--    </div>-->
  </div>
</template>
<script>
import Header from './components/layout/Header';

export default {
  name: 'app',
  components: {
    Header,
  }
}

</script>

<style>
@import './assets/styles.css';

</style>
