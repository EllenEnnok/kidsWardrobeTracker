<template>

  <div class="riidekapp">
    <div class="kategooriaKuva">
      <img src="tshirts.jpg"/>
      <br>
    <GoTo title="+ Sisesta kappi uus ese" link="/uusese"></GoTo>
</div>
    <br>
    <br>

    <br>
    <div class="kategooriaKuva">
      <img src="tshirts.jpg"/>
      <br>
    <GoTo title="Näita kõike" link="/kogukapp"></GoTo>
      </div>
    <br>
    <br>
    <div class="kategooriaKuva">
      <img src="tshirts.jpg"/>
      <br>
    <GoTo title="Õueriided"  link="/oueriided"></GoTo>
      </div>
    <div class="kategooriaKuva">
      <img src="tshirts.jpg"/>
      <br>
    <GoTo title="Riided" link="/riided"></GoTo>
      </div>
    <div class="kategooriaKuva">
      <img src="tshirts.jpg"/>
      <br>
    <GoTo title="Aksessuaarid" link="/aksessuaarid"></GoTo>
      </div>
    <div class="kategooriaKuva">
      <img src="tshirts.jpg"/>
      <br>
    <GoTo title="Jalanõud" link="/kapisisulist" page-id="24"></GoTo>
      </div>
    <div class="kategooriaKuva">
      <img src="tshirts.jpg"/>
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