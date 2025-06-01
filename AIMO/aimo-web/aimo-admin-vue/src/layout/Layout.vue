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
          <el-menu-item index="/">首页</el-menu-item>
          <el-menu-item index="/users">用户管理</el-menu-item>
          <el-menu-item index="/posts">帖子管理</el-menu-item>
        </el-menu>
      </el-aside>

      <el-main>
        <router-view />
      </el-main>
    </el-container>
  </el-container>
</template>

<script setup lang="ts">
// 这里暂时不写脚本逻辑
</script>