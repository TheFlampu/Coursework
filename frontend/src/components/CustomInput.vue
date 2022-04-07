<template>
  <div class="mb-3">
    <label class="form-label">
      {{ name }}
    </label>
      <input class="form-control"
          v-model="value"
          @input="$emit('update:modelValue', value)"
          :type="type">
  </div>
</template>

<script>
export default {
  name: "CustomInput",
  data() {
    return {
      value: this.modelValue
    }
  },
  props: {
    modelValue: {},
    name: {},
    type: {
      default: 'text'
    }
  },
  watch : {
    modelValue: function(val) {
      this.value = val;
    }
  }
}
</script>

<style>

</style>