import { createRouter, createWebHistory } from 'vue-router'
import Tests from "@/views/Tests";
import Solve from "@/views/Solve";
import Login from "@/views/Login";

const routes = [
  {
    path: '/',
    name: 'Tests',
    component: Tests
  },
  {
    path: '/solve/:id',
    name: 'Solve',
    component: Solve,
    props: true
  },
  {
    path: '/login',
    name: 'login',
    component: Login,
  }
]

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes
})

export default router
