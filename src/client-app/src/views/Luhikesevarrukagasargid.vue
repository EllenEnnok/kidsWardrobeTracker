<template>
  <div class="lühikesevarrukagasärgid">
    <GoTo title="+" link="/uusriideese"></GoTo>
    <label> Sisesta kappi uus särk</label>
<!--    kuvab listi kõikidest lühikesevarrukaga särkidest-->
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