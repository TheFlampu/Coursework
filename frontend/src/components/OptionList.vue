<template>
  <div>
    <option-item
        v-for="option in options"
        :key="option.id"
        :option="option"
        v-model="checked"
    />
    <button>Проверить</button>
  </div>
</template>

<script>
import OptionItem from "@/components/OptionItem";

export default {
  data: () => ({
    checked: []
  }),
  name: "OptionList",
  props: ['options', 'id'],
  components: {
    OptionItem
  }
}
</script>

<style>

</style>