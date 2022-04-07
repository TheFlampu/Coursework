<template>
  <div>
    <h1>{{ test.title }}</h1>
    <QuestionList
      :questions="test.questions"
    />
  </div>
</template>

<script>
import QuestionList from "@/components/QuestionList";
import axios from 'axios';

export default {
  props: ['id'],
  name: "Solve",
  components: {QuestionList},
  data: () => ({
    test: {
      title: '',
      description: '',
      category: {},
      questions: []
    }
  }),
  methods: {
    getTest() {
      axios.get('http://localhost:8080/api/getTest?id=' + this.id)
          .then(response => {
            this.test = response.data;
          })
          .catch((error) => {
            console.log(error.message);
          });
    }
  },
  beforeMount(){
    this.getTest()
  }
}
</script>

<style>

</style>