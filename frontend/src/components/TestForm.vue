<template>
  <div class="border">
    <CustomInput v-model="test.title" name="Название"/>

    <CustomTextArea v-model="test.description" name="Описание"/>

    <CategoryList v-model="test.category"/>

    <QuestionForm
        v-for="(question, index) in test.questions"
        :key="index"
        :newQuestion="question"
        @remove="test.questions.splice(index, 1)"
    />
    <button @click="addQuestion">Добавить вопрос</button>
  </div>
</template>

<script>
import QuestionForm from "@/components/QuestionForm";
import CustomInput from "@/components/CustomInput";
import CustomTextArea from "@/components/CustomTextArea";
import CategoryList from "@/components/CategoryList";

export default {
  name: "TestForm",
  data() {
    return {
      test: this.modelValue,
    }
  },
  components: {CustomInput, CustomTextArea, CategoryList, QuestionForm},
  props: ['modelValue'],
  methods: {
    addQuestion() {
      this.test.questions.push({
        title: '',
        text: '',
        options: []
      })
    }
  },
  watch : {
    modelValue: function(val) {
      this.test = val;
    }
  }
}
</script>

<style>

</style>