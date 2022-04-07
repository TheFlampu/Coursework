<template>
  <li>
    <strong><span>{{ question.title }}</span></strong>
    <br>
    <span>{{ question.text }}</span>
    <option-list
      :options="shuffle(question.options)"
      :id="question.id"
      :solved="question.solved"
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
  },
  methods: {
    shuffle(arr){
      let j, temp;
      for(let i = arr.length - 1; i > 0; i--){
        j = Math.floor(Math.random()*(i + 1));
        temp = arr[j];
        arr[j] = arr[i];
        arr[i] = temp;
      }
      return arr;
    }
  }
}
</script>

<style>

</style>