import Vue from 'vue'
import App from './App.vue'
import router from './router'
import axios from 'axios'
import VueAxios from 'vue-axios'
/* import vuetify from 'vuetify' */


const token = localStorage.getItem('user-token')
    if (token) {
    axios.defaults.headers.common['Authorization']="Bearer "+ token
}

Vue.use(VueAxios, axios)

Vue.config.productionTip = false

new Vue({
  // vuetify,
  router,
  render: h => h(App),
}).$mount('#app')
