// router/index.js
import Vue from 'vue'
import Router from 'vue-router'
import Login from '@/components/Login/Login.vue'
import SignUp from '@/components/Login/SignUp.vue'
import Main from '@/components/Main/Main.vue'

Vue.use(Router)

export default new Router({
  mode: 'history', // history 모드 설정
  routes: [
    {
      path: '/',
      name: 'Main',
      component: Main
    },
    {
      path: '/users/login',
      name: 'Login',
      component: Login
    },
    {
      path: '/users/signup',
      name: 'SignUp',
      component: SignUp
    }
  ]
})
