<template>
  <RoleItem
      v-for="(role, index) in roles"
      :key=role.id
      :authority="role.authority"
      :editing="editing"
      @remove="roles.splice(index, 1)"
  />
  <select style="width: 100%" v-if="editing" v-model="selected" @change="addRole">
    <option
        v-for="role in rolesList.filter(el => roles.map(item => item.id).indexOf(el.id) === -1)"
        :key="role.id"
        :value="role"
        v-html="role.authority"
    ></option>
  </select>
</template>

<script>
import RoleItem from "@/components/RoleItem";
export default {
  name: "RoleList",
  components: {RoleItem},
  data() {
    return {
      roles: this.modelValue,
      selected: null
    }
  },
  props: ['modelValue', 'editing', 'rolesList'],
  methods: {
    addRole() {
      this.roles.push(this.selected);
      this.selected = null;
    }
  }
}
</script>

<style>

</style>