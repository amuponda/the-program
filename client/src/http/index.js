import axios from 'axios'
import router from '@/router'

const tokenPrefix = 'tp_token'

const http = axios.create({
  baseURL: process.env.SERVER_URL,
  headers: {
    'Content-Type': 'application/json'
  }
})

// interceptors
http.interceptors.request.use(config => {
  if (config.url !== '/api/login') {
    config.headers.Authorization = 'Bearer ' + sessionStorage.getItem(tokenPrefix)
  }
  return config
}, error => {
  return Promise.reject(error)
})

http.interceptors.response.use(response => {
  return response
}, error => {
  if (error.response.status === 401) {
    sessionStorage.removeItem(tokenPrefix)
    router.push({ name: 'login', params: { originalUrl: router.currentRoute.path } })
  }
  return Promise.reject(error)
})

export default http
