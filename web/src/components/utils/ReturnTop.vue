<template>
    <div class="returntop">
        <li :class="backTopFlag ? 'active' : 'inactive'" @click="backTop">
            <i class="icon5"></i>
            <p>回到顶端</p>
        </li>
    </div>
</template>

<script>
import { ref, onMounted, onUnmounted } from 'vue'
export default{
    setup(){
        const backTopFlag = ref(false)//用来判断样式
        const backTop = () => {
        let top = document.documentElement.scrollTop//获取点击时页面的滚动条纵坐标位置
        const timeTop = setInterval(() => {
            document.documentElement.scrollTop = top -= 50//一次减50往上滑动
            if (top <= 0) {
            clearInterval(timeTop)
            }
        }, 5)//定时调用函数使其更顺滑
        }
        const handleScroll = () => {
        if (document.documentElement.scrollTop > 20) {
            backTopFlag.value = true
        } else {
            backTopFlag.value = false
        }
        //往下滑超过20则显示 否则则不显示按钮
        }
 
        onMounted(() => {
        window.addEventListener('scroll', handleScroll)
        })//监听滚动事件
        onUnmounted(() => {
        window.removeEventListener('scroll', handleScroll)
        })//离开页面时移除监听事件

        return{
            backTopFlag,
            backTop,
            handleScroll
        }
    }
}
</script>

<style scoped>
li{
    list-style: none;
}
.side .active {
  animation: active 1s;
  -webkit-animation: active 1s;
  overflow: hidden;
}
@keyframes active {
  0% {
    height: 0px;
  }
 
  100% {
    height: 60px;
  }
}
.side .inactive {
  animation: inactive 1s;
  -webkit-animation: inactive 1s;
  animation-fill-mode: forwards;
  overflow: hidden;
}
 
@keyframes inactive {
  0% {
    height: 60px;
  }
 
  100% {
    height: 0px;
  }
}

.returntop{
    width: 80px;
    height: 25px;
    text-align: center;
    background-color: rgba(0, 0, 255, 0.265);
    position: fixed;
    right: 10px;
    bottom: 30px;
}
</style>