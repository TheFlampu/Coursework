<template>
  <div class="col-4 border border-2 border-secondary rounded-3 bg-light">
    <form @submit.prevent="submit">
      <h1 class="text-center">Регистрация</h1>
      <CustomInput v-model="username" name="Логин"/>
      <CustomInput v-model="email" name="E-mail" type="email"/>
      <CustomInput v-model="password" name="Пароль" type="password"/>
      <button type="submit" class="btn btn-primary w-100 mb-3">Регистрация</button>
      <div class="text-center">
        <router-link to="/login">Войти</router-link>
      </div>
    </form>
  </div>
</template>

<script>
import CustomInput from "@/components/CustomInput";
import { mapActions } from 'vuex'

export default {
  name: "Register",
  data: () => ({
    username: '',
    password: '',
    email: ''
  }),
  components: {CustomInput},
  methods: {
    ...mapActions(['registerUser']),
    submit() {
      this.registerUser({
        username: this.username,
        password: this.password,
        email: this.email
      })
    }
  }
}
</script>

<style>

</style>