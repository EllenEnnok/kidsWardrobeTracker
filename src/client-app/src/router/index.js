import Vue from 'vue'
import VueRouter from 'vue-router'
import Riidekapp from '../views/Riidekapp.vue'
import Avaleht from '../views/Avaleht.vue'
import Uuskonto from '../views/Uuskonto.vue'
import Kogukapp from '../views/Kogukapp.vue'
import Oueriided from '../views/Oueriided.vue'
import Aksessuaarid from '../views/Aksessuaarid.vue'
import Jalanoud from '../views/Jalanoud.vue'
import Riided from '../views/Riided.vue'
import Spordiriided from '../views/Spordiriided.vue'
import Filtreeri from '../views/Filtreeri.vue'
import Filtreerimistulemus from '../views/Filtreerimistulemus.vue'
import Luhikesevarrukagasargid from '../views/Luhikesevarrukagasargid.vue'
import Pikavarrukagasargid from '../views/Pikavarrukagasargid.vue'
import Luhikesedpuksid from '../views/Luhikesedpuksid.vue'
import Pikadpuksid from '../views/Pikadpuksid.vue'
import Aluspesu from '../views/Aluspesu.vue'




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
        path: '/jalanoud',
        name: 'Jalanoud',
        component: Jalanoud
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
        path: '/filtreerimistulemus',
        name: 'Filtreerimistulemus',
        component: Filtreerimistulemus
    },
    {
        path: '/luhikesevarrukagasargid',
        name: 'Luhikesevarrukagasargid',
        component: Luhikesevarrukagasargid
    },
    {
        path: '/pikavarrukagasargid',
        name: 'Pikavarrukagasargid',
        component: Pikavarrukagasargid
    },
    {
        path: '/luhikesedpuksid',
        name: 'Luhikesedpuksid',
        component: Luhikesedpuksid
    },
    {
        path: '/pikadpuksid',
        name: 'Pikadpuksid',
        component: Pikadpuksid
    },
    {
        path: '/aluspesu',
        name: 'Aluspesu',
        component: Aluspesu
    }

]

const router = new VueRouter({
    routes
})

export default router
