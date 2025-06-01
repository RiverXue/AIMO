import { createRouter, createWebHistory } from 'vue-router'
import Layout from '../layout/Layout.vue'
import Home from '../views/Home.vue'
import User from '../views/User.vue'
import Post from '../views/Post.vue'

const routes = [
    {
        path: '/',
        component: Layout,
        children: [
            {
                path: '',
                name: 'Home',
                component: Home
            },
            {
                path: 'user',
                name: 'User',
                component: User
            },
            {
                path: 'post',
                name: 'Post',
                component: Post
            }
        ]
    },
    // 你后续的路由写这里
]
 // 创建路由实例
const router = createRouter({
    // 使用 HTML5 历史模式
    history: createWebHistory(),
    // 定义路由
    routes
})
// 导出路由实例，以便在 main.ts 中使用
export default router
