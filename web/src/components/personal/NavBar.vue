<template>
    <div class="navbar1">
        <router-link :to="{name:'mypost'}"><div class="item">帖子</div></router-link>
        <router-link :to="{name:'myvideo'}"><div class="item">视频</div></router-link>
    </div>
</template>

<script>
import { useStore } from 'vuex';
export default{
    setup(){
        const store = useStore();

        return{
            store,
        }
    }
}
</script>

<style scoped>
.navbar1{
    display: flex;
    margin-top: 5px;
}

.item{
    width: 60px;
   color: #337ab7;
   height: 40px;
   text-align: center;
   line-height: 40px;
   border-radius: 10px;
}

.item:hover{
    cursor: pointer;
    background-color: rgba(128, 128, 128, 0.361);
}

a{
    text-decoration: none;
}
</style>