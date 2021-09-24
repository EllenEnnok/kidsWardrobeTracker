<template>
  <div class="riided">
    <button>+</button>
    <label> Sisesta kappi uus riideese</label>
    <br>
    <br>
    <GoTo title="Lühikese varrukaga särgid" link="/luhikesevarrukagasargid"></GoTo>
    <GoTo title="Pika varrukaga särgid" link="/pikavarrukagasargid"></GoTo>
    <GoTo title="Lühikesed püksid" link="/luhikesedpuksid"></GoTo>
    <br>
    <br>
    <GoTo title="Pikad püksid" link="/pikadpuksid"></GoTo>
    <GoTo title="Aluspesu" link="/aluspesu"></GoTo>
    <GoTo title="Sokid" link="/sokid"></GoTo>
    <br>
    <br>
    <GoTo title="Sukapüksid" link="/sukapuksid"></GoTo>
    <GoTo title="Seelikud" link="/seelikud"></GoTo>
    <GoTo title="Kleidid" link="/kleidid"></GoTo>
    <br>
    <br>
    <GoTo title="Romperid" link="/romperid"></GoTo>
    <GoTo title="Tuduriided" link="/tuduriided"></GoTo>
    <GoTo title="Bodyd" link="/bodyd"></GoTo>
    <br>
    <br>
    <GoTo title="Sipukad" link="/sipukad"></GoTo>
    <GoTo title="Ujumisriided" link="/ujumisriided"></GoTo>
    <GoTo title="Pusad" link="/pusad"></GoTo>
    <br>
    <br>
    <GoTo title="Muu" link="/muu"></GoTo>
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
