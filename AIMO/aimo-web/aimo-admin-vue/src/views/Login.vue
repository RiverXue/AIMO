<template>
  <el-form :model="form" label-width="80px" class="login-form">
    <el-form-item label="用户名">
      <el-input v-model="form.username" placeholder="请输入用户名" />
    </el-form-item>
    <el-form-item label="密码">
      <el-input type="password" v-model="form.password" placeholder="请输入密码" />
    </el-form-item>
    <el-form-item>
      <el-button type="primary" @click="handleLogin">登录</el-button>
    </el-form-item>
  </el-form>
</template>

<script setup lang="ts">
// 导入reactive函数，用于创建响应式数据
import { reactive } from 'vue'
// 导入useRouter钩子，用于获取路由对象
import { useRouter } from 'vue-router'
// 导入自定义的request函数，用于发送请求
import request from '../utils/request'

const router = useRouter()

const form = reactive({
  username: '',
  password: ''
})

const handleLogin = async () => {
  try {
    const res = await request.post('/user/login', {
      username: form.username,
      password: form.password
    })
    if (res.data) { // 直接判断res.data是否存在，因为后端直接返回token字符串
      localStorage.setItem('token', res.data) // 直接使用res.data作为token
      router.push('/admin')  // 登录成功跳首页
    } else {
      alert('登录失败：未获取到token')
    }
  } catch (error) {
    alert('登录失败：用户名或密码错误')
    console.error(error)
  }
}
</script>

<style scoped>
.login-form {
  width: 400px;
  margin: 100px auto;
}
</style>
