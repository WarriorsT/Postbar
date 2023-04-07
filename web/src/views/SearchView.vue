<template>
    <div class="bgc"></div>
    <div class="SearchView container-fluid">
        <div class="HotSearch" v-for="hot in hots" :key="hot.id">
            <div class="title">{{hot.title}}</div>
            <div class="content" v-if="hot.showall % 2 === 0">
                <img :src="hot.photo" alt="">
                <div class="passage">
                    {{ hot.content }}
                </div>
            </div>
            <div class="contentAll" v-if="hot.showall % 2 === 1">
                <div class="passageall">
                    {{ hot.content }}
                </div>
            </div>
            <div class="bottom">
                <div class="isApprove" @click="getBeloved(hot.user, hot.id)">
                    <svg class="icon sanjiao" aria-hidden="true">
                        <use xlink:href="#icon-top-s-copy"></use>
                    </svg>
                    <span>赞同</span>
                    <span >{{hot.beloved}}</span>
                </div>
                <div class="option-item">
                    <div class="comment" @click="openComment(hot.id)">
                        <router-link :to="{name:'search'}" class="navbar-item">
                            <svg class="icon sanjiao" aria-hidden="true">
                                <use xlink:href="#icon-pinglun1"></use>
                            </svg>
                        </router-link>
                        <router-link :to="{name:'search'}" class="navbar-item" @click="getComments(hot.user, hot.id), openComment">评论</router-link>
                    </div>
                    <div class="share">
                        <router-link :to="{name:'search'}" class="navbar-item">
                            <svg class="icon sanjiao" aria-hidden="true">
                                <use xlink:href="#icon-arrow-"></use>
                            </svg>
                        </router-link>    
                        <router-link :to="{name:'search'}" class="navbar-item">分享</router-link>
                    </div>
                    <div class="collect" @click="changeColor">
                        <router-link :to="{name:'search'}" class="navbar-item" v-if="color">
                            <svg class="icon sanjiao" aria-hidden="true">
                                <use xlink:href="#icon-shoucang"></use>
                            </svg>
                        </router-link>     
                        <router-link :to="{name:'search'}" class="navbar-item" v-else>
                            <svg class="icon sanjiao" aria-hidden="true">
                                <use xlink:href="#icon-shoucang-copy"></use>
                            </svg>
                        </router-link>                   
                        <router-link :to="{name:'search'}" class="navbar-item">收藏</router-link>
                    </div>
                    <div class="like" @click="changeLike">
                        <router-link :to="{name:'search'}" class="navbar-item love" v-if="like">
                            <svg class="icon sanjiao" aria-hidden="true">
                                <use xlink:href="#icon-xiai"></use>
                            </svg>
                        </router-link>
                        <router-link :to="{name:'search'}" class="navbar-item" v-else>
                            <svg class="icon sanjiao" aria-hidden="true">
                                <use xlink:href="#icon-xiai-copy"></use>
                            </svg>
                        </router-link>
                        <router-link :to="{name:'search'}" class="navbar-item">喜欢</router-link>
                    </div>
                    <div class="more">
                        <router-link :to="{name:'search'}" class="navbar-item">
                            <svg class="icon sanjiao" aria-hidden="true">
                                <use xlink:href="#icon-shenglvehao"></use>
                            </svg>
                        </router-link>
                    </div>
                </div>
                <div class="all" @click="showAll(hot.user, hot.id)">阅读全文</div>
            </div>
            <div v-show="show && hot.id === commentID" class="comment">
                <div class="top"> 
                    <router-link :to="{name:'person'}"><img :src="store.state.user.picurl" alt="" class="topimg img-fluid"></router-link>
                    <div class="input-group mb-3">
                        <input v-model="comment" type="text" class="form-control" placeholder="快来发表你的看法吧~~~" aria-label="Recipient's username" aria-describedby="button-addon2">
                        <button class="btn btn-outline-secondary" type="button" id="button-addon2" @click="deliver(store.state.user.id, hot.user, hot.id)">发布</button>
                        </div>
                    </div>
                <div class="container body" >
                    <div class="row bodyrow" v-for="comment in comments" :key="comment.id">
                        <div class="col">
                            <div class="main">
                                <div class="one">
                                    <div class="onehead">
                                        <img :src="comment.picurl" alt="" class="oneimg">
                                        <span class="name">{{comment.username}}</span>
                                    </div>
                                    <div class="onebody">
                                        {{ comment.comment }}
                                    </div>
                                    <div class="onefoot">
                                        <div class="reanswer">
                                            <svg class="icon sanjiao" aria-hidden="true">
                                                <use xlink:href="#icon-pinglun1"></use>
                                            </svg>
                                            <router-link :to="{name:'search'}" class="navbar-item">回复</router-link>
                                        </div>
                                        <div class="dianzan">
                                            <svg class="icon sanjiao" aria-hidden="true">
                                                <use xlink:href="#icon-dianzan1"></use>
                                            </svg>
                                            <router-link :to="{name:'search'}" class="navbar-item">{{comment.beloved}}</router-link>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <hr>
            </div>
        </div>
        <ReturnTop></ReturnTop>
    </div>
</template>

<script>
import { ref } from 'vue';
import axios from 'axios';
import { useStore } from 'vuex';
import ReturnTop from '@/components/utils/ReturnTop.vue';
export default{
    components:{
        ReturnTop
    },
    setup(){
        let hots = ref([]);
        let show = ref(false);
        let commentID = ref(null);
        let store = useStore();
        let comments = ref([]);
        let comment = ref('');
        let like = ref(true);
        let color = ref(true);
    
        //点击打开评论
        const openComment =(id)=>{
            show.value = !show.value
            commentID.value = id;
        }

        //清理页面状态
        axios({
            method:'post',
            url:'http://localhost:3000/hotsearch/update',
            headers:{
                Authorization:"Bearer " + localStorage.getItem('token')
            }
        }).then(()=>{
            axios({
            method:'get',
            url:'http://localhost:3000/hotlist',
            headers:{
                Authorization:"Bearer " + localStorage.getItem('token')
            }
        }).then(function(resp){
            hots.value = resp.data;
        });
        })

        //获取用户信息
        axios({
            method:'get',
            url:'http://localhost:3000/hotlist',
            headers:{
                Authorization:"Bearer " + localStorage.getItem('token')
            }
        }).then(function(resp){
            console.log(resp);
            hots.value = resp.data;
        });


        // 点赞数
        const getBeloved =(user, id)=>{
            axios({
                method:'get',
                url:`http://localhost:3000/hotsearch/beloved/${user}/${id}`,
            }).then(()=>{
                axios({
                    method:'get',
                    url:'http://localhost:3000/hotlist',
                    headers:{
                        Authorization:"Bearer " + localStorage.getItem('token')
                    }
                }).then(function(resp){
                    console.log(resp);
                    hots.value = resp.data;
                });
            })
        }

        //页面状态
        const showAll=(user, id)=>{
            axios({
                method:'post',
                url:`http://localhost:3000/hotsearch/update/${user}/${id}`,
            }).then(()=>{
                axios({
                    method:'get',
                    url:'http://localhost:3000/hotlist',
                    headers:{
                        Authorization:"Bearer " + localStorage.getItem('token')
                    }
                }).then(function(resp){
                    hots.value = resp.data;
                });
            })
        }

        //获取评论
        const getComments =(hotuser, hotid)=>{
            axios({
                method:'get',
                url:`http://localhost:3000/hotsearch/comments/${hotuser}/${hotid}`,
            }).then((resp)=>{
                console.log(resp);
                comments.value = resp.data;
            })
        }

        //发布评论
        const deliver =(user, hotuser, hotid)=>{
            axios({
                method:'post',
                url:'http://localhost:3000/hotsearch/addComment',
                data:{
                    user:user,
                    comment:comment.value,
                    hotuser:hotuser,
                    hotid:hotid
                }
            }).then((resp)=>{
                console.log(resp+"success");
                getComments(hotuser, hotid);
            })
        }

        //更改爱心颜色
        const changeLike =()=>{
            like.value = !like.value
        }

        //更改收藏颜色
        const changeColor =()=>{
            color.value = !color.value;
        }

        return {
            hots,
            getBeloved,
            showAll,
            openComment,
            show,
            commentID,
            store,
            getComments,
            comments,
            comment,
            deliver,
            like,
            changeLike,
            color,
            changeColor
        }
    }
}
</script>

<style scoped>


.SearchView{
    position: absolute;
    z-index: -999;
    height: 100%;
    width: 100%;
    background-color: rgba(18, 18, 18, 0.098);
    min-width:500px;
    min-width: 1000px;
    min-height: 800px;
}
/*  */
.bgc{
    position: absolute;
    z-index: -999;
    height: 100%;
    width: 100%;
    background-color: rgba(18, 18, 18, 0.098);
    min-width:500px;
    min-height: 800px;
}
img{
    width: 170px;
    height: 100px;
}

.title{
    font-weight: 600;
    font-size: 18px;
}

.HotSearch{
    border-bottom: 1px solid rgba(211, 211, 211, 0.646);
}

a{
    text-decoration: none;
    color: rgba(128, 128, 128, 0.71);
}

.image{
    margin-right: 10px;
}
.content{
    display: flex;
    margin-top: 5px;
    margin-bottom: 10px;
}

.content:hover{
    cursor: pointer;
}

.passage{
    margin-left: 10px;
    height: 100px;
    overflow: hidden;
    text-overflow: ellipsis;
    display: -webkit-box;
    /*重新定义-webkit私有盒模型*/
    -webkit-box-orient: vertical;
    /*内容之间的排列顺序，vertical垂直方向排列*/
    -webkit-line-clamp: 4;
    /*在第几行末尾显示省略号...*/
    /* white-space:nowrap; 文本不换行*/
}

.bottom{
    display: flex;
    align-items: center;
}

.isApprove{
    background-color: rgba(5,109,232,.1);
    height: 30px;
    width: 110px;
    margin-right: 30px;
    padding-top: 3px;
    padding-left: 8px;
}

.isApprove:hover{
    cursor: pointer;
    background-color: rgba(5, 107, 232, 0.205);
}

span{
    color: rgb(0, 64, 255);
    margin-left: 3px;
    margin-right: 3px;
}

.option-item{
    width: 300px;
    display: flex;
    flex-shrink: 0;
    justify-content: space-between;
}

.all{
    margin-left: 100px;
}

.all:hover{
    cursor: pointer;
    color: lightblue
}

/* 评论style */
.top{
    display: flex;
    height: 45px;
    margin-top: 10px;
}

.topimg{
    width: 35px;
    height: 35px;
    margin-right: 10px;
}

.bodyrow{
    border: 1px solid lightgray;
}

.head{
    border-bottom: 1px solid lightgray;
}

.one{
    margin-top: 10px;
}
.oneimg{
    height: 27px;
    width: 27px;
    margin-right: 5px;
    margin-left: 10px;
    border-radius: 50%;
}

.name{
    color: black;
    font-weight: 800;
}

.onebody{
    margin-left: 48px;
}

.onefoot{
    display: flex;
}

.reanswer{
    flex: 1;
    text-align: right;
}
cadcc   bbdca dabd（abcd）
.dianzan{
    margin-right: auto;
    margin-left: 10px;
}

.icon:hover{
    cursor: pointer;
}

ReturnTop{
    position: fixed;
    right: 0px;
}
</style>