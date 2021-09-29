<template>
  <button v-on:click="goTo">{{ title }}</button>
</template>

<script>
export default {
  methods: {
    goTo() {
      return this.$router.push({path: this.link, query: {id: this.pageId}});
    }
  },
  props: ["title", "link", "pageId"]
}
</script>
<style scoped>

</style>