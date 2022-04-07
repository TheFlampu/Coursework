const mutations = {
    setAuthentication(state, value) {
        state.isAuthenticated = value;
        localStorage.setItem('isAuthenticated', value);
    },
    clearAuthentication(state) {
        state.isAuthenticated = 'false';
        localStorage.removeItem('isAuthenticated');
    },
    setAuthorities(state, value) {
        state.authorities = value;
        localStorage.setItem('authorities', JSON.stringify(value));
    },
    clearAuthorities(state) {
        state.authorities = null;
        localStorage.removeItem('authorities');
    }
};

export default mutations;