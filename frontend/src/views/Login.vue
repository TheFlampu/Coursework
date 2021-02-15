<template>
  <form @submit.prevent="submit">
    <h1>Войти</h1>
    <label for="username">
      Username
      <input id="username" type="text" v-model="username">
    </label>
    <br>
    <label for="password">
      Password
      <input id="password" type="password" v-model="password">
    </label>
    <br>
    <button type="submit">Войти</button>
  </form>

</template>

<script>
import { mapActions } from 'vuex'

export default {
  name: "Login",
  data: () => ({
    username: '',
    password: ''
  }),
  methods: {
    ...mapActions(['userLogin']),
    submit() {
      this.userLogin({
        username: this.username,
        password: this.password
      })
    }
  }
}
</script>

<style>

</style>