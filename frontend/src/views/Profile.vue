<template>
  <div class="container">
    <h1 class="text-center">Профиль</h1>
    <div class="row gx-5 mb-1">
      <div class="col-3">
        <div class="row border border-2 border-secondary rounded-3 bg-light">
          <h2 class="text-center">Информация</h2>
          <p class="fw-bold mb-0">Логин:</p>
          <p>{{user.username}}</p>
          <p class="fw-bold mb-0">Email:</p>
          <p>{{user.email}}</p>
        </div>
      </div>
      <div class="col-4">
        <SolvedQuestionList
            :solvedQuestions="user.solvedQuestions"
        />
      </div>
    </div>
    <div v-if="isCreator" class="row">
      <CreatedTestList
          :createdTestsProp="createdTests"
          @removeSolvedQuestions="removeSolvedQuestions($event)"
      />
    </div>
  </div>
</template>

<script>
import axios from 'axios';
import SolvedQuestionList from "@/components/SolvedQuestionList";
import CreatedTestList from "@/components/CreatedTestList";


export default {
  name: "Profile",
  components: { SolvedQuestionList, CreatedTestList },
  data() {
    return {
      user: {
        username: '',
        email: '',
        solvedQuestions: []
      },
      createdTests: []
    }
  },
  computed: {
    isCreator: function() {
      return this.$store.getters.getAuthorities.some(el => el === "ROLE_CREATOR");
    }
  },
  methods: {
    getUser() {
      axios.get('http://localhost:8080/api/profile')
          .then(response => {
            this.user = response.data;
          })
          .catch((error) => {
            console.log(error.message);
          });
    },
    getCreatedTests() {
      if (this.isCreator) {
        axios.get('http://localhost:8080/api/createdTest')
            .then(response => {
              this.createdTests = response.data;
            })
            .catch((error) => {
              console.log(error.message);
            });
      }
    },
    removeSolvedQuestions(test) {
      this.user.solvedQuestions = this.user.solvedQuestions.filter(el => el.testId !== test[0].id);
    }
  },
  beforeMount() {
    this.getUser();
    this.getCreatedTests();
  }
}
</script>

<style>

</style>