import Vue from 'vue'
import VueRouter from 'vue-router'
import Home from '../views/Home.vue'
import Kategooriad from '../views/Kategooriad.vue'
import Avaleht from '../views/Avaleht.vue'


Vue.use(VueRouter)

const routes = [

  {
    path: '/',
    name: 'Home',
    component: Home
  },
  {
    path: '/avaleht',
    name: 'Avaleht',
    component: Home
  },
  {
    path: '/kategooriad',
    name: 'Kategooriad',
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: Kategooriad
  }

]

const router = new VueRouter({
  routes
})

export default router
