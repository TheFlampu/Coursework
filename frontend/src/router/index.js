import { createRouter, createWebHistory } from 'vue-router'
import Tests from "@/views/Tests";
import Solve from "@/views/Solve";
import Login from "@/views/Login";
import CreateTest from "@/views/CreateTest";
import store from '@/store'
import EditTest from "@/views/EditTest";
import Register from "@/views/Register";
import Profile from "@/views/Profile";
import UsersPanel from "@/views/UsersPanel";

const routes = [
  {
    path: '/',
    name: 'Tests',
    component: Tests,
    meta: {
      RequiresAuth: true,
      RequiredAuthorities: [
          'ROLE_USER'
      ]
    },
  },
  {
    path: '/solve/:id',
    name: 'Solve',
    component: Solve,
    props: true,
    meta: {
      RequiresAuth: true,
      RequiredAuthorities: [
          'ROLE_USER'
      ]
    },
  },
  {
    path: '/login',
    name: 'login',
    component: Login,
    meta: {
        RequiresAuth: false,
        RequiredAuthorities: [
        ],
        layout: "RegisterLoginLayout"
    },
  },
  {
    path: '/register',
    name: 'register',
    component: Register,
    meta: {
        RequiresAuth: false,
        RequiredAuthorities: [
        ],
        layout: "RegisterLoginLayout"
    },
  },
  {
    path: '/create',
    name: 'createTest',
    component: CreateTest,
    meta: {
      RequiresAuth: true,
      RequiredAuthorities: [
          'ROLE_CREATOR'
      ]
    },
  },
  {
    path: '/edit/:id',
    name: 'editTest',
    component: EditTest,
    props: true,
    meta: {
      RequiresAuth: true,
      RequiredAuthorities: [
          'ROLE_CREATOR'
      ]
    },
  },
  {
    path: '/profile',
    name: 'Profile',
    component: Profile,
    meta: {
      RequiresAuth: true,
      RequiredAuthorities: [
        'ROLE_USER'
      ]
    },
  },
  {
    path: '/panel/users',
    name: 'UsersPanel',
    component: UsersPanel,
    meta: {
      RequiresAuth: true,
      RequiredAuthorities: [
        'ROLE_ADMIN'
      ],
      layout: "AdminPanelLayout"
    },
  }
]

const router = createRouter({
  routes,
  history: createWebHistory(process.env.BASE_URL)
})

router.beforeEach((to, from, next) => {
  const page = to.matched[0];

  const isAuthenticated = store.getters.isAuthenticated;

  if (!page) {
    console.log("???????????????? ???? ????????????????????");
    if (isAuthenticated)
      next('/');
    else
      next('/login')
  } else {
    const requiresAuth = page.meta.RequiresAuth;
    const requiredAuthorities = page.meta.RequiredAuthorities;

    const authorities = store.getters.getAuthorities;

    const hasAuthority = requiredAuthorities.length > 0 ? authorities.some(el => requiredAuthorities.includes(el)) : true;

    if (requiresAuth && !isAuthenticated) {
      console.log("???????????? ???????? ???????????????????????????????? ?????? ?????????????? ?? ???????? ????????????????");
      next('/login');
    } else if (!requiresAuth && isAuthenticated) {
      console.log("???????????? ???????? ???? ???????????????????????????????? ?????? ?????????????? ?? ???????? ????????????????");
      next('/');
    } else if (!hasAuthority) {
      console.log("???? ???????????????????? ???????? ?????? ?????????????? ?? ???????? ????????????????");
      next('/');
    }
  }
  next();
});

export default router
