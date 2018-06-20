import Vue from 'vue'
import Router from 'vue-router'
import Login from '@/components/Login'
import Dashboard from '@/components/Dashboard'
// import Goals from '@/components/Goals'
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
      name: 'dashboard',
      component: Dashboard
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
