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

export default {
  props: ['id'],
  name: "Solve",
  components: {QuestionList},
  data: () => ({
    test: {
      "id": 1,
      "title": "Тест по математике",
      "description": "Простой тест по математике",
      "category": {
        "id": 1,
        "name": "Математика"
      },
      "questions": [
        {
          "id": 1,
          "title": "Простой пример",
          "text": "Сколько будет 2 + 2?",
          "options": [
            {
              "id": 1,
              "text": "1"
            },
            {
              "id": 2,
              "text": "2"
            },
            {
              "id": 3,
              "text": "3"
            },
            {
              "id": 4,
              "text": "4"
            }
          ]
        },
        {
          "id": 2,
          "title": "Сложный пример",
          "text": "Сколько будет 5 + 5?",
          "options": [
            {
              "id": 5,
              "text": "7"
            },
            {
              "id": 6,
              "text": "8"
            },
            {
              "id": 7,
              "text": "9"
            },
            {
              "id": 8,
              "text": "10"
            }
          ]
        }
      ]
    }
  })
}
</script>

<style>

</style>