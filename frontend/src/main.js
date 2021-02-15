import { createApp } from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'
import axios from 'axios'
import VueAxios from 'vue-cli-plugin-axios'
import vuex from 'vuex'
import vueVuex from '@vue/cli-plugin-vuex'

createApp(App).use(store).use(router).use(VueAxios, axios).use(vueVuex, vuex).mount('#app')
