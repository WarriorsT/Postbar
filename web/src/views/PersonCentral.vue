<template>
    <img src="../assets/robot.jpg" alt="" class="all">
    <div class="PersonalCentral">
        <div class="container">
            <div class="row justify-content-md-center">
                <div class="col-2 left">
                    <div class="contentleft">
                        <div class="userimg">
                            <img :src="store.state.user.picurl" alt="" class="topimg img-fluid">
                        </div>
                        <hr>
                        <div class="middle">
                            @{{ store.state.user.username }}
                        </div>
                        <hr>
                        <div class="bottom">
                            <div class="guanzhu item">
                                <span>关注数</span>
                                <span>66</span>
                            </div>
                            <div class="followers item">
                                <span>粉丝数</span>
                                <span>66</span>
                            </div>
                        </div>
                        <div class="introduce">
                            <span>个性签名 :人没有梦想，和咸鱼有什么区别</span>
                        </div>
                    </div>
                </div>
                <div class="col-7 right">
                    <div class="righttop">
                        <NavBar></NavBar>
                        <slot></slot>
                    </div>
                </div>
            </div>
        </div>
    </div>
</template>

<script>
import { useStore } from 'vuex';
import NavBar from '../components/personal/NavBar.vue'
export default{
    components:{
        NavBar
    },
    setup(){
        const store = useStore();
        store.dispatch('getPosts');
        return{
            store,
        }
    }
}
</script>

<style scoped>
.contentleft{
    background-color: white;
    border-radius: 10px;
    padding-top: 10px;
    padding-left: 10px;
    padding-right: 10px;
}
.userimg{
    text-align: center;
}
.right{
    border-radius: 10px;
    background-color: #fff;    
    margin-top: 10px;
}
.left{
    margin-right: 30px;
    margin-left: 30px;
    padding: 0; 
    padding-top: 10px;
}
.middle{
    text-align: center;
    font-weight: 800;
}
.topimg{
    width: 180px;
    height: auto;
}

.all{
    position: absolute;
    z-index: -999;
    width: 100%;
    min-width: 1000px;
}

.bottom{
    display: flex;
    justify-content: space-around;
}

.item{
    display: flex;
    flex-direction: column;
    align-items: center;
    font-size: 12px;
}

.introduce{
    margin-top: 10px;
    margin-bottom: 20px;
    margin-left: 5px;
    font-size: 13px;
}

hr{
    color: rgb(172, 169, 169);
}
</style>
