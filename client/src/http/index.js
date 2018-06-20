import axios from 'axios'

const tokenPrefix = 'tp_token'

const http = axios.create({
  baseURL: process.env.SERVER_URL,
  headers: {
    'Content-Type': 'application/json'
  }
})

// interceptors
http.interceptors.request.use(config => {
  console.log(JSON.stringify(config.url))
  if (config.url !== '/api/login') {
    config.headers.Authorization = 'Bearer' + sessionStorage.getItem(tokenPrefix)
  }
  return config
}, error => {
  return Promise.reject(error)
})

http.interceptors.response.use(response => {
  if (response.status === 401) {
    sessionStorage.removeItem(tokenPrefix)
  }
  return response
}, error => {
  return Promise.reject(error)
})

export default http
