<template>
  <div class="row">
    <p class="fw-bold mb-0">{{solvedQuestion.title}}</p>
    <p>{{ solvedQuestion.text }}</p>
  </div>
</template>

<script>
export default {
  data() {
    return {
      solvedQuestion: this.solvedQuestionProp,
    }
  },
  name: "SolvedQuestionItem",
  props: ['solvedQuestionProp'],
}
</script>

<style>

</style>