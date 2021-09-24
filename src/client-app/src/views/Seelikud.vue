<template>
  <div class="seelikud">
    <GoTo title="+" link="/uusriideese"></GoTo>
    <label> Sisesta kappi uus seelik</label>
<!--    kuvab listi seelikutest-->
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