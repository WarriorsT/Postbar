<template>
  <img src="../assets/rabbit1.jpg" alt="" class="bgimg">
  <div class="login">
    <div class="frame">
      <div class="top">
        <div class="title">PostBar</div>
      </div>
      <div class="middle">
        <div class="input-group mb-3 username item">
          <input v-model="username" type="text" class="form-control" placeholder="请输入用户名" aria-label="Username">
        </div>
        <div class="input-group mb-3 password item">
          <input v-model="password" type="password" class="form-control" placeholder="请输入您的密码" aria-label="password">
        </div>
        <div class="item">
          <input class="btn btn-primary button" type="submit" value="登陆" @click="login">
        </div>
      </div>
      <div class="foot">
        <div class="footCont">其他方式登陆</div>
      </div>
    </div>
  </div>
</template>

<script>
import router from '@/router';
import { useStore } from 'vuex';
import axios from 'axios';
import { ref } from 'vue';

export default {
  name: "LoginView",
  setup(){
    let username = ref('');
    let password = ref('');
    const store = useStore();

    //登陆
    const login = ()=> {
      axios({
        method:'post',
        url:'http://localhost:3000/user/login',
        data:{
          username:username.value,
          password:password.value,
        }
      }).then(function (resp) {
        console.log(resp);
        if(resp.data.errorMessage === 'success'){
          router.push({name:'hot'});
          localStorage.setItem('token', resp.data.jwtToken);
          store.commit("updateToken", resp.data.jwtToken);
          store.dispatch("getInfo");
        }
      })
    }

    return{
      username,
      password,
      login,
    }
  }
}
</script>

<style scoped>
.login{
  position: absolute;
  width: 100%;
  height: 100%;
  display: flex;
  justify-content: center;
  align-items: center;
}

.frame{
  height: 500px;
  width: 500px;
  background-color:lightblue;
}

.bgimg{
  position: absolute;
  width: 100%;
  height: 100%;
  z-index: -1;
}

.top{
  width: 100%;
  height: 125px;
}

.title{
  font-size: 56px;
  margin-left: 30px;
  padding-top: 30px;
}

.middle{
  height: 50%;
  display: flex;
  flex-direction: column;
  align-items: center;
}

.item{
  width: 400px;
  margin: 8px;
}

.button{
  width: 400px;
}

.footCont{
  margin-left: 190px;
  margin-top: 10px;
}
</style>