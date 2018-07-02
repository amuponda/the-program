import http from '@/http'

import {FETCH_USER} from './mutation-types'

const USER_URL = '/api/user'

export function fetchUser ({ commit }) {
  http.get(USER_URL)
    .then(response => {
      commit(FETCH_USER, response.data)
    })
    .catch(error => {
      console.log(JSON.stringify(error))
    })
}
