import axios from 'axios';
import router from '../router';

const actions = {
    loginUser({ commit }, user) {
        axios.post('http://localhost:8080/api/login', user)
            .then(() => {
                axios.get('http://localhost:8080/api/getAuthorities')
                    .then(response => {
                        commit('setAuthorities', response.data.map(el => el.authority));
                        commit('setAuthentication', 'true');
                        router.push('/');
                        console.log("Вход выполнен");
                    })
            })
            .catch((error) => {
                console.log(error.message);
            });
    },
    logoutUser({ commit }) {
        axios.post('http://localhost:8080/api/logout')
            .then(() => {
                commit('clearAuthentication');
                commit('clearAuthorities');
                router.push('/login');
                console.log("Выход выполнен");
            })
            .catch((error) => {
                console.log(error.message);
            });
    },
    registerUser(context, user) {
        axios.post('http://localhost:8080/api/register', user)
            .then(() => {
                console.log("Успешная регистрация");
                router.push('/login');
            })
            .catch((error) => {
                console.log(error.message);
            });
    }
};

export default actions;
