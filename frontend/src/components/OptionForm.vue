<template>
  <div class="border">
    <CustomInput v-model="option.text" name="Текст"/>
    <label>
      Верный?
      <input v-model="option.correct" type="checkbox">
    </label>
    <br>
    <button @click="$emit('remove')">Удалить ответ</button>
  </div>
</template>

<script>
import CustomInput from "@/components/CustomInput";

export default {
  data() {
    return {
      option: this.newOption
    }
  },
  name: "OptionForm",
  props: ['newOption'],
  components: {CustomInput},
  emits: ['remove'],
}
</script>

<style>

</style>