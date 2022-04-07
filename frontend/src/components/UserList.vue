<template>
  <table class="table">
    <thead>
      <tr>
        <th scope="col">id</th>
        <th scope="col">Логин</th>
        <th scope="col">Email</th>
        <th scope="col">Роли</th>
        <th scope="col">Действия</th>
      </tr>
    </thead>
    <tbody>
    <UserItem
        v-for="(user, index) in users"
        :key="user.id"
        :modelValue="user"
        @remove="users.splice(index, 1)"
        :rolesList="rolesList"
    />
    </tbody>
  </table>
</template>

<script>
import UserItem from "@/components/UserItem";

export default {
  data() {
    return {
      users: this.modelValue
    }
  },
  props: ['modelValue', 'rolesList'],
  name: "UserList",
  components: {
    UserItem
  },
  watch : {
    modelValue: function(val) {
      this.users = val;
    }
  }
}
</script>

<style>

</style>