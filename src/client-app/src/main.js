import Vue from 'vue'
import App from './App.vue'
import router from './router'
import axios from 'axios'
import VueAxios from 'vue-axios'
/* import vuetify from 'vuetify' */

/*import "bootstrap";
import "bootstrap/dist/css/bootstrap.css";*/
//
// import AtComponents from 'at-ui'
// import 'at-ui-style'
//
//
// Vue.use(AtComponents)

//import SvgIcon from "@/assets"
//Vue.component('svg-icon', SvgIcon)



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
