import { createStore } from 'vuex'
import axios from 'axios';

export default createStore({
  state: {
    isAuthenticated: false,
  },
  actions: {
    userLogin({ commit }, user) {
      axios.post('http://localhost:8080/api/login', user)
          .then(() => {
            commit('setAuth', true)
          })
          .catch((error) => {
        console.log(error.message)
          });
    }
  },
  mutations: {
    setAuth(state, value) {
      state.isAuthenticated = value;
    }
  },
  getters: {
    isAuthenticated(state) {
      return state.isAuthenticated;
    }
  },
  modules: {
  }
})
