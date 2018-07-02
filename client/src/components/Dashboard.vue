<template>
  <div class="container">
    <nav>
      <a>Filter</a>
      <a>New Tracker</a>
    </nav>
    <goal-list></goal-list>
  </div>
</template>

<script>
import GoalList from './GoalList'

export default {
  name: 'dashboard',
  components: {
    GoalList
  }
}
</script>

<style scoped>

</style>
