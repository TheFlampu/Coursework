<template>
  <input
      v-if="editing"
      v-model="value"
      @input="$emit('update:modelValue', value)"
      type="text">
  <p v-else>{{value}}</p>
</template>

<script>
export default {
  name: "EditableCustomInput",
  data() {
    return {
      value: this.modelValue
    }
  },
  props: ['modelValue', 'editing'],
}
</script>

<style>

</style>