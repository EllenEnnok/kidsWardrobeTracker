<template>
  <div class="spordiriided">
    <GoTo title="+ Sisesta kappi uus ese " link="/uusese"></GoTo>
    <br>
    <br>
    <div>
    <goTo title="Lühikese varrukaga särgid" link="/kapisisulist" page-id="1">  </goTo>
    </div>
    <br>
    <goTo title="Pika varrukaga särgid" link="/kapisisulist" page-id="2"></goTo>
    <goTo title="Lühikesed püksid" link="/kapisisulist" page-id="3"></goTo>
    <br>
    <br>
    <goTo title="Pikad püksid" link="/kapisisulist" page-id="4"></goTo>
    <goTo title="Ujumisriided" link="/kapisisulist" page-id="20"></goTo>
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