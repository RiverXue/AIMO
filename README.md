---

## 📌 README.md（推荐内容）

````markdown
# 👋 欢迎来到 AIMO 项目

AIMO 是一个基于微服务架构的综合性应用平台，提供用户管理、社交互动、AI 助手、日记记录等功能。

本项目后端基于 **Spring Cloud Alibaba** 技术栈，前端使用 **Vue.js** 构建，支持 Web 管理端与移动端访问。

---

## 🌐 请选择您的语言 | Select your language

- 🇨🇳 [中文文档 (README_zh)](README_zh.md)
- 🇺🇸 [English Documentation (README_en)](README_en.md)

---

## 🚀 快速开始

```bash
# 克隆仓库
git clone https://github.com/RiverXue/AIMO.git
cd AIMO

# 启动基础设施服务（Docker）
docker-compose up -d

# 构建后端微服务
cd aimo-services
mvn clean install -DskipTests
````

---

## ⚙️ 技术栈

### 后端

* Spring Boot 3.x
* Spring Cloud Alibaba
* Nacos / MySQL / Redis / RabbitMQ / MinIO

### 前端

* Vue 3（Admin 后台）
* 移动端（开发中）

---

## 📁 项目结构简介

```
AIMO/
├── aimo-services/        # 后端微服务集合
│   ├── aimo-auth-server
│   ├── aimo-user-service
│   ├── aimo-diary-service
│   ├── aimo-social-service
│   └── ...其他服务
├── aimo-web/             # 前端项目
│   ├── aimo-admin-vue
│   └── aimo-mobile-app
├── docker/               # 环境配置（未来支持 docker-compose）
└── readme_zh.md          # 中文说明
    README_en.md          # English Docs
```

---

## 📄 License

© 2025 AIMO Team. All Rights Reserved.

````