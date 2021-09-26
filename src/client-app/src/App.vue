
<template>
  <div id="app" class="container">
    <Header/>
    <div id="nav">
      <router-link to="/">Avaleht</router-link> |
      <router-link to="/riidekapp">Riidekapp</router-link> |
      <router-link to="/filtreeri">Filtreeri</router-link>
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