<template>
  <form @submit.prevent="login">
    <span v-show="errorMessage">{{errorMessage}}</span>
    <div>
      <label>Email</label>
      <input v-validate="'required|email'" name="email" v-model="email" />
      <span v-show="errors.has('email') && fields.email.touched">{{ errors.first('email') }}</span>
    </div>
    <div>
      <label>Password</label>
      <input v-validate="'required'" name="password" v-model="password" type="password" />
      <span v-show="errors.has('password')">{{ errors.first('password') }}</span>
    </div>
    <button type="submit">Log in</button>
  </form>
</template>

<script>

import userService from '@/service/UserService'

const tokenPrefix = 'tp_token'

export default {
  name: 'login',
  data () {
    return {
      email: '',
      password: '',
      errorMessage: null,
      serverURL: process.env.SERVER_URL
    }
  },
  methods: {
    login () {
      let vm = this
      this.$validator.validateAll().then(result => {
        if (result) {
          userService.login(this.email, this.password)
            .then(response => {
              sessionStorage.setItem(tokenPrefix, response.data.access_token)
              let originalUrl = this.$route.params.originalUrl
              if (originalUrl) {
                // go back to page they tried to access
                this.$router.push(originalUrl)
              } else {
                this.$router.push({ name: 'dashboard' })
              }
            })
            .catch(function (error) {
              if (error.response.status === 403) {
                vm.errorMessage = error.response.data.message
              } else {
                vm.errorMessage = 'Authentication failed.'
              }
            })
        }
      })
    }
  }
}
</script>

<style scoped>

</style>
