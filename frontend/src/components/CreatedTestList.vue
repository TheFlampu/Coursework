<template>
  <div class="col border border-2 border-secondary rounded-3 bg-light">
    <h2 class="text-center">Созданные тесты</h2>
    <p class="text-center" v-if="createdTests.length === 0">Нет созданных тестов</p>
    <CreatedTestItem
        v-for="(createdTest, index) in createdTests"
        :key="createdTest.id"
        :createdTest="createdTest"
        @remove="$emit('removeSolvedQuestions', (createdTests.splice(index, 1)))"
    />
    <router-link class="text-center nav-link" to="/create">Создать</router-link>
  </div>
</template>

<script>
import CreatedTestItem from "@/components/CreatedTestItem";

export default {
  data() {
    return {
      createdTests: this.createdTestsProp
    }
  },
  name: "CreatedTestList",
  components: { CreatedTestItem },
  props: ['createdTestsProp'],
  emits: ['removeSolvedQuestions'],
  watch : {
    createdTestsProp: function(val) {
      this.createdTests = val;
    }
  }
}
</script>

<style>

</style>