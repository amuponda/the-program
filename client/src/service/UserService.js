/* eslint-disable */
import http from '@/http'

const LOGIN_URL = '/api/login'
const VALIDATE_URL = '/api/validate'

export default {
  login: (email, password) => {
    return http.post(LOGIN_URL, { username: email, password: password })
  },
  validate: () => {
    return http.get(VALIDATE_URL)
  }
}
