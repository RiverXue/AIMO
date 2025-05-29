# AIMO 项目

此仓库包含 AIMO 项目的后端微服务和前端应用程序。

## 项目结构

- `aimo-services`: 包含所有后端 Spring Cloud Alibaba 微服务。
  - `aimo-common`: 通用工具和共享代码。
  - `aimo-gateway`: 用于 API 路由的 Spring Cloud Gateway。
  - `aimo-auth-server`: 认证和授权服务。
  - `aimo-user-service`: 用户管理服务。
  - `aimo-diary-service`: 日记和心情管理服务。
  - `aimo-social-service`: 社交功能（帖子、评论、点赞）服务。
  - `aimo-ai-service`: AI 助手服务。
  - `aimo-membership-service`: 会员管理服务。
  - `aimo-admin-service`: 管理后台服务。
  - `aimo-message-service`: 异步消息处理服务。
- `aimo-web`: 包含前端应用程序。
  - `aimo-admin-vue`: 管理面板前端 (Vue.js)。
  - `aimo-mobile-app`: 移动应用程序前端。

## 入门指南

### 先决条件

- Java 17 或更高版本
- Maven 3.6.3 或更高版本
- Docker (用于 Nacos, MySQL, Redis, RabbitMQ, MinIO)

### 设置

1.  **克隆仓库：**

    ```bash
    git clone <repository_url>
    cd AIMO
    ```

2.  **启动基础设施服务 (使用 Docker Compose - *未来步骤*)：**

    您需要设置并运行 Nacos、MySQL、Redis、RabbitMQ 和 MinIO。`docker-compose.yml` 将在后续步骤中提供。

3.  **构建后端微服务：**

    导航到 `aimo-services` 目录并构建所有模块：

    ```bash
    cd aimo-services
    mvn clean install
    ```

4.  **运行后端微服务：**

    每个微服务都可以单独运行。例如：

    ```bash
    cd aimo-gateway
    mvn spring-boot:run
    ```

    根据需要对其他服务重复此操作。

5.  **前端应用程序：**

    请参阅 `aimo-web/aimo-admin-vue` 和 `aimo-web/aimo-mobile-app` 目录，了解如何运行前端应用程序的说明。

## 配置

每个服务的 `application.yml`（或 `bootstrap.yml`）将包含 Nacos、数据库连接和其他服务特定设置的特定配置。这些将在后续步骤中详细说明。

## API 文档

Swagger UI 将适用于包含它的服务（例如，`http://localhost:port/swagger-ui.html`）。

## 贡献

有关贡献、测试和部署的更多详细信息将随着项目的进展而添加。