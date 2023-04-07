import { createRouter, createWebHistory } from 'vue-router'
import HomeView from '../views/HomeView.vue'
import VideoDir from '../components/video/VideoDir'
import ChatView from '../views/ChatView'

const routes = [
  {
    path: '/',
    name: 'home',
    redirect: '/hot',
    component: HomeView
  },
  /*{
    path: '/about',
    name: 'about',
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () => import(/!* webpackChunkName: "about" *!/ '../views/AboutView.vue')
  }*/
  {
    //注册
    path: '/register',
    name: 'register',
    component: () => import('../views/RegisterView')
  },
  {
    //登陆
    path: '/login',
    name: 'login',
    component: () => import('../views/LoginView')
  },
  {
    //发现
    path: '/trace',
    name: 'trace',
    component: () => import('../views/TraceView')
  },

  /**home.contentPart*/
  {
    //发现
    path: '/hot',
    name: 'hot',
    component: () => import('../components/home/content/HotSearch')
  },

  /**个人中心页面*/
  {
    //发现
    path: '/person',
    name: 'person',
    component: () => import('../views/PersonCentral')
  },

  //个人中心页面帖子
  {
    //发现
    path: '/mypost',
    name: 'mypost',
    component: () => import('../components/personal/MyPost')
  },
  //个人中心页面视频
  {
    //发现
    path: '/myvideo',
    name: 'myvideo',
    component: () => import('../components/personal/MyVideo')
  },
  //搜索页面
  {
    path: '/search',
    name: 'search',
    component: () => import('../views/SearchView')
  },

  //视频页面
  {
    path: '/video',
    name: 'video',
    component: () => import('../views/VideoView'),
  },
  {
    path: '/video/:id',
    name: 'videoid',
    component:VideoDir
  },
  //聊天页面
  {
    path:'/chat',
    name:'chat',
    component:ChatView
  }
]

const router = createRouter({
  history: createWebHistory(),
  routes
})

export default router
