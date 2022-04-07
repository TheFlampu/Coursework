<template>
  <div>
    <h1 class="text-center">Пользователи</h1>
    <UserList
        v-model="users"
        :rolesList="roles"
    />
  </div>
</template>

<script>
import UserList from "@/components/UserList";
import axios from 'axios';

export default {
  name: "UsersPanel",
  data: () => ({
    users: [],
    roles: []
  }),
  components: {
    UserList
  },
  methods: {
    getUsers() {
      axios.get('http://localhost:8080/api/panel/users')
          .then(response => {
            this.users = response.data;
          })
          .catch((error) => {
            console.log(error.message);
          });
    },
    getRoles() {
      axios.get('http://localhost:8080/api/panel/roles')
          .then(response => {
            this.roles = response.data;
          })
          .catch((error) => {
            console.log(error.message);
          });
    }
  },
  beforeMount(){
    this.getUsers();
    this.getRoles();
  }
}
</script>

<style>

</style>