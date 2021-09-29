<template>
  <div class="spordiriided">
    <GoTo title="+" link="/uusese"></GoTo>
    <label> Sisesta kappi uus ese</label>
    <br>
    <br>
    <goTo title="Lühikese varrukaga särgid" link="/kapisisulist"></goTo>
    <goTo title="Pika varrukaga särgid" link="/kapisisulist"></goTo>
    <goTo title="Lühikesed püksid" link="/kapisisulist"></goTo>
    <br>
    <br>
    <goTo title="Pikad püksid" link="/kapisisulist"></goTo>
    <goTo title="Ujumisriided" link="/kapisisulist"></goTo>
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