<template>
  <form @submit.prevent="login">
    <label>Email</label>
    <input v-validate="'required|email'" name="email" v-model="email" />
    <span v-show="errors.has('email') && fields.email.touched">{{ errors.first('email') }}</span>
    <label>Password</label>
    <input v-validate="'required'" name="password" v-model="password" type="password" />
    <span v-show="errors.has('password')">{{ errors.first('password') }}</span>
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
      serverURL: process.env.SERVER_URL
    }
  },
  methods: {
    login () {
      this.$validator.validateAll().then(result => {
        if (result) {
          userService.login(this.email, this.password)
            .then(response => {
              sessionStorage.setItem(tokenPrefix, response.data.access_token)
              this.$router.push({ name: 'dashboard' })
            })
            .catch(error => {
              console.log(JSON.stringify(error))
            })
        }
      })
    }
  }
}
</script>

<style scoped>

</style>
