<template>
  <ul>
    <QuestionItem
      v-for="question in questions"
      :key="question.id"
      :question="question"
    />
  </ul>
</template>

<script>
import QuestionItem from "@/components/QuestionItem";

export default {
  props: ['questions'],
  name: "QuestionList",
  components: {
    QuestionItem
  }
}
</script>

<style>

</style>