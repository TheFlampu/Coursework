<template>
  <div class="border">
    <h1>Создать новый тест</h1>
    <TestForm v-model="test"/>
    <button @click="createTest">Создать</button>
  </div>
</template>

<script>
import TestForm from "@/components/TestForm";
import router from "@/router";
import axios from 'axios';

export default {
  name: "CreateTest",
  components: {TestForm},
  data() {
    return {
      test: {
        title: '',
        description: '',
        category: {},
        questions: []
      },
    }
  },
  methods: {
    createTest() {
      axios.post('http://localhost:8080/api/create', this.test)
          .then(response => {
            console.log("Тест добавлен");
            router.push('/solve/' + response.data.id);
          })
          .catch((error) => {
            console.log(error.message);
          });
    }
  }
}
</script>

<style>
  .border {
    border: black 1px solid;
    border-radius: 5px;
    padding: 5px;
  }
</style>