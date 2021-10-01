<template>
  <div class="oueriided">
    <GoTo title="+ Sisesta kappi uus ese" link="/uusese"></GoTo>

    <br>
    <br>

      <GoTo title="Joped" link="/kapisisulist" page-id="11"></GoTo>
    <GoTo title="Kombekad" link="/kapisisulist" page-id="12"></GoTo>
    <GoTo title="Õuepüksid" link="/kapisisulist" page-id="13"></GoTo>

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
