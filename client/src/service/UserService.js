/* eslint-disable */
import http from '@/http'

const TOKEN_KEY = 'tp_token'

const LOGIN_URL = '/api/login'
const VALIDATE_URL = '/api/validate'

export default {
  login (email, password) {
    return http.post(LOGIN_URL, { username: email, password: password })
  },
  validate () {
    return http.get(VALIDATE_URL)
  },
  getToken () {
    return sessionStorage.getItem(TOKEN_KEY)
  },
  setToken (token) {
    sessionStorage.setItem(TOKEN_KEY, token)
  },
  removeToken () {
    sessionStorage.removeItem(TOKEN_KEY)
  }
}
