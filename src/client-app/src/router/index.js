import Vue from 'vue'
import VueRouter from 'vue-router'
import Riidekapp from '../views/Riidekapp.vue'
import Avaleht from '../views/Avaleht.vue'
import Uuskonto from '../views/Uuskonto.vue'
import Kogukapp from '../views/Kogukapp.vue'
import Oueriided from '../views/Oueriided.vue'
import Aksessuaarid from '../views/Aksessuaarid.vue'
import Riided from '../views/Riided.vue'
import Spordiriided from '../views/Spordiriided.vue'
import Filtreeri from '../views/Filtreeri.vue'
import Kapisisulist from '../views/Kapisisulist.vue'
import Uusese from '../views/Uusese.vue'
import Kogulist from '../views/Kogulist'


// import LoginComponent from "../views/login.vue"
// import SecureComponent from "../views/secure.vue"

Vue.use(VueRouter)

const routes = [

    {
        path: '/',
        name: 'Avaleht',
        component: Avaleht
    },
    {
        path: '/riidekapp',
        name: 'Riidekapp',
        component: Riidekapp
    },
    {
        path: '/uuskonto',
        name: 'Uuskonto',
        component: Uuskonto
    },
    {
        path: '/kogukapp',
        name: 'Kogukapp',
        component: Kogukapp
    },
    {
        path: '/oueriided',
        name: 'Oueriided',
        component: Oueriided
    },
    {
        path: '/aksessuaarid',
        name: 'Aksessuaarid',
        component: Aksessuaarid
    },
    {
        path: '/riided',
        name: 'Riided',
        component: Riided
    },
    {
        path: '/spordiriided',
        name: 'Spordiriided',
        component: Spordiriided
    },
    {
        path: '/filtreeri',
        name: 'Filtreeri',
        component: Filtreeri
    },
    {
        path: '/kapisisulist',
        name: 'Kapisisulist',
        component: Kapisisulist
    },
    {
        path: '/uusese',
        name: 'Uusese',
        component: Uusese
    },
    {
        path: '/kogulist',
        name: 'Kogulist',
        component: Kogulist
    }
]

const router = new VueRouter({
    routes
})

export default router
