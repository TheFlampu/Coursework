<template>
  <ul>
    <TestItem
      v-for="test in tests"
      :key="test.id"
      :test="test"
    />
  </ul>
</template>

<script>
import TestItem from "@/components/TestItem";
export default {
  props: ['tests'],
  name: 'TestList',
  components: {
    TestItem
  }
}
</script>

<style>

</style>