<template>
    <ContentPart>
        <div class="VideoView">
            <el-row :gutter="20">
                <el-col :span="12">
                    <div class="grid-content bg-purple">
                        <div v-for="item in videos" :key="item.id" class="divleft" v-show="item.id % 2 == 1">
                            <div class="video-content">
                                <router-link :to="'/video/' + item.id">
                                    <img 
                                        :src="item.picture" 
                                        alt="" 
                                        style="width: 100%;" 
                                        @mouseover="change"
                                        class="replace"
                                    > 
                                    <div class="d1">
                                        <svg class="icon bottom" aria-hidden="true">
                                            <use xlink:href="#icon-t24gl-playSquare"></use>
                                        </svg>
                                        <span class="bottomspan">{{ item.visits }}</span>
                                        <div class="duration" ref="item">13:14</div>
                                    </div>
                                </router-link>
                            </div>  
                            <div class="video-info">{{ item.title }}</div> 
                            <div class="author">
                                <svg class="icon" aria-hidden="true">
                                    <use xlink:href="#icon-UPzhu"></use>
                                </svg>
                                <sapn class="username">{{usernames[item.user]}}·</sapn>
                                <span>{{item.time}}</span>
                            </div> 
                        </div>
                    </div>
                </el-col>
                <el-col :span="12">
                    <div class="grid-content bg-purple-light">
                        <div v-for="item in videos" :key="item.id" class="divright" v-show="item.id % 2 == 0">
                            <div class="video-content">
                                <router-link :to="'/video/' + item.id">
                                    <img 
                                        :src="item.picture" 
                                        alt="" 
                                        style="width: 100%;" 
                                        @mouseover="change"
                                        class="replace"
                                    > 
                                    <div class="d1">
                                        <svg class="icon bottom" aria-hidden="true">
                                            <use xlink:href="#icon-t24gl-playSquare"></use>
                                        </svg>
                                        <span class="bottomspan">{{ item.visits }}</span>
                                        <div class="duration" ref="item">13:14</div>
                                    </div>
                                </router-link>
                            </div>  
                            <div class="video-info">{{ item.title }}</div> 
                            <div class="author">
                                <svg class="icon" aria-hidden="true">
                                    <use xlink:href="#icon-UPzhu"></use>
                                </svg>
                                <sapn class="username">{{usernames[item.user]}}·</sapn>
                                <span>{{item.time}}</span>
                            </div> 
                        </div>
                    </div>
                </el-col>
            </el-row>
        </div>
    </ContentPart>
</template>

<script>
import ContentPart from '@/components/home/ContentPart.vue';
import { ref } from 'vue';
import {getVideos, getUsername} from '../request/api/video'
export default{
    components:{
        ContentPart,
    },
    setup(){
        let videodom= ref(null);
        let videos = ref([]);
        let usernames = ref([]);

        //获取所有视频
        getVideos().then((resp)=>{
            videos.value = resp.data;
            console.log(videos.value);
        })

        //获取用户名
        getUsername().then((resp)=>{
            usernames.value = resp.data;
        });

        return {
            videodom,
            videos,
            usernames,
        }
    }
}
</script>

<style scoped>
/* 视频样式 */
video{
    width: 100%;
    border-radius: 10px;
    outline: none;
}

video:hover{
    cursor: pointer;
}

/* 布局样式 */
.el-row {
margin-bottom: 20px;

}
.el-col {
border-radius: 4px;
}
.bg-purple-dark {
background: #99a9bf;
}
.bg-purple {
background: white;
}
.bg-purple-light {
background: white;
}
.grid-content {
border-radius: 4px;
min-height: 36px;
}
.row-bg {
padding: 10px 0;
background-color: #f9fafc;
}
/* 视频布局 */
.video-content{
   width: 100%;
   position: relative;
}
.duration{
    position: absolute;
    right: 5px;
    bottom: 8px;
    color: white;
}
.bottom{
    position: absolute;
    left: 10px;
    bottom: 10px;
}
.bottomspan{
    position: absolute;
    left: 32px;
    bottom: 8px;
    color: white;
}
.video-info{
    margin-left: 3px;
    color: black;
}
.author{
    display: flex;
    align-items: center;
    color: rgb(141, 137, 137);
}
.username{
    margin-right: 10px;
}
.replace{
    border-radius: 10px;
    margin-bottom: 6px;
}
a{
    text-decoration: none;
}
.divleft,.divright{
    margin-bottom: 20px;
}
</style>