# AIMO Project

This repository contains the backend microservices and frontend applications for the AIMO project.

## Project Structure

- `aimo-services`: Contains all backend Spring Cloud Alibaba microservices.
  - `aimo-common`: Common utilities and shared code.
  - `aimo-gateway`: Spring Cloud Gateway for API routing.
  - `aimo-auth-server`: Authentication and authorization service.
  - `aimo-user-service`: User management service.
  - `aimo-diary-service`: Diary and mood management service.
  - `aimo-social-service`: Social features (posts, comments, likes) service.
  - `aimo-ai-service`: AI assistant service.
  - `aimo-membership-service`: Membership management service.
  - `aimo-admin-service`: Admin backend service.
  - `aimo-message-service`: Asynchronous message processing service.
- `aimo-web`: Contains frontend applications.
  - `aimo-admin-vue`: Admin panel frontend (Vue.js).
  - `aimo-mobile-app`: Mobile application frontend.

## Getting Started

### Prerequisites

- Java 17 or higher
- Maven 3.6.3 or higher
- Docker (for Nacos, MySQL, Redis, RabbitMQ, MinIO)

### Setup

1.  **Clone the repository:**

    ```bash
    git clone <repository_url>
    cd AIMO
    ```

2.  **Start Infrastructure Services (using Docker Compose - *future step*):**

    You will need to set up and run Nacos, MySQL, Redis, RabbitMQ, and MinIO. A `docker-compose.yml` will be provided in a later step.

3.  **Build Backend Microservices:**

    Navigate to the `aimo-services` directory and build all modules:

    ```bash
    cd aimo-services
    mvn clean install
    ```

4.  **Run Backend Microservices:**

    Each microservice can be run individually. For example:

    ```bash
    cd aimo-gateway
    mvn spring-boot:run
    ```

    Repeat for other services as needed.

5.  **Frontend Applications:**

    Refer to the `aimo-web/aimo-admin-vue` and `aimo-web/aimo-mobile-app` directories for instructions on running the frontend applications.

## Configuration

Each service's `application.yml` (or `bootstrap.yml`) will contain specific configurations for Nacos, database connections, and other service-specific settings. These will be detailed in subsequent steps.

## API Documentation

Swagger UI will be available for services that include it (e.g., `http://localhost:port/swagger-ui.html`).

## Contributing

Further details on contributing, testing, and deployment will be added as the project progresses.