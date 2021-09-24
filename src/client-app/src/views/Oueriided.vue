<template>
  <div class="oueriided">
    <GoTo title="+" link="/uusriideese"></GoTo>
    <label> Sisesta kappi uus riideese</label>
    <br>
    <br>
    <GoTo title="Joped" link="/joped"></GoTo>
    <GoTo title="Kombekad" link="/kombekad"></GoTo>
    <GoTo title="Õuepüksid" link="/ouepuksid"></GoTo>

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
