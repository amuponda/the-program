<template>
  <div>
    <nav>
      <a href="#">Today</a>
      <router-link to="/goals/list">Goals</router-link>
      <a href="#">Watch me work</a>
    </nav>
    <main>
      <router-view/>
    </main>
  </div>
</template>

<script>
import {mapGetters} from 'vuex'

export default {
  name: 'app-nav',
  created () {
    this.$store.dispatch('fetchUser').then(() => {
      if (this.user) {
        this.$store.dispatch('fetchGoals')
      }
    })
      .catch(error => {
        console.log(JSON.stringify(error))
      })
  },
  computed: mapGetters({
    user: 'getUser'
  })
}
</script>

<style scoped>

</style>
