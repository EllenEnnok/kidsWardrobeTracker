<template>
  <div class="oueriided">
    <GoTo title="+" link="/uusese"></GoTo>
    <label> Sisesta kappi uus ese</label>
    <br>
    <br>
    <div class="icons">
      <span class=".flaticon-jacket-1"></span>
      <GoTo title="Joped" link="/kapisisulist" page-id="11"></GoTo>
    </div>
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
