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
export default {
  name: 'app-nav'
}
</script>

<style scoped>

</style>
