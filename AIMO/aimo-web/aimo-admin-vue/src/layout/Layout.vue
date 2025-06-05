<template>
  <el-container class="hight: 100vh">
    <el-header style="background-color:#409eff; color: white;">
      <div style="font-size: 20px;">AIMO 后台管理系统</div>
    </el-header>

    <el-container>
      <el-aside width="200px" style="background-color:#f2f2f2;">
        <el-menu
            default-active="/"
            class="el-menu-vertical-demo"
            router
        >
          <el-menu-item index="/admin">首页</el-menu-item>
          <el-menu-item index="admin/users">用户管理</el-menu-item>
          <el-menu-item index="admin/post">帖子管理</el-menu-item>
        </el-menu>
      </el-aside>

      <el-main>
        <router-view />
      </el-main>
    </el-container>
  </el-container>
</template>

<script setup lang="ts">
// 以下引入了 Vue Router 的 useRoute 函数，用于获取当前路由信息。
import {useRoute} from "vue-router";
// 使用 useRoute 函数获取当前路由信息
const route = useRoute();
// 打印当前路由信息，以便调试
console.log(route);
</script>