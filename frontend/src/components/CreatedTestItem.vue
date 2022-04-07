<template>
  <div class="row text-center mb-1">
    <div class="col-2 border-end">
      {{ createdTest.category.name }}
    </div>
    <div class="col-3 border-end">
      {{ createdTest.title }}
    </div>
    <div class="col-4 border-end">
      {{ createdTest.description }}
    </div>
    <div class="col-3">
      <router-link class="btn btn-primary m-1" :to="{path: '/edit', name: 'editTest', params: {id: createdTest.id}}">Изменить</router-link>
      <button class="btn btn-primary" @click="deleteTest">Удалить</button>
    </div>
  </div>
</template>

<script>
import axios from 'axios';

export default {
  name: "CreatedTestItem",
  props: ['createdTest'],
  emits: ['remove'],
  methods: {
    deleteTest() {
      axios.delete('http://localhost:8080/api/delete/' + this.createdTest.id)
          .then(() => {
            this.$emit('remove');
            console.log("Тест удалён");
          })
          .catch((error) => {
            console.log(error.message);
          });
    }
  }
}
</script>

<style>

</style>