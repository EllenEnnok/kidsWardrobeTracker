<template>
  <div class="ui dimmer modals page transition visible active">
    <div class="ui standard test modal transition visible active">

      <div class="content">
        <div class="description">
          <div class="ui header">Eseme detailid</div>
          <h3>Asukoht: {{ detailid.asukoht }}</h3>
          <h3>Tüüp: {{ detailid.tyyp }}</h3>
          <h3>Hooaeg: {{ detailid.hooaeg }}</h3>
          <h3>Värv: {{ detailid.varv }}</h3>
          <h3>Sugu: {{ detailid.sugu }}</h3>
          <h3>Materjal: {{ detailid.materjal }}</h3>
          <h3>Lisainfo: {{ detailid.lisainfo }}</h3>
          <h3>Tootja: {{ detailid.tootja }}</h3>
          <h3>Jalatsi suurus: {{ detailid.suurusJalatsid }}</h3>
          <h3>Riide suurus: {{ detailid.suurusRiided }}</h3>
        </div>
      </div>
      <div class="actions">
        <div @click="close" class="ui black deny button">
          Sulge
        </div>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: "DetailidModaal",
  props: ['detailid'],
  methods: {
    close() {
      this.$emit('close');
    }
  }
}
</script>

<style scoped>

</style>