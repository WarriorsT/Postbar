<template>
  <div class="home">
    <div class="bgc"></div>
    <ContentPart></ContentPart>
  </div>
</template>

<script>
import ContentPart from "@/components/home/ContentPart.vue";
export default {
  name: 'HomeView',
  components: {
    ContentPart,
  },
}
</script>

<style scoped>
/* .bgc{
    position: absolute;
    z-index: -999;
    height: 100%;
    width: 100%;
    background-color: rgba(18, 18, 18, 0.098);
    background-color: black;
    min-width:3000px;
    min-height: 800px;
} */
</style>
