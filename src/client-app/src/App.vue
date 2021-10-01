<template>
  <div id="app" class="container">
    <!--    <div class="container">-->
    <header>
      <nav>
        <ul>
          <li><router-link to="/">
            <img src="home.svg"> Avaleht
          </router-link></li>
          <li><router-link v-show="token" to="/riidekapp">
            <img src="hanger.svg">
             Riidekapp
          </router-link></li>
          <li><router-link v-show="token" to="/filtreeri"><img src="sort.svg"> Filtreeri</router-link></li>

          <li> <div v-show="token" class="search-wrapper">
            <form><input type="text" name="focus" required class="search-box" placeholder="Enter search term" />
              <button class="close-icon" type="reset"></button>
            </form></div></li><li>
            <div class="ui icon buttons" v-show="token" @click="toggle">
               <div id="menuNupp" class="ui top right pointing dropdown button">
                <i class="fa fa-bars" aria-hidden="true"></i>
                <div :class="menuClasses">
                  <div class="item"><i class="user icon"></i> Minu seaded</div>
                  <div class="item"><i class="question circle icon"></i> KKK</div>
                  <div class="item" v-on:click="logout"><i class="x icon"></i> Logi välja</div>
                </div>
              </div>
            </div>
          </li>
        </ul>
      </nav>

      <h6>Lapse riidekapp</h6>
    </header>
    <router-view/>
  </div>
</template>

<script>

export default {
  name: 'app',
  components: {
  },

  data () {
    return {
      active: false,
      token: ''
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
    },
    logout: function () {
      this.$http.post("/avaleht/logikonto")
      localStorage.removeItem('user-token') // remove on logout
      this.$router.push("/avaleht");
      location.reload();
    }
  },
  mounted() {
    this.token= localStorage.getItem('user-token')
  }
}
</script>

<style>
@import './assets/styles.css';

</style>