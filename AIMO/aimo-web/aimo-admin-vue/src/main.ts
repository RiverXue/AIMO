// 启动文件，用于初始化vue
import { createApp } from 'vue'
// 导入了全局样式
import './style.css'
// 导入了App.vue，作为根组件，相当于容器
import App from './App.vue'
// 导入路由，路由是告诉vue，不同url对应不同的组件
import router from './router'

// 导入ElementPlus组件库，用于创建组件
import ElementPlus from 'element-plus'
// 导入了它的默认样式
import 'element-plus/dist/index.css'

// 创建实例的第一步
const app = createApp(App) //createApp(App)接收根组件作为参数，返回一个vue实例。这个 app 实例是整个 Vue 应用的“大脑”，它管理着应用的所有配置、组件、插件等。
app.use(ElementPlus) //安装ElementPlus组件库
app.use(router) //安装路由，router会接管应用程序的url管理，并且根据配置显示组件
app.mount('#app') //这是将 Vue 应用“挂载”到 HTML 页面上的最后一步。 app.mount('#app') 告诉 Vue 将整个应用程序渲染到 index.html 文件中 id 为 app 的 HTML 元素上。通常，您的 index.html 文件中会有一个 <div id="app"></div> 标签，Vue 应用的所有内容都会在这个 div 内部生成。

