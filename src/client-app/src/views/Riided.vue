<template>
  <div class="riided">
    <GoTo title="+" link="/uusese"></GoTo>
    <label> Sisesta kappi uus ese</label>
    <br>
    <br>
    <GoTo title="Lühikese varrukaga särgid" link="/kapisisulist" page-id="1"></GoTo>
    <GoTo title="Pika varrukaga särgid" link="/kapisisulist" page-id="2"></GoTo>
    <GoTo title="Lühikesed püksid" link="/kapisisulist" page-id="3"></GoTo>
    <br>
    <br>
    <GoTo title="Pikad püksid" link="/kapisisulist" page-id="4"></GoTo>
    <GoTo title="Aluspesu" link="/kapisisulist" page-id="5"></GoTo>
    <GoTo title="Sokid" link="/kapisisulist" page-id="6"></GoTo>
    <br>
    <br>
    <GoTo title="Sukapüksid" link="/kapisisulist" page-id="7"></GoTo>
    <GoTo title="Seelikud" link="/kapisisulist" page-id="14"></GoTo>
    <GoTo title="Kleidid" link="/kapisisulist" page-id="15"></GoTo>
    <br>
    <br>
    <GoTo title="Romperid" link="/kapisisulist" page-id="16"></GoTo>
    <GoTo title="Tuduriided" link="/kapisisulist" page-id="17"></GoTo>
    <GoTo title="Bodyd" link="/kapisisulist" page-id="18"></GoTo>
    <br>
    <br>
    <GoTo title="Sipukad" link="/kapisisulist" page-id="19"></GoTo>
    <GoTo title="Ujumisriided" link="/kapisisulist" page-id="20"></GoTo>
    <GoTo title="Pusad" link="/kapisisulist" page-id="21"></GoTo>
    <br>
    <br>
    <GoTo title="Jalanõud" link="/kapisisulist" page-id="24"></GoTo>
    <GoTo title="Muu" link="/kapisisulist" page-id="22"></GoTo>
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
