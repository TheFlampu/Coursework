<template>
  <option :value="category">
      {{ category.name }}
  </option>
</template>

<script>
export default {
  name: "CategoryItem",
  props: ['category'],
}
</script>

<style>

</style>