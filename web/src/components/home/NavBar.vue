<template>
  <nav class="navbar navbar-expand-lg bg-white">
      <div class="container">
          <router-link :to="{name:'home'}" class="navbar-brand">PostBar</router-link>
          <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#collapsibleNavbar">
              <span class="navbar-toggler-icon"></span>
          </button>
          <div class="collapse navbar-collapse" id="collapsibleNavbar">
              <ul class="navbar-nav mb-2 mb-lg-0">
                  <li class="nav-item">
                      <router-link :to="{name:'hot'}" class="nav-link">首页</router-link>
                  </li>
                  <li class="nav-item">
                      <router-link :to="{name:'home'}" class="nav-link">会员</router-link>
                  </li>
                  <li class="nav-item">
                      <router-link :to="{name:'trace'}" class="nav-link">发现</router-link>
                  </li>
                  <li class="nav-item">
                      <router-link :to="{name:'home'}" class="nav-link">等你来答</router-link>
                  </li>
                  <form class="d-flex search ms-5">
                      <input class="form-control me-2 button" type="text" placeholder="快来提问呀~">
                      <button class="btn btn-primary" type="button" @click="$router.push('/search')">提问</button>
                  </form>
                  <li class="nav-item" v-if="!$store.state.user.isLogin">
                      <router-link :to="{name:'login'}" class="nav-link ">登陆</router-link>
                  </li>
                  <li class="nav-item login" v-if="!$store.state.user.isLogin">
                      <router-link :to="{name:'login'}" class="nav-link ">或</router-link>
                  </li>
                  <li class="nav-item" v-if="!$store.state.user.isLogin">
                      <router-link :to="{name:'register'}" class="nav-link">注册</router-link>
                  </li>
                  <li class="nav-item xiaoxi" v-if="$store.state.user.isLogin">
                    <svg class="icon" aria-hidden="true">
                      <use xlink:href="#icon-xiaoxi"></use>
                    </svg>
                    <router-link :to="{name:'login'}" class="nav-link foot ">消息</router-link>
                  </li>
                  <li class="nav-item sixin" v-if="$store.state.user.isLogin">
                    <svg class="icon" aria-hidden="true">
                      <use xlink:href="#icon--sixin"></use>
                    </svg>
                    <router-link :to="{name:'login'}" class="nav-link foot">私信</router-link>
                  </li>
                  <li class="nav-item dropdown" v-if="$store.state.user.isLogin">
                    <a class="nav-link dropdown-toggle select" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                      <img :src="$store.state.user.picurl" alt="Bootstrap">
                    </a>
                    <ul class="dropdown-menu menu">
                      <li><a class="dropdown-item" href="/mypost" >我的主页</a></li>
                      <li><a class="dropdown-item" href="#">设置</a></li>
                      <li><hr class="dropdown-divider"></li>
                      <li><a class="dropdown-item" href="#" @click="logout">退出</a></li>
                    </ul>
                  </li>
              </ul>
          </div>
      </div>
  </nav>
</template>

<script>
import { useStore } from 'vuex';
export default{
  name:"TraceView",

  setup(){
    const store = useStore();

    const token = localStorage.getItem('token');
    
    if(token){
      store.commit('updateToken', token);
      store.dispatch('getInfo');
    }

    const logout=()=>{
      store.commit("logout");
    }

    return {
      store,
      logout,
    }
  }
}
</script>

<style scoped>
.navbar{
  border-bottom: 1px lightgray solid;
}
.navbar-brand{
  color: #0d6efd;
}

.navbar-nav{
  flex-shrink: 0;
}
.button{
  width: 400px;
}

.search{
  margin-right: 170px;
}

.register{
  padding-right: 0;
  margin-right: 0;
}
img{
  width: 30px;
  height: 30px;
  border-radius: 50%;
}

.xiaoxi,.sixin{
  display: flex;
  flex-direction: column;
  align-items: center;
}

.foot{
  padding-top: 0;
  padding-bottom: 0;
  font-size: 12px;
}

.img{
  padding: 0;
  padding-top: 4px;
}

.select{
  padding-top: 2px;
}

.dropdown-menu {
  min-width: 0px !important;
}

nav{
  position: sticky;/* 新属性sticky */
   top: 0;/* 距离页面顶部距离 */
   z-index: 99;
}
</style>