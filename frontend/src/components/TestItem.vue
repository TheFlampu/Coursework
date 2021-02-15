<template>
  <li>
    Тема: {{ test.category.name }} |
    Название: {{ test.title }} |
    Описание: {{ test.description }} |
    <router-link :to="{path: '/solve', name: 'Solve', params: {id: test.id}}">Решить</router-link> |
  </li>
</template>

<script>
export default {
  props: ['test', 'key'],
  name: "TestItem"
}
</script>

<style>

</style>