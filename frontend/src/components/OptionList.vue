<template>
  <div :class="{solved : isSolved, error : error}">
    <option-item
        v-for="option in options"
        :key="option.id"
        :option="option"
        v-model="checked"
        :solved="isSolved"
    />
    <button @click="solve" :disabled="isSolved">Проверить</button>
  </div>
</template>

<script>
import OptionItem from "@/components/OptionItem";
import axios from 'axios';

export default {
  data() {
    return {
      checked: this.options.filter(el => el.checked).map(el => el.id),
      isSolved: this.solved,
      error: false
    }
  },
  name: "OptionList",
  props: ['options', 'id', 'solved'],
  components: {
    OptionItem
  },
  methods: {
    solve() {
      axios.post('http://localhost:8080/api/solve/' + this.id, this.checked)
          .then((response) => {
            if (response.data) {
              this.error = false;
              this.isSolved = true;
            } else {
              this.error = true
            }
          })
          .catch((error) => {
            console.log(error.message);
          });
    }
  }
}


</script>

<style>
  .solved {
    background-color: rgba(82, 222, 19, .5);
  }
  .error {
    background-color: rgba(222, 19, 19, .5);
  }
</style>