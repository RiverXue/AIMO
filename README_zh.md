# AIMO 项目

## 项目概述

AIMO 是一个基于微服务架构的综合性应用平台，旨在提供用户管理、社交互动、AI 助手、日记记录等功能。该项目采用 Spring Cloud Alibaba 技术栈构建后端微服务，并使用 Vue.js 开发前端应用程序。

## 技术栈

### 后端技术

- **核心框架**：Spring Boot 3.x、Spring Cloud Alibaba
- **服务注册与发现**：Nacos
- **配置中心**：Nacos Config
- **网关**：Spring Cloud Gateway
- **ORM 框架**：MyBatis Plus、Spring Data JPA
- **数据库**：MySQL 8.0
- **消息队列**：RabbitMQ
- **对象存储**：MinIO
- **API 文档**：Springdoc OpenAPI (Swagger)
- **安全框架**：Spring Security、JWT

### 前端技术

- **管理后台**：Vue.js
- **移动应用**：待定

## 项目结构

### 后端微服务

- `aimo-services`: 包含所有后端 Spring Cloud Alibaba 微服务
    - `aimo-common`: 通用工具、实体类、DTO、异常处理和共享代码
    - `aimo-gateway`: API 网关，负责请求路由、负载均衡、认证授权等
    - `aimo-auth-server`: 认证和授权服务，处理用户登录、令牌管理等
    - `aimo-user-service`: 用户管理服务，处理用户注册、个人资料管理等
    - `aimo-diary-service`: 日记和心情管理服务，提供日记创建、查询、情感分析等功能
    - `aimo-social-service`: 社交功能服务，包括帖子、评论、点赞等社交互动功能
    - `aimo-ai-service`: AI 助手服务，提供智能对话、内容推荐等 AI 功能
    - `aimo-membership-service`: 会员管理服务，处理会员订阅、权益管理等
    - `aimo-admin-service`: 管理后台服务，提供系统管理、数据统计等功能
    - `aimo-message-service`: 消息处理服务，负责系统通知、用户消息等异步处理

### 前端应用

- `aimo-web`: 包含前端应用程序
    - `aimo-admin-vue`: 管理后台前端 (Vue.js)
    - `aimo-mobile-app`: 移动应用程序前端

## 基础设施服务

项目依赖以下基础设施服务，通过 Docker Compose 进行管理：

- **Nacos**: 服务注册发现和配置中心 (端口: 8848, 9848, 9849)
- **MySQL**: 数据库服务 (端口: 3336→3306)
- **RabbitMQ**: 消息队列 (端口: 5672, 管理界面: 15672)
- **MinIO**: 对象存储服务 (端口: 9000, 控制台: 9001)

## 入门指南

### 先决条件

- Java 17 或更高版本
- Maven 3.6.3 或更高版本
- Docker 和 Docker Compose
- Git

### 环境搭建

1. **克隆仓库**

   ```bash
   git clone <https://github.com/RiverXue/AIMO.git>
   cd AIMO
   ```

2. **启动基础设施服务**

   使用 Docker Compose 启动所需的基础设施服务：

   ```bash
   docker-compose up -d
   ```

   这将启动 Nacos、MySQL、RabbitMQ 和 MinIO 服务。

3. **构建后端微服务**

   导航到 `aimo-services` 目录并构建所有模块：

   ```bash
   cd aimo-services
   mvn clean install -DskipTests
   ```

4. **运行后端微服务**

   按照以下顺序启动各个服务：

   ```bash
   # 1. 首先启动网关
   cd aimo-gateway
   mvn spring-boot:run

   # 2. 启动认证服务
   cd ../aimo-auth-server
   mvn spring-boot:run

   # 3. 启动用户服务
   cd ../aimo-user-service
   mvn spring-boot:run

   # 4. 根据需要启动其他服务
   ```

5. **前端应用程序**

   前端应用程序的开发和运行说明将在各自的目录中提供。

## 配置说明

### 服务配置

所有微服务的配置文件位于各自模块的 `src/main/resources` 目录下：

- `bootstrap.yml`: 包含 Nacos 配置中心的连接信息
- `application.yml`: 包含服务的基本配置

### 数据库配置

默认情况下，MySQL 服务的配置如下：

- 主机: localhost
- 端口: 3336
- 用户名: root
- 密码: 123456
- 默认数据库: aimo_user_service

## API 文档

项目集成了 Springdoc OpenAPI (Swagger)，可以通过以下 URL 访问 API 文档：

- 网关 API: http://localhost:8080/swagger-ui.html
- 各微服务 API: http://localhost:[服务端口]/swagger-ui.html

## 开发进度

### 项目完成度评估

**总体完成度：约 30%**

#### 已完成部分

1. **项目架构设计**：
    - 微服务架构设计完成
    - 基础设施服务配置未完成（Nacos、MySQL、RabbitMQ、MinIO）（暂时搁置，等所有模块开发完成后再实现）
    - Docker Compose 环境配置未完成（暂时搁置，等所有模块开发完成后再实现）

2. **基础框架搭建**：
    - 所有微服务模块目录结构创建完成
    - 独立依赖管理和基本配置大致完成
    - Spring Cloud Alibaba 集成未完成（暂时搁置，等所有模块开发完成后再实现）

3. **部分核心功能实现**：
    - 用户服务基本功能（注册、登录）
    - 社交服务部分功能（帖子管理）
    - 日记服务基本功能

4. **基础设施优化**：
    - Redis 依赖移除，简化部署

5. **前端开发**：
    - 管理后台前端（Vue.js）：尚未开始开发
    - 移动应用前端：尚未开始开发

### 未完成部分

1. **微服务功能实现（约 70% 未完成）**：
    - 认证授权服务（aimo-auth-server）：JWT 认证机制尚未完全实现
    - 网关服务（aimo-gateway）：路由配置和权限过滤尚未完善
    - AI 助手服务（aimo-ai-service）：尚未开始实现
    - 会员服务（aimo-membership-service）：尚未开始实现
    - 管理后台服务（aimo-admin-service）：尚未开始实现
    - 消息服务（aimo-message-service）：尚未开始实现
    - 社交服务（aimo-social-service）：基本功能已实现，包括帖子、评论、点赞的CRUD操作,使用mongodb实现
    - 用户服务（aimo-user-service）：基本功能已实现，包括用户的CRUD操作,使用Jpa实现
    - 日记服务（aimo-diary-service）：基本功能已实现，包括日记创建、查询,使用mybatis-plus实现


2. **前端开发（约 100% 未完成）**：
    - 管理后台前端（aimo-admin-vue）：尚未开始实现
    - 移动应用前端（aimo-mobile-app）：尚未开始实现

3. **系统集成与优化**：
    - 服务间通信机制尚未完善
    - 分布式事务处理尚未实现
    - 服务熔断和限流尚未实现
    - 日志和监控系统尚未完善






## 贡献

有关贡献、测试和部署的更多详细信息将随着项目的进展而添加。