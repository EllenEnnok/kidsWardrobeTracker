
<template>
  <div id="app" class="container">
  <Header/>
    <div id="nav">
      <router-link to="/"><i class="fa fa-home"></i>Avaleht</router-link> |
      <router-link to="/riidekapp"><i class="flaticon-baby-body"></i>Riidekapp</router-link> |
      <router-link to="/filtreeri">Filtreeri</router-link> |
      <router-link to="/otsi">
        <input class="form-control mr-sm-2" type="search" placeholder="Otsi" aria-label="Otsi">
          <button>Otsi</button>
      </router-link> |


      <div class="ui icon buttons" @click="toggle">
        <div id="menuNupp" class="ui top left pointing dropdown button">
          <i class="fa fa-bars" aria-hidden="true"></i>
          <div :class="menuClasses">
            <div class="item"><i class="user icon"></i> Minu seaded</div>
            <div class="item"><i class="question circle icon"></i> KKK</div>
            <div class="item"><i class="x icon"></i> Logi välja</div>
          </div>
        </div>
      </div>
    </div><router-view/>



  </div>
</template>

<script>
import Header from './components/layout/Header';

export default {
  name: 'app',
  components: {
    Header
  },

  data () {
    return {
      active: false
    }
  },
  computed: {
    menuClasses() {
      if (!this.active) {
        return "menu transition hidden";
      } else {
       return "menu transition visible"
      }
    }
  },
  methods: {
    toggle () {
      this.active = !this.active
    }
  }
}
</script>


<style>
@import './assets/styles.css';

</style>