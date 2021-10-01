<template>

  <div class="riidekapp">
    <div class="kategooriaKuva">
      <img src="plus.svg"/>
      <br>
    <GoTo title="+ Sisesta kappi uus ese" link="/uusese"></GoTo>
</div>
    <br>
    <br>

    <br>
    <div class="kategooriaKuva">
      <img src="wardrobe(1).svg"/>
      <br>
    <GoTo title="Näita kõike" link="/kogukapp"></GoTo>
      </div>
    <br>
    <br>
    <div class="kategooriaKuva">
      <img src="jacket.svg"/>
      <br>
    <GoTo title="Õueriided"  link="/oueriided"></GoTo>
      </div>
    <div class="kategooriaKuva">
      <img src="pusa.svg"/>
      <br>
    <GoTo title="Riided" link="/riided"></GoTo>
      </div>
    <div class="kategooriaKuva">
      <img src="aksessuaarid.svg"/>
      <br>
    <GoTo title="Aksessuaarid" link="/aksessuaarid"></GoTo>
      </div>
    <div class="kategooriaKuva">
      <img src="jalanõud.svg"/>
      <br>
    <GoTo title="Jalanõud" link="/kapisisulist" page-id="24"></GoTo>
      </div>
    <div class="kategooriaKuva">
      <img src="sport.svg"/>
      <br>
    <GoTo title="Spordiriided" link="/spordiriided"></GoTo>
      </div>
  </div>
</template>
<script>
import GoTo from '../components/GoTo.vue'

export default {
  components: {
    GoTo
  }
}
</script>