import http from '@/http'

import {FETCH_GOALS} from './mutation-types'

const GOALS_URL = '/api/goals'

export function fetchGoals ({ commit }) {
  http.get(GOALS_URL)
    .then(response => {
      commit(FETCH_GOALS, response.data)
    })
    .catch(error => {
      console.log(JSON.stringify(error))
    })
}
