<template>
  <div class="aksessuaarid">
    <GoTo title="+" link="/uusriideese"></GoTo>
    <label> Sisesta kappi uus aksessuaar</label>
    <br>
    <br>
    <GoTo title="Kindad" link="/kindad"></GoTo>
    <GoTo title="Mütsid" link="/mutsid"></GoTo>
    <GoTo title="Sallid" link="/sallid"></GoTo>
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