<template>
  <div class="row border border-2 border-secondary rounded-3 bg-light overflow-auto" style="height: 11rem">
    <h2 class="text-center">Решённые вопросы</h2>
    <p class="text-center" v-if="solvedQuestions.length === 0">Нет решённых вопросов</p>
    <SolvedQuestionItem
          v-for="solvedQuestion in solvedQuestions"
          :key="solvedQuestion.id"
          :solvedQuestionProp="solvedQuestion"
      />
  </div>
</template>

<script>
import SolvedQuestionItem from "@/components/SolvedQuestionItem";

export default {
  name: "SolvedQuestionList",
  components: {SolvedQuestionItem},
  props: ['solvedQuestions']
}
</script>

<style>

</style>