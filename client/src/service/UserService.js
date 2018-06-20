/* eslint-disable */
import http from '@/http'

const loginUrl = '/api/login'

export default {
  login: (email, password) => {
    return http.post(loginUrl, { username: email, password: password })
  }
}
