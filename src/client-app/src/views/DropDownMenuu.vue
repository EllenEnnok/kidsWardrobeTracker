<template>
  <div id="app">
    <Peamenüü>
      <template slot="toggler">
        <button>Toggler</button>
      </template>
      <DropDownMenuu>
        <DropDownMenuuSisu>Logi välja</DropDownMenuuSisu>
        <DropDownMenuuSisu>Minu konto</DropDownMenuuSisu>
        <DropDownMenuuSisu>KKK</DropDownMenuuSisu>
      </DropDownMenuu>
    </Peamenüü>
  </div>
</template>

<script>
import Peamenüü from "@/views/Peamenuu";
import DropDownMenuuSisu from "@/views/DropDownMenuuSisu";

export default {
  name: "DropDownMenuu",
  components: {
    DropDownMenuuSisu,
    Peamenüü,

  }
}
</script>

<style scoped>

</style>