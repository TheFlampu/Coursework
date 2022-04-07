import 'mutationobserver-shim'
import { createApp } from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'
import axios from 'axios'
import VueAxios from 'vue-cli-plugin-axios'
import DefaultLayout from "@/layouts/DefaultLayout";
import RegisterLoginLayout from "@/layouts/RegisterLoginLayout";
import AdminPanelLayout from "@/layouts/AdminPanelLayout";
import "bootstrap/dist/css/bootstrap.min.css"
import "bootstrap"

axios.interceptors.response.use((response) => Promise.resolve(response),
    (error) => {
        if (error.response.status === 401) {
            store.dispatch('logoutUser');
            return Promise.reject(new Error('Ошибка токена, выход'));
        }
        return Promise.reject(error.response);
    });

createApp(App)
    .use(store)
    .use(router)
    .use(VueAxios, axios)
    .component("DefaultLayout", DefaultLayout)
    .component("RegisterLoginLayout", RegisterLoginLayout)
    .component("AdminPanelLayout", AdminPanelLayout)
    .mount('#app');
