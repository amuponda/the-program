import Vue from 'vue'
import Router from 'vue-router'
import Login from '@/components/Login'
import Dashboard from '@/components/Dashboard'
import AppNav from '@/components/AppNav'
// import GoalList from '@/components/GoalList'
// import Goal from '@/components/Goal'

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/login',
      name: 'login',
      component: Login
    },
    {
      path: '/',
      component: AppNav,
      children: [
        {
          path: '',
          component: Dashboard
        },
        {
          path: 'dashboard',
          name: 'dashboard',
          component: Dashboard
        }
      ]
    }
    /*
    {
      path: '/goals',
      name: 'goals',
      component: Goals,
      children: [
        {
          path: 'list',
          name: 'goalList',
          component: GoalList
        },
        {
          path: ':id',
          name: 'goal',
          component: Goal
        }
      ]
    }
    */
  ]
})
