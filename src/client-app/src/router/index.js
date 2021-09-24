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
import Sokid from '../views/Sokid.vue'
import Bodyd from '../views/Bodyd.vue'
import Joped from '../views/Joped.vue'
import Kindad from '../views/Kindad.vue'
import Kleidid from '../views/Kleidid.vue'
import Kombekad from '../views/Kombekad.vue'
import Mutsid from '../views/Mutsid.vue'
import Muu from '../views/Muu.vue'
import Ouepuksid from '../views/Ouepuksid.vue'
import Pusad from '../views/Pusad.vue'
import Romperid from '../views/Romperid.vue'
import Sallid from '../views/Sallid.vue'
import Seelikud from '../views/Seelikud.vue'
import Sipukad from '../views/Sipukad.vue'
import Sukapuksid from '../views/Sukapuksid.vue'
import Tuduriided from '../views/Tuduriided.vue'
import Ujumisriided from '../views/Ujumisriided.vue'
import Kapisisulist from '../views/Kapisisulist.vue'
import Uusriideese from '../views/Uusriideese.vue'
import Uusjalanou from '../views/Uusjalanou.vue'
import Koikkategooriad from "../views/Koikkategooriad";


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
    },
    {
        path: '/sokid',
        name: 'Sokid',
        component: Sokid
    },
    {
        path: '/bodyd',
        name: 'Bodyd',
        component: Bodyd
    },
    {
        path: '/joped',
        name: 'Joped',
        component: Joped
    },
    {
        path: '/kindad',
        name: 'Kindad',
        component: Kindad
    },
    {
        path: '/kleidid',
        name: 'Kleidid',
        component: Kleidid
    },
    {
        path: '/kombekad',
        name: 'Kombekad',
        component: Kombekad
    },
    {
        path: '/mutsid',
        name: 'Mutsid',
        component: Mutsid
    },
    {
        path: '/muu',
        name: 'Muu',
        component: Muu
    },
    {
        path: '/ouepuksid',
        name: 'Ouepuksid',
        component: Ouepuksid
    },
    {
        path: '/pusad',
        name: 'Pusad',
        component: Pusad
    },
    {
        path: '/romperid',
        name: 'Romperid',
        component: Romperid
    },
    {
        path: '/sallid',
        name: 'Sallid',
        component: Sallid
    },
    {
        path: '/seelikud',
        name: 'Seelikud',
        component: Seelikud
    },
    {
        path: '/sipukad',
        name: 'Sipukad',
        component: Sipukad
    },
    {
        path: '/sukapukaid',
        name: 'Sukapuksid',
        component: Sukapuksid
    },
    {
        path: '/tududriided',
        name: 'Tududriided',
        component: Tuduriided
    },
    {
        path: '/ujumisriided',
        name: 'Ujumisriided',
        component: Ujumisriided
    },
    {
        path: '/kapisisulist',
        name: 'Kapisisulist',
        component: Kapisisulist
    },
    {
        path: '/uusriideese',
        name: 'Uusriideese',
        component: Uusriideese
    },
    {
        path: '/uusjalanou',
        name: 'Uusjalanou',
        component: Uusjalanou
    },
    {
        path: '/koikkategooriad',
        name: 'Koikkategooriad',
        component: Koikkategooriad
    }

]

const router = new VueRouter({
    routes
})

export default router
