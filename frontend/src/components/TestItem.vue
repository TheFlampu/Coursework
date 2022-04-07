<template>
  <div class="row border border-2 border-secondary rounded-3 bg-light d-flex align-items-center text-center mb-1">
    <div class="col-2 border-end">
      {{test.category.name}}
    </div>
    <div class="col-3 border-end">
      {{test.title}}
    </div>
    <div class="col-5 border-end">
      {{test.description}}
    </div>
    <div class="col-2">
      <router-link class="btn btn-primary" :to="{path: '/solve', name: 'Solve', params: {id: test.id}}">Решить</router-link>
    </div>
  </div>
</template>

<script>
export default {
  props: ['test', 'key'],
  name: "TestItem"
}
</script>

<style>

</style>