<template>
  <div class="border">
    <h1>Редактировать тест</h1>
    <TestForm v-model="test"/>
    <button @click="editTest">Сохранить</button>
  </div>
</template>

<script>
import TestForm from "@/components/TestForm";
import router from "@/router";
import axios from 'axios';

export default {
  name: "EditTest",
  components: {TestForm},
  props: ['id'],
  data() {
    return {
      test: {
        title: '',
        description: '',
        category: {},
        questions: []
      }
    }
  },
  methods: {
    getTest() {
      axios.get('http://localhost:8080/api/edit?id=' + this.id)
          .then(response => {
            this.test = response.data;
          })
          .catch((error) => {
            if (error.status === 404) {
              console.log("Теста несуществует");
              router.push("/");
            } else if (error.status === 403) {
              console.log("Нет доступа к тесту");
              router.push("/");
            } else {
              console.log(error.message);
            }
          });
    },
    editTest() {
      axios.post('http://localhost:8080/api/edit', this.test)
          .then(() => {
            console.log("Тест изменён");
            router.push('/solve/' + this.id);
          })
          .catch((error) => {
            console.log(error.message);
          });
    },
  },
  beforeMount(){
    this.getTest()
  }
}
</script>

<style>

</style>