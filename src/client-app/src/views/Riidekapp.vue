<template>
  <div class="riidekapp">
    <GoTo title="+ Sisesta kappi uus ese" link="/uusese"></GoTo>

    <br>
    <br>
    <h1>Vali kategooria</h1>
    <br>
    <GoTo title="Näita kõike" link="/kogukapp"></GoTo>
    <br>
    <br>
    <GoTo title="Õueriided"  link="/oueriided"></GoTo>
    <GoTo title="Riided" link="/riided"></GoTo>
    <GoTo title="Aksessuaarid" link="/aksessuaarid"></GoTo>
    <br>
    <br>
    <GoTo title="Jalanõud" link="/kapisisulist" page-id="24"></GoTo>
    <GoTo title="Spordiriided" link="/spordiriided"></GoTo>
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