<template>
  <div class="aksessuaarid">
    <GoTo title="+" link="/uusriideese"></GoTo>
    <label> Sisesta kappi uus riideese</label>
    <br>
    <br>
    <GoTo title="+" link="/uusjalanou"></GoTo>
    <label> Sisesta kappi uus jalanõu</label>
    <h1>Vali kategooria</h1>
    <br>
    <br>

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