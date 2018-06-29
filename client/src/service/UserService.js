/* eslint-disable */
import http from '@/http'

const LOGIN_URL = '/api/login'

export default {
  login: (email, password) => {
    return http.post(LOGIN_URL, { username: email, password: password })
  }
}
