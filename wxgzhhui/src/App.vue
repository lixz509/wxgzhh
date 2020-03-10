<template>
  <div id="app">
    <img src="./assets/logo.png">
    <router-link :to="{path: '/Footer'}">Footer</router-link>
    <router-link :to="{path: '/Home'}">Home</router-link>
    <router-link :to="{path: '/BottomNavigation'}">BottomNavigation</router-link>
    <router-view/>
    <!-- <bottomNavigation></bottomNavigation> -->
  </div>
</template>

<script>
// import bottomNavigation from './components/bottomNavigation'
import bottomNavigation from '@/components/BottomNavigation'
export default {
  name: 'App',
  components: {
      bottomNavigation
  }
}
</script>

<style>
#app {
  font-family: 'Avenir', Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
</style>
