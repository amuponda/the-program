<template>
  <div>
    <h1>List of Goals</h1>
    <div v-for="goal in goals" :key="goal.id">
      <p>{{goal.name}}</p>
      <p>{{goal.targetDate}}</p>
      <router-link :to="{name: 'goal', params: {id: goal.id}}">View Goal</router-link>
    </div>
  </div>
</template>

<script>
import { mapGetters } from 'vuex'

export default {
  name: 'goal-list',
  computed: mapGetters({
    goals: 'getGoals'
  })
}
</script>

<style scoped>

</style>
