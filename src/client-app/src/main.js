import Vue from 'vue'
import App from './App.vue'
import router from './router'
import axios from 'axios'
import VueAxios from 'vue-axios'

import "bootstrap";
import "bootstrap/dist/css/bootstrap.css";


Vue.use(VueAxios, axios)

Vue.config.productionTip = false

new Vue({
  router,
  render: h => h(App),
}).$mount('#app')
