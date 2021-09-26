
<template>
  <div id="app" class="container">
    <Header/>
    <div id="nav">
      <router-link to="/">Avaleht</router-link> |
      <router-link to="/riidekapp">Riidekapp</router-link> |
      <router-link to="/filtreeri">Filtreeri</router-link> |
      <router-link to="/otsi">
        <input class="form-control mr-sm-2" type="search" placeholder="Otsi" aria-label="Otsi">
        <button class="btn btn-outline-success my-2 my-sm-0" type="submit">
          <button><span class="magnifying-glass.svg"></span></button>
        </button>
      </router-link>
    </div>
    <router-view/>
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