<template>
    <div>发现</div>
    <div>
        <button @click="copyInfo('我是copy的内容')">点我复制</button>
    </div>
</template>

<script>
import useClipboard from 'vue-clipboard3'
export default{
    name:"TraceView",
    components:{ 
    },

    setup() {
    const { toClipboard } = useClipboard()
    const copyInfo = async (info) => {
      try {
        await toClipboard(info)
        //ElMessage.success('复制成功')
      } catch (e) {
        //ElMessage.warning('您的浏览器不支持复制：', e)
      }
    }
    return { copyInfo }
  }
}
</script>

<style scoped>
</style> 

