import { createApp } from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'
import ElementPlus from 'element-plus';
import 'element-plus/theme-chalk/index.css'

const app = createApp(App)
app.use(store).use(router).mount('#app')
app.use(ElementPlus)

// createApp(App).use(store).use(router).mount('#app')
