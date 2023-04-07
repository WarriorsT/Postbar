<template>
    <div class="MyPost">
        <PersonCentral> 
            <div class="item" v-for="post in posts" :key="post.id">
                <div class="top">   
                    <img :src="store.state.user.picurl" class="img-fluid" alt="...">
                    <span>{{ store.state.user.username }}</span>
                </div>
                <div class="body">
                    <p @click="changePostid(post.id)">
                        <span data-bs-toggle="collapse" data-bs-target="#collapseWidthExample" aria-expanded="false" aria-controls="collapseWidthExample">
                            {{ post.title }}
                        </span>
                    </p>
                    <div style="min-height: 120px;" v-if="post.id === postid">
                        <div class="collapse collapse-horizontal" id="collapseWidthExample">
                            <div class="card card-body" style="width: 500px;">
                                {{  post.content }}
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </PersonCentral>
    </div>
</template>

<script>
import PersonCentral from '@/views/PersonCentral.vue';
import { useStore } from 'vuex';
import { ref } from 'vue';
export default{
    components:{
        PersonCentral,
    },

    setup(){
        let postid = ref(null)
        const store = useStore();
        let posts = ref([]);
        posts.value = store.state.user.posts;

        const changePostid = (id)=>{
            postid.value = id;
        }
        return{
            store,
            posts,
            changePostid,
            postid,
        }
    }
}
</script>

<style scoped>
.item{
    width: 100%;
    border: 1px solid rgb(194, 192, 192);
    border-radius: 10px;
    padding: 5px;
}
img{
    width: 35px;
    height: 35px;
    border-radius: 50%;
    margin-right: 10px;
}

.body{
    margin-top: 10px;
}

p{
    margin-bottom: 0;
}

</style>