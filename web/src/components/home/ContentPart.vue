<template>
    <div class="ContentPart">
        <div class="container">
            <div class="row top">
                <div class="col-8 contentLeft">
                    <div class="navbar1">
                        <span class="navbar-item">关注</span>
                        <!-- <span class="navbar-item">推荐</span> -->
                        <router-link :to="{name:'hot'}" class="navbar-item">推荐</router-link>
                        <router-link :to="{name:'video'}" class="navbar-item">视频</router-link>
                        <!-- <span class="navbar-item">视频</span> -->
                        <router-link :to="{name:'chat'}" class="navbar-item">聊天</router-link>
                    </div>
                    <slot></slot>
                </div>
                <div class="col contentRight">
                    <div class="CreateCenter">
                        <div class="title">
                            <svg class="icon sanjiao icon1" aria-hidden="true">
                                <use xlink:href="#icon-chuangzuo"></use>
                            </svg>
                            <span class="icon1">创作中心</span>
                        </div>
                        <div class="body">
                            <div class="item">
                                <svg class="icon sanjiao icon2" aria-hidden="true">
                                    <use xlink:href="#icon-shipin"></use>
                                </svg>
                                <span>发视频</span>
                            </div>
                            <div class="item">
                                <svg class="icon sanjiao icon2" aria-hidden="true">
                                    <use xlink:href="#icon-icon-test"></use>
                                </svg>
                                <span>发文章</span>
                            </div>
                        </div>
                    </div>
                    <div class="recommend">
                        <div class="title">你可能感兴趣的人</div>
                        <div class="useritem">
                            <div class="left">
                                <img src="@/assets/rabbit.jpg" alt="" class="img-fluid">
                                <div class="message">
                                    <span class="spant">username</span>
                                    <span class="spanb">introduce</span>
                                </div>
                            </div>
                            <div class="right">
                                <svg class="icon sanjiao icon3" aria-hidden="true">
                                    <use xlink:href="#icon-jiahao1"></use>
                                </svg>
                                <div>关注</div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>     
    </div>
</template>

<script>
export default{
    name:'ContentPart',
}
</script>

<style scoped>
.container{
    max-width: 1000px;
}
.contentLeft{
    border: 1px solid lightgray;
    margin-right: 10px;
    background-color: white;
    margin-top: 8px;
    border-radius: 10px;
}

.contentRight{
    margin-top: 9px;
    border-radius: 10px;
    
}

.navbar1{
    display: flex;
    padding-top: 8px;
    padding-bottom: 8px;
    border-bottom: solid 1px rgba(211, 211, 211, 0.368);
}

.navbar-item{
    margin-right: 30px;
    font-size: 16px;
    flex-shrink: 0;
}

a{
    text-decoration: none;
    color: black;
}

a:hover{
    color: rgba(0, 21, 255, 0.715);
}

.CreateCenter{
    background-color: white;
    border-radius: 5px;
    border: 1px solid black;
    margin-top: 10px;
} 

.title{
    margin-top: 10px;
}

.icon1{
    margin-left: 10px;
}

.body{
    display: flex;
    margin-top: 10px;
    justify-content: space-around;
}

.item{
    margin-right: 20px;
    display: flex;
    flex-direction: column;
    align-items: center;
}

.icon2{
    width: 40px;
    height: 40px;
}

.recommend{
    background-color: white;
    border: 1px solid black;
    margin-top: 10px;
    font-size: 13px;
    border-radius: 5px;
}

img{
    border-radius: 50%;
    width: 45px;
    height: 45px;
    margin-right: 10px;
    margin-left: 10px;
}

.useritem{
    display: flex;
    justify-content: space-between;
    align-items: center;
    margin-top: 5px;
}

.left{
    width: 60%;
    display: flex;
    align-items: center;
}

.message{
    display: flex;
    flex-direction: column;
}

.right{
    width: 60px;
    height: 30px;
    display: flex;
    align-items: center;
    border: 1px solid orange;
    border-radius: 10px;
    margin-right: 30px;
    text-align: center;
    line-height: 28px;
}

.right:hover{
    background-color: orange;
    cursor: pointer;
}

.spanb{
    font-weight: 330;
}

</style>