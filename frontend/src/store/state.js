const state = {
    // isAuthenticated: 'true',
    // authorities: ["ROLE_USER", "ROLE_CREATOR", "ROLE_ADMIN"],
    isAuthenticated: localStorage.getItem('isAuthenticated'),
    authorities: JSON.parse(localStorage.getItem('authorities')),
};

export default state;