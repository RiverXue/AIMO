import axios from 'axios'

const request = axios.create({
    baseURL: 'http://localhost:8080', // 后端user模块地址
    timeout: 5000
})

// 添加请求拦截器，在请求头中添加token，用于验证用户身份
request.interceptors.request.use(
    (config) => {
        const token = localStorage.getItem('token') // 这里要取你存的token
        if (token) {
            config.headers.Authorization = `Bearer ${token}`
        }
        return config
    },
    (error) => {
        return Promise.reject(error)
    }
)

request.interceptors.response.use(
    response => response,
    error => {
        if (error.response && error.response.status === 401) {
            alert('登录已过期，请重新登录')
            window.location.href = '/login' // 跳登录页
        }
        return Promise.reject(error)
    }
)

export default request
