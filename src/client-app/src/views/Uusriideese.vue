<template>
  <div class="body">
    <label>Tüüp</label>
    <select v-model="tyyp">
      <option value="0"></option>
      <option value="1">Õueriided</option>
      <option value="2">Riided</option>
      <option value="3">Aksessuaarid</option>
      <option value="5">Spordiriided</option>
    </select>
    <br>
    <br>
    <label>Kategooria</label>
    <select v-model="kategooria">
      <option value="0"></option>
      <option value="1">Lühikese varrukaga särgid</option>
      <option value="2">Pika varrukaga särgid</option>
      <option value="3">Lühikesed püksid</option>
      <option value="4">Pikad püksid</option>
      <option value="5">Aluspesu</option>
      <option value="6">Sokid</option>
      <option value="7">Sukapüksid</option>
      <option value="8">Kindad</option>
      <option value="9">Mütsid</option>
      <option value="10">Sallid</option>
      <option value="11">Joped</option>
      <option value="12">Kombekad</option>
      <option value="13">Õuepüksid</option>
      <option value="14">Seelikud</option>
      <option value="15">Kleidid</option>
      <option value="16">Romperid</option>
      <option value="17">Tuduriided</option>
      <option value="18">Bodyd</option>
      <option value="19">Sipukad</option>
      <option value="20">Ujumisriided</option>
      <option value="21">Pusad</option>
      <option value="22">Muu</option>
    </select>
    <br>
    <br>
    <label>Suurus</label>
    <select name="suurus" id="suurus">
      <option value="0"></option>
      <option value="1">56-62</option>
      <option value="2">62-68</option>
      <option value="3">68-74</option>
      <option value="4">74-80</option>
      <option value="5">80-86</option>
      <option value="6">86-92</option>
      <option value="7">92-98</option>
      <option value="8">98-104</option>
      <option value="9">104-110</option>
      <option value="10">110-116</option>
      <option value="11">116-122</option>
      <option value="12">122-128</option>
      <option value="13">128-134</option>
      <option value="14">134-140</option>
      <option value="15">140-146</option>
      <option value="16">146-152</option>
      <option value="17">152-158</option>
      <option value="18">158-164</option>
      <option value="19">164-170</option>
    </select>
    <br>
    <br>
    <label>Hooaeg</label>
    <select name="hooaeg" id="hooaeg">
      <option value="0"></option>
      <option value="1">Suvi</option>
      <option value="2">Kevad/sügis</option>
      <option value="3">Talv</option>
      <option value="4">Aastaringne</option>
    </select>
    <br>
    <br>
    <label>Värv</label>
    <select name="värv" id="värv">
      <option value="0"></option>
      <option value="1">Kollane</option>
      <option value="2">Oranz</option>
      <option value="3">Punane</option>
      <option value="4">Lilla</option>
      <option value="5">Sinine</option>
      <option value="6">Roheline</option>
      <option value="7">Must</option>
      <option value="8">Valge</option>
      <option value="9">Hall</option>
      <option value="10">Beez</option>
      <option value="11">Mitmevärviline</option>
    </select>
    <br>
    <br>
    <label>Sugu</label>
    <select name="sugu" id="sugu">
      <option value="0"></option>
      <option value="1">Poiss</option>
      <option value="2">Tüdruk</option>
      <option value="3">Unisex</option>
    </select>
    <br>
    <br>
    <label>Materjal</label>
    <select name="materjal" id="materjal">
      <option value="0"></option>
      <option value="1">puuvill</option>
      <option value="2">vill</option>
      <option value="3">polüester</option>
      <option value="4">viskoos</option>
      <option value="5">linane</option>
      <option value="6">siid</option>
      <option value="7">teksa</option>
      <option value="8">elastaan</option>
      <option value="9">meriinovill</option>
    </select>
    <br>
    <br>
    <label>Asukoht</label>
    <input type="text"/>
    <br>
    <br>
    <label>Lisainfo</label>
    <input type="text"/>
    <br>
    <br>
    <label>Tootja</label>
    <input type="text"/>
    <br>
    <br>
    <label>Pilt</label>
    <input type="blob"/>
    <br>
    <br>
    <button v.on:click="salvesta()">Salvesta</button>

  </div>
</template>

<script>
export default {
  name: 'Uusriideese',
  data: function () {
    return {
      tyyp: [],
      hooaeg: [],
      riideSuurus: [],
      varv: [],
      sugu: [],
      materjal: [],
      asukoht: '',
      kategooria: [],
      lisainfo: '',
      tootja: '',
      /*pilt: ''*/
    }
  },
  methods: {
    /*salvesta:function() {
      this.$http.post("/riidekapp/lisaRiietusKappi")
          .then(response => {
            console.log(response.data);
            alert("Tehtud")
          }).catch(function(response) {
      }

    }*/
  }
}

</script>

