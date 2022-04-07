<template>
  <div class="container">
    <h1 class="text-center">Тесты</h1>
    <TestList
      :tests="tests"
    />
  </div>
</template>

<script>
import TestList from "../components/TestList";
import axios from 'axios';

export default {
  name: "Tests",
  components: {TestList},
  data: () => ({
    tests: []
  }),
  methods: {
    getTests() {
      axios.get('http://localhost:8080/api/getTests')
          .then(response => {
            this.tests = response.data;
          })
          .catch((error) => {
            console.log(error.message);
          });
    }
  },
  beforeMount(){
    this.getTests()
  }
}
</script>

<style>

</style>