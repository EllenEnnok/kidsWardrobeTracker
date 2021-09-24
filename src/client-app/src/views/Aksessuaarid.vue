<template>
  <div class="aksessuaarid">
    <button>+</button>
    <label> Sisesta kappi uus riideese</label>
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