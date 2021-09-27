<template>
  <button v-on:click="goTo">{{title}}</button>
</template>

<script>
export default {
  methods: {
    goTo() {
      return this.$router.push(this.link);
    }
  },
  props: ["title", "link"]
}
</script>
<style scoped>

</style>