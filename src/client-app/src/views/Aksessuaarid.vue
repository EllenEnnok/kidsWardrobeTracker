<template>
  <div class="aksessuaarid">
    <GoTo title="+ Sisesta kappi uus ese " link="/uusese"></GoTo>

    <br>
    <br>
    <GoTo title="Kindad" link="/kapisisulist" page-id="8"></GoTo>
    <GoTo title="Mütsid" link="/kapisisulist" page-id="9"></GoTo>
    <GoTo title="Sallid" link="/kapisisulist" page-id="10"></GoTo>
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
