<template>
  <div class="riidekapp">
    <GoTo title="+" link="/uusriideese"></GoTo>
    <label> Sisesta kappi uus riideese</label>
    <br>
    <br>
    <GoTo title="+" link="/uusjalanou"></GoTo>
    <label> Sisesta kappi uus jalanõu</label>
    <h1>Vali kategooria</h1>
    <br>
    <button>Näita kõike</button>
    <br>
    <br>
    <GoTo title="Õueriided" link="/oueriided"></GoTo>
    <GoTo title="Riided" link="/riided"></GoTo>
    <GoTo title="Aksessuaarid" link="/aksessuaarid"></GoTo>
    <GoTo title="Jalanõud" link="/jalanoud"></GoTo>
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