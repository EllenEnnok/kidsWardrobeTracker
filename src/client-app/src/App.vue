
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
      <router-link v-if="token"><i class="fa fa-bars"></i>
        <option>Logi välja</option>
      </router-link>

    </div><router-view/>

  </div>
</template>

<script>
import Header from './components/layout/Header';

export default  {
  name: 'app',
  components: {
    Header,
  },
  data: function (){
    return {
      token: ''
    }
  },
  mounted() {
    this.token = localStorage.getItem('user-token');
  }
}
</script>

<style>
@import './assets/styles.css';

</style>