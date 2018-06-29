import * as actions from './actions'
import * as getters from './getters'

import {
  FETCH_GOALS,
  CREATE_GOAL
} from './mutation-types'

const initialState = {
  goals: []
}

const mutations = {
  [FETCH_GOALS] (state, goals) {
    state.goals = goals
  },
  [CREATE_GOAL] (state, goal) {
    state.goals.push(goal)
  }
}

export default {
  state: { ...initialState },
  getters,
  mutations,
  actions
}
