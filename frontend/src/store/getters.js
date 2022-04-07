const getters = {
    isAuthenticated(state) {
        return state.isAuthenticated === 'true';
    },
    getAuthorities(state) {
        return state.authorities == null ? [] : state.authorities;
    }
};

export default getters;