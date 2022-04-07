<template>
  <div class="bg-light rounded-2">
    <p>{{authority}} <span class="text-danger" v-if="editing" @click="$emit('remove')">X</span></p>
  </div>
</template>

<script>
export default {
  name: "RoleItem",
  props: ['authority', 'editing'],
  emits: ['remove'],

}
</script>

<style>

</style>