<template>
  <nav class="navbar bg-light">
    <ul class="nav">
      <li class="nav-item">
        <router-link class="nav-link" to="/">Тесты</router-link>
      </li>
      <li class="nav-item">
        <router-link class="nav-link" to="/profile">Профиль</router-link>
      </li>
      <li class="nav-item">
        <button class="btn btn-primary" @click="logoutUser">Выход</button>
      </li>
    </ul>
  </nav>
  <slot/>
</template>

<script>
import { mapActions } from 'vuex'

export default {
  name: "DefaultLayout",
  methods: {
    ...mapActions(['logoutUser'])
  }
}
</script>

<style>

</style>