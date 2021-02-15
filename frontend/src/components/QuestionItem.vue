<template>
  <li>
    <span>{{ question.text }}</span>
    <option-list
      :options="question.options"
      :id="question.id"
    />
  </li>
</template>

<script>
import OptionList from "@/components/OptionList";

export default {
  props: ['question'],
  name: "QuestionItem",
  components: {
    OptionList
  }
}
</script>

<style>

</style>