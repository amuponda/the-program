<template>
  <container>
    <row>
      <column>
        <card>
          <card-body>
            <form @submit.prevent="login">
              <p class="h4 text-center mb-4">Sign in</p>

              <span v-show="errorMessage">{{errorMessage}}</span>

              <div class="grey-text">
                <md-input
                  v-validate="'required|email'"
                  name="email"
                  label="Email"
                  icon="envelope"
                  type="text"
                  :value="email"
                  @input="email = $event">
                  <p v-show="errors.has('email')" class="text-danger"><small>{{ errors.first('email') }}</small></p>
                </md-input>
              </div>

              <div class="grey-text">
                <md-input
                  v-validate="'required'"
                  name="password"
                  label="Password"
                  icon="lock"
                  type="password"
                  :value="password"
                  @input="password = $event">
                  <p v-show="errors.has('password')" class="text-danger"><small>{{ errors.first('password') }}</small></p>
                </md-input>
              </div>

              <div class="text-center">
                <btn color="primary" type="submit">Log in</btn>
              </div>

            </form>
          </card-body>
        </card>
      </column>
    </row>
  </container>
</template>

<script>
import userService from '@/service/UserService'
import { Container, Card, CardBody, Row, Column, MdInput, Btn } from 'mdbvue'

export default {
  components: { Container, Card, CardBody, Row, Column, MdInput, Btn },
  name: 'login',
  beforeRouteEnter: (to, from, next) => {
    if (userService.getToken()) {
      userService.validate()
        .then(() => {
          return next({ path: '/' })
        })
        .catch(() => {
          return next()
        })
    }
    return next()
  },
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
              userService.setToken(response.data.access_token)
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
 .row {
   margin-top: 10%;
 }
</style>
