<template>
  <form>
    <label for="email">Email</label>
    <input id="email" v-model="email" />
    <label for="password">Password</label>
    <input id="password" v-model="password" type="password" />
    <button @click.prevent="login" type="submit">Log in</button>
  </form>
</template>

<script>

import axios from 'axios'

const endpoint = '/api/login'

export default {
  name: 'login',
  data () {
    return {
      email: '',
      password: '',
      serverURL: process.env.SERVER_URL
    }
  },
  methods: {
    login () {
      let url = this.serverURL + endpoint
      axios.post(url, {
        username: this.email,
        password: this.password
      })
        .then((response) => {
          window.sessionStorage.tp_token = response.data.access_token
        })
        .then((error) => {
          console.log(JSON.stringify(error))
        })
    }
  }
}
</script>

<style scoped>

</style>
