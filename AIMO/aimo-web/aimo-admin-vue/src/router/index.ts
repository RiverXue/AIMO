// 这是创建router的核心函数与历史模式
import { createRouter, createWebHistory} from 'vue-router'

// 路由规则定义
const routes = [
    {
        path: '/',
        name: 'Login',
        component: () => import('../views/Login.vue')
    },
    {
        path: '/admin',
        component: () => import('../layout/Layout.vue'), // ✅ 公共 Layout
        meta: { requiresAuth: true },
        children: [
            {
                path: '',
                name: 'Home',
                component: () => import('../views/Home.vue')
            },
            {
                path: 'users',
                name: 'Users',
                component: () => import('../views/User.vue')
            },
            {
                path: 'posts',
                name: 'Posts',
                component: () => import('../views/Post.vue')
            }
        ]
    }
]

// 传入历史模式和之前的路由规则
const router = createRouter({
    history: createWebHistory(),
    routes
})

// 路由守卫，在路由跳转之前执行
router.beforeEach((to, _from, next) => {
    if (to.meta.requiresAuth) {
        const token = localStorage.getItem('token')
        if (!token) {
            return next('/login')
        }
    }
    next()
})
// 暴露出去，意义在在于main.ts中使用，不暴露的话，无法使用
export default router
