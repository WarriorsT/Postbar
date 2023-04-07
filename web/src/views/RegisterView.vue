<template>
  <img src="../assets/rabbit.jpg" alt="" class="bgimg">
  <div class="register">
    <div class="frame">
      <div class="top">
        <div class="title">PostBar</div>
      </div>
      <div class="middle">
        <div class="input-group mb-3 username item">
          <input v-model="username" type="text" class="form-control" placeholder="请设置用户名" aria-label="Username">
        </div>
        <div class="input-group mb-3 password item">
          <input v-model="password" type="password" class="form-control" placeholder="请设置您的密码" aria-label="password">
        </div>
        <div class="input-group mb-3 confirmedPassword item">
          <input v-model="confirmedPassword" type="password" class="form-control" placeholder="请确认您的密码" aria-label="confirmedPassword">
        </div>
        <div class="item">
          <input class="btn btn-primary button" type="submit" value="注册" @click="register">
        </div>
      </div>
      <div class="foot">
        <div class="footCont">其他方式登陆</div>
      </div>
    </div>
  </div>
</template>

<script>
import { ref } from 'vue';
import axios from 'axios';
import router from '@/router';

export default {
  name: "RegisterView",

  setup(){
    let username = ref('');
    let password = ref('');
    let confirmedPassword = ref('');

    const register = ()=> {
      axios({
        method:'post',
        url:'http://localhost:3000/user/register',
        data:{
          username:username.value,
          password:password.value,
          confirmedPassword:confirmedPassword.value,
        }
      }).then(function (resp){
        console.log(resp);
        if(resp.data.errorMessage === 'success'){
          router.push({name:'login'});
        }
      })
    }

    return{
      username,
      password,
      confirmedPassword,
      register
    }
  }
}
</script>

<style scoped>
.register{
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
  background-color: lightyellow;
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