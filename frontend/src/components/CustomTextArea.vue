<template>
  <div>
    <label>
      {{ name }}
      <textarea
          v-model="value"
          @input="$emit('update:modelValue', value)"
          cols="20"
          rows="2">
      </textarea>
    </label>
  </div>
</template>

<script>
export default {
  name: "CustomTextArea",
  data() {
    return {
      value: this.modelValue
    }
  },
  props: ['modelValue', 'name'],
  watch : {
    modelValue: function(val) {
      this.value = val;
    }
  }
}
</script>

<style>

</style>