<template>
  <div>
    <label>
      Тема
      <select v-model="selected" @change="$emit('update:modelValue', selected)">
        <CategoryItem
            v-for="category in categories"
            :key="category.id"
            :category="category"
        />
      </select>
    </label>
  </div>
</template>

<script>
import CategoryItem from "@/components/CategoryItem";
import axios from 'axios';

export default {
  name: "CategoryList",
  data() {
    return {
      selected: this.modelValue,
      categories: []
    }
  },
  props: ['modelValue'],
  components: {CategoryItem},
  methods: {
    getCategories() {
        axios.get('http://localhost:8080/api/categories')
            .then(response => {
              this.categories = response.data;
            })
            .catch((error) => {
              console.log(error.message);
            })
    }
  },
  beforeMount(){
    this.getCategories()
  },
  watch : {
    modelValue: function(val) {
      this.selected = val;
    }
  }
}
</script>

<style>

</style>