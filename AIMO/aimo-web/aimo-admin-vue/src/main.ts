import { createApp } from 'vue'
import './style.css'
import App from './App.vue'
import router from './router'

// 导入ElementPlus和样式
import ElementPlus from 'element-plus'
import 'element-plus/dist/index.css'

// 创建并挂载根实例
const app = createApp(App) //创建应用实例
app.use(ElementPlus) //使用ElementPlus组件库
app.use(router) //挂载路由
app.mount('#app') //将vue挂载应用到id为app的元素上
