<template>
  <tr>
    <th scope="col">
      {{user.id}}
    </th>
    <td>
      <EditableCustomInput :editing="editing" v-model="user.username"/>
    </td>
    <td>
      <EditableCustomInput :editing="editing" v-model="user.email"/>
    </td>
    <td>
      <RoleList :editing="editing" v-model="user.authorities" :rolesList="rolesList"/>
    </td>
    <td>
      <button class="btn" :class="editing ? 'btn-success' : 'btn-primary'" @click="editing ? save() : edit()" v-html="editing ? 'Сохранить' : 'Изменить'"></button>
      <button class="btn btn-danger" @click="remove">Удалить</button>
    </td>
  </tr>
</template>

<script>
import EditableCustomInput from "@/components/EditableCustomInput";
import RoleList from "@/components/RoleList";
import axios from "axios";
export default {
  data() {
    return {
      editing: false,
      user: this.modelValue
    }
  },
  components: {RoleList, EditableCustomInput},
  props: ['modelValue', 'key', 'rolesList'],
  name: "UserItem",
  methods: {
    edit() {
      this.editing = true;
    },
    save() {
      axios.post('http://localhost:8080/api/panel/editUser', this.user)
          .then(() => {
            console.log("Пользователь сохранён");
            this.editing = false;
          })
          .catch((error) => {
            console.log(error.message);
          });
    },
    remove() {
      axios.delete('http://localhost:8080/api/panel/deleteUser/' + this.user.id)
          .then(() => {
            this.$emit('remove')
            console.log("Пользователь удалён");
          })
          .catch((error) => {
            console.log(error.message);
          });
    }
  },
  emits: ['remove'],
}
</script>

<style>

</style>