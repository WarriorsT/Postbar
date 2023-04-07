<template>
  <NavBar></NavBar>
  <router-view/>
</template>

<script>
import 'bootstrap/dist/css/bootstrap.min.css'
import 'bootstrap/dist/js/bootstrap'
import NavBar from './components/home/NavBar.vue';

export default {
    name: "App",
    components: { NavBar }
}
</script>

<style>
*{
  margin: 0;
  padding: 0;
  box-sizing: border-box;
}

.icon{
  width: 20px;
  height: 20px;
}

</style>
