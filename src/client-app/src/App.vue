
<template>
  <div id="app" class="container">
  <Header/>
    <div id="nav">
      <router-link to="/"><i class="fa fa-home"></i>Avaleht</router-link> |
      <router-link to="/riidekapp">
<!--        <img src="scarf.svg">-->
        Riidekapp</router-link> |
      <router-link to="/filtreeri">Filtreeri</router-link> |
      <router-link to="/otsi">
        <input class="form-control mr-sm-2" type="search" placeholder="Otsi" aria-label="Otsi">
          <button>Otsi</button>
      </router-link> |
      <router-link to="/peamenuu"><i class="fa fa-bars"></i></router-link>
    </div><router-view/>

      </div>
</template>

<script>
import Header from './components/layout/Header';

export default  {
  name: 'app',
  components: {
    Header,

  }
}
</script>

<style>
@import './assets/styles.css';

</style>