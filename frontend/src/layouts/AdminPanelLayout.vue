<template>
  <nav class="navbar bg-light">
    <ul class="nav">
      <li class="nav-item">
        <router-link class="nav-link" to="/">Главная</router-link>
      </li>
      <li class="nav-item">
        <router-link class="nav-link" to="/panel/users">Пользователи</router-link>
      </li>
    </ul>
  </nav>
  <slot/>
</template>

<script>
export default {
  name: "AdminPanelLayout"
}
</script>

<style>

</style>