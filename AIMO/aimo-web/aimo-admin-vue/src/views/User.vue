<template>
  <div>
    <h2>用户管理</h2>
    <el-table :data="users" style="width: 100%">
      <el-table-column prop="id" label="ID" width="180"></el-table-column>
      <el-table-column prop="username" label="姓名" width="180"></el-table-column>
    </el-table>
  </div>
</template>

<script setup lang="ts">
// 从vue导入ref用于创建响应式引用和onMounted函数会在组件挂载后立即调用 
import { ref,onMounted } from 'vue';
// 从api/user.ts导入getAllUsers函数
import {getAllUsers} from "../api/user.ts";
// 定义一个响应式引用users，用于存储所有用户数据
const users = ref([]);

// 在组件挂载后立即调用getAllUsers函数获取所有用户数据
// 并将其赋值给users.value
onMounted(async () => {
  try {
    const response = await getAllUsers();
    users.value = response.data;
  } catch (error) {
    console.error('获取所有用户失败', error);
  }
})
</script>.data