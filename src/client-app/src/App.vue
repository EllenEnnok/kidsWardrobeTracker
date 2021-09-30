<template>
  <div id="app" class="container">
    <!--    <div class="container">-->
    <header>
      <nav>
        <ul>
          <li><router-link to="/">
            <img src="home.svg">Avaleht
          </router-link></li>
          <li><router-link to="/riidekapp">
            <img src="wardrobe.svg">
            Riidekapp
          </router-link></li>
          <li><router-link to="/filtreeri"><img src="magnifying-glass.svg">Filtreeri</router-link></li>
          <li><input class="form-control mr-sm-2" type="search" placeholder="Otsi"
                     aria-label="Otsi"><img src="magnifying-glass.svg" alt="">
            <button><img src="magnifying-glass-1.svg">Otsi</button>
          </li>
          <li><router-link to="/peamenuu"><i class="fa fa-bars"></i></router-link></li>
        </ul>
      </nav>
      <h1>Lapse riidekapp</h1>
    </header>
        <router-view/>
  </div>
</template>
<script>

export default {
  name: 'app',
  components: {
  }
}

</script>

<style>
@import './assets/styles.css';

</style>
