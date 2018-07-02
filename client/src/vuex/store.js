import Vue from 'vue'
import Vuex from 'vuex'

import goals from './modules/goals'
import user from './modules/user'

Vue.use(Vuex)

const debug = process.env.NODE_ENV !== 'production'

export default new Vuex.Store({
  modules: {
    goals,
    user
  },
  strict: debug
})
