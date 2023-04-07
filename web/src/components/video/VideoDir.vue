<template>
    <div>
        <el-row :gutter="20" type="flex" justify="center">
            <el-col :span="12 ">
                <div class="grid-content bg-purple left">
                    <div class="title">
                        <h4>{{ videopojo.title }}</h4>
                        <div class="items">
                            <div class="item">
                                <svg class="icon bottom" aria-hidden="true">
                                    <use xlink:href="#icon-t24gl-playSquare-copy"></use>
                                </svg>
                                <span>{{ videopojo.visits }}</span>
                            </div>
                            <div class="item">
                                <svg class="icon bottom" aria-hidden="true">
                                    <use xlink:href="#icon-pinglun"></use>
                                </svg>
                                <span>520</span>
                            </div>
                            <div class="item">
                                <svg class="icon bottom" aria-hidden="true">
                                    <use xlink:href="#icon-shijian"></use>
                                </svg>
                                <span>{{ videopojo.time }}</span>
                            </div>
                        </div>
                    </div>
                    <video
                        :src="videopojo.videourl"
                        :poster="videopojo.picurl"
                        class="object-fit-contain tvideo" 
                        ref="video"
                        muted="muted"
                        autoplay
                        controls="controls"
                        >
                    </video>
                    <div class="input-group mb-3">
                        <input type="text" class="form-control" placeholder="发个友善的弹幕吧~" aria-label="Recipient's username" aria-describedby="button-addon2" style="background-color: #e5e9f2;">
                        <button class="btn btn-primary" type="button" id="button-addon2">发送弹幕</button>
                    </div>
                    <div class="items-bottom">
                        <div class="item1">
                            <svg class="icon bottom" aria-hidden="true">
                                <use xlink:href="#icon-dianzan1"></use>
                            </svg>
                            <span>点赞</span>
                        </div>
                        <div class="item1">
                            <svg class="icon bottom" aria-hidden="true">
                                <use xlink:href="#icon-shoucang"></use>
                            </svg>
                            <span>收藏</span>
                        </div>
                        <div class="item1">
                            <svg class="icon bottom" aria-hidden="true">
                                <use xlink:href="#icon-arrow-"></use>
                            </svg>
                            <span>转发</span>
                        </div>
                    </div>
                    <div class="introduce">
                        不喜勿喷，如果你喜欢我的视频，那就一键三连吧~
                    </div>
                </div>
            </el-col>
            <el-col :span="8">
                <div class="grid-content bg-purple">
                    <div class="top">
                        <img src="@/assets/rabbit.jpg" alt="">
                        <div class="author">
                            <span class="username">一路向北</span>
                            <span class="motto">我的身边并不拥挤，除了篮球就是你</span>
                        </div>
                    </div>
                </div>
                <div class="lists">
                    <h6 style="margin-bottom: 10px;">猜你想看</h6>
                        <div class="list" v-for="item in videos" :key="item.id" v-show="item.id != id">
                        <router-link :to="'/video/' + item.id">
                            <video
                                :src="item.videourl"
                                :poster="item.picture"
                                class="object-fit-contain" 
                                ref="video"
                                muted="muted"
                                style="width: 40%; border-radius: 10px;"
                                >
                            </video>
                            <div class="state">
                                <span>{{item.title}}</span>
                                <div class="sign">
                                    <svg class="icon bottom" aria-hidden="true">
                                        <use xlink:href="#icon-t24gl-playSquare-copy"></use>
                                    </svg>
                                    <span>{{ item.visits }}</span>
                                </div>
                            </div>
                        </router-link>
                    </div>
                </div>
            </el-col>
        </el-row>
    </div>
</template>

<script>
import { ref, watch } from 'vue';
import { useRoute } from 'vue-router';
import {getVideos} from '@/request/api/video'
import { init } from 'events';

export default{
    setup(){
        let videopojo = ref('');
        let videos = ref([]);
        const route = useRoute()
        const id = route.params.id;

        watch(route, () =>{
            console.log(7777777777777777);
            location. reload();
            route.go(0);
            init()
        })

        //获取视频
        getVideos().then((resp)=>{
            videopojo.value = resp.data[id - 1];
            videos.value = resp.data;
        })

        return{
            id,
            videopojo,
            videos
        }
    }
}
</script>

<style scoped>
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
background: #e5e9f2;
}
.grid-content {
border-radius: 4px;
min-height: 36px;
}
.row-bg {
padding: 10px 0;
background-color: #f9fafc;
}
/* 标题样式 */
.title{
    margin-top: 20px;
}
h1{
    margin: 0;
}
.items{
    display: flex;
    align-items: center;
}
.item{
    margin-right: 10px;
    color: rgb(113, 111, 111);
}
/* 视频样式 */
.tvideo{
    width:100%;
    margin-top: 20px;
    border-radius: 6px;
}
.items-bottom{
    display: flex;
    align-items: center;
}
.item1{
    margin-right: 30px;
    font-size: 20px;
}
.introduce{
    margin-top: 10px;
}
/* 右侧样式 */
.top{
    display: flex;
    align-items: center;
    margin-top: 20px;
    height: 50px;
}
img{
    width: 50px;
    height: 50px;
    border-radius: 50%;
}
.author{
    display: flex;
    flex-direction: column;
    margin-left: 20px;
}
.motto{
    color:rgb(163, 162, 162);
}
/* 右侧播放列表 */
.lists{
    margin-top: 20px;
}
.list{
    display: flex;
    margin-bottom: 20px;
}
.state{
    display: flex;
    flex-direction: column;
    margin-left: 10px;
}
.sign{
    display: flex;
    align-items: center;
}

a{
    display: flex;
    margin-bottom: 10px;
    text-decoration: none;
    color: black;
}
</style>