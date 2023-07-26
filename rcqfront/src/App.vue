/* eslint-disable no-console */
<template>
  <div>
    <div class="flex dark:bg-gray-800 scrollbar-hide">
      <Navbar></Navbar>
    </div>
    <div id="app">
      <router-view/>
    </div>
  </div>
</template>

<script>
import Navbar from './components/NavBar.vue'

export default {
  name: 'App',
  components: {
    Navbar
  }
}
</script>

<style>
/* 원하는 스타일을 추가할 수 있습니다. */
</style>
