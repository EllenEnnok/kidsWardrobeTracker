<template>
  <div class="spordiriided">
    <button>+</button>
    <label> Sisesta kappi uus riideese</label>
    <br>
    <br>
    <goTo title="Lühikese varrukaga särgid" link="/luhikesevarrukagasargid"></goTo>
    <goTo title="Pika varrukaga särgid" link="/pikavarrukagasargid"></goTo>
    <goTo title="Lühikesed püksid" link="/luhikesedpuksid"></goTo>
    <br>
    <br>
    <goTo title="Pikad püksid" link="/pikadpuksid"></goTo>
    <goTo title="Ujumisriided" link="/ujumisriided"></goTo>
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