<template>
  <div class="border">
    <CustomInput v-model="question.title" name="Название"/>

    <CustomTextArea v-model="question.text" name="Вопрос"/>

    <OptionForm
        v-for="(option, index) in question.options"
        :key="index"
        :newOption="option"
        @remove="question.options.splice(index, 1)"
    />

    <button @click="addOption">Добавить ответ</button>
    <br>
    <button @click="$emit('remove')">Удалить вопрос</button>
  </div>
</template>

<script>
import CustomInput from "@/components/CustomInput";
import CustomTextArea from "@/components/CustomTextArea";
import OptionForm from "@/components/OptionForm";

export default {
  data() {
    return {
    question: this.newQuestion
    }
  },
  name: "QuestionForm",
  props: ['newQuestion'],
  components: {CustomInput, CustomTextArea, OptionForm},
  emits: ['remove'],
  methods: {
    addOption() {
      this.question.options.push({
        text: '',
        correct: false
      })
    }
  }
}
</script>

<style>

</style>