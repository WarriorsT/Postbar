import axios from "axios";

export default {
  state: {
    id:"",
    username:"",
    picurl:"",
    token:"",
    posts:[],
    isLogin:false,
  },
  getters: {
  },
  mutations: {
    updateUser(state, user){
        state.id = user.id;
        state.username = user.username;
        state.picurl = user.picurl;
        state.isLogin = true;
    },
    updateToken(state, token){
        state.token = token;
    },
    logout(state){
      localStorage.removeItem('token');
      state.isLogin = false;
    }
  },
  actions: {
    getInfo(context){
        axios({
            method:'get',
            url:'http://localhost:3000/user/userinfo',  
            headers:{
              Authorization:"Bearer " + context.state.token
            }
        }).then((resp)=>{
            //console.log(resp);
            context.commit("updateUser", resp.data);
            axios({
              method:'get',
              url:`http://localhost:3000/person/${resp.data.id}`,
            }).then((resp)=>{
              context.state.posts = resp.data;
            })
        })
    },
  },
  modules: {
  }
}
