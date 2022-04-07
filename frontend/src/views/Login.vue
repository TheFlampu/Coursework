<template>
  <div class="col-4 border border-2 border-secondary rounded-3 bg-light">
    <form @submit.prevent="submit">
      <h1 class="text-center">Войти</h1>
      <CustomInput v-model="username" name="Логин"/>
      <CustomInput v-model="password" name="Пароль" type="password"/>
      <button type="submit" class="btn btn-primary w-100 mb-3">Войти</button>
      <div class="text-center">
        <router-link to="/register">Регистрация</router-link>
      </div>
    </form>
  </div>
</template>

<script>
import { mapActions } from 'vuex'
import CustomInput from "@/components/CustomInput";

export default {
  name: "Login",
  data: () => ({
    username: '',
    password: ''
  }),
  components: {CustomInput},
  methods: {
    ...mapActions(['loginUser']),
    submit() {
      this.loginUser({
        username: this.username,
        password: this.password
      })
    }
  }
}
</script>

<style>

</style>