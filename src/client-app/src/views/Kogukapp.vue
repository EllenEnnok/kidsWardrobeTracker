<template>
  <div class="kogukapp">
    <GoTo title="+ Sisesta kappi uus ese " link="/uusese"></GoTo>

    <br>
    <br>
    <h1>Vali kategooria</h1>
    <GoTo title="Näita kogu kapi sisu" link="/kogulist"></GoTo>
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
    <GoTo title="Kindad" link="/kapisisulist" page-id="8"></GoTo>
    <GoTo title="Mütsid" link="/kapisisulist" page-id="9"></GoTo>
    <br>
    <br>
    <GoTo title="Sallid" link="/kapisisulist" page-id="10"></GoTo>
    <GoTo title="Joped" link="/kapisiulist" page-id="11"></GoTo>
    <GoTo title="Kombekad" link="/kapisisulist" page-id="12"></GoTo>
    <br>
    <br>
    <GoTo title="Õuepüksid" link="/kapisisulist" page-id="13"></GoTo>
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
    <GoTo title="Muu" link="/kapisisulist" page-id="22"></GoTo>
    <GoTo title="Jalatsid" link="/kapisisulist" page-id="24"></GoTo>


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