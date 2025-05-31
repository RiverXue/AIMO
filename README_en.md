# AIMO Project

## Project Overview

AIMO is a comprehensive application platform based on microservice architecture, designed to provide user management, social interaction, AI assistant, diary recording, and other functionalities. The project uses Spring Cloud Alibaba technology stack to build backend microservices and Vue.js to develop frontend applications.

## Technology Stack

### Backend Technologies

- **Core Framework**: Spring Boot 3.x, Spring Cloud Alibaba
- **Service Registration and Discovery**: Nacos
- **Configuration Center**: Nacos Config
- **Gateway**: Spring Cloud Gateway
- **ORM Framework**: MyBatis Plus, Spring Data JPA
- **Database**: MySQL 8.0
- **Message Queue**: RabbitMQ
- **Object Storage**: MinIO
- **API Documentation**: Springdoc OpenAPI (Swagger)
- **Security Framework**: Spring Security, JWT

### Frontend Technologies

- **Admin Dashboard**: Vue.js
- **Mobile Application**: To be determined

## Project Structure

### Backend Microservices

- `aimo-services`: Contains all backend Spring Cloud Alibaba microservices
  - `aimo-common`: Common utilities, entities, DTOs, exception handling, and shared code
  - `aimo-gateway`: API gateway, responsible for request routing, load balancing, authentication, etc.
  - `aimo-auth-server`: Authentication and authorization service, handling user login, token management, etc.
  - `aimo-user-service`: User management service, handling user registration, profile management, etc.
  - `aimo-diary-service`: Diary and mood management service, providing diary creation, query, sentiment analysis, etc.
  - `aimo-social-service`: Social functionality service, including posts, comments, likes, and other social interaction features
  - `aimo-ai-service`: AI assistant service, providing intelligent conversation, content recommendation, and other AI features
  - `aimo-membership-service`: Membership management service, handling member subscriptions, benefits management, etc.
  - `aimo-admin-service`: Admin backend service, providing system management, data statistics, etc.
  - `aimo-message-service`: Message processing service, responsible for system notifications, user messages, and other asynchronous processing

### Frontend Applications

- `aimo-web`: Contains frontend applications
  - `aimo-admin-vue`: Admin dashboard frontend (Vue.js)
  - `aimo-mobile-app`: Mobile application frontend

## Infrastructure Services

The project depends on the following infrastructure services, managed through Docker Compose:

- **Nacos**: Service registration, discovery, and configuration center (Ports: 8848, 9848, 9849)
- **MySQL**: Database service (Port: 3336→3306)
- **RabbitMQ**: Message queue (Port: 5672, Management UI: 15672)
- **MinIO**: Object storage service (Port: 9000, Console: 9001)

## Getting Started

### Prerequisites

- Java 17 or higher
- Maven 3.6.3 or higher
- Docker and Docker Compose
- Git

### Environment Setup

1. **Clone the repository**

   ```bash
   git clone <https://github.com/RiverXue/AIMO.git>
   cd AIMO
   ```

2. **Start Infrastructure Services**

   Use Docker Compose to start the required infrastructure services:

   ```bash
   docker-compose up -d
   ```

   This will start Nacos, MySQL, RabbitMQ, and MinIO services.

3. **Build Backend Microservices**

   Navigate to the `aimo-services` directory and build all modules:

   ```bash
   cd aimo-services
   mvn clean install -DskipTests
   ```

4. **Run Backend Microservices**

   Start services in the following order:

   ```bash
   # 1. First start the gateway
   cd aimo-gateway
   mvn spring-boot:run

   # 2. Start the authentication service
   cd ../aimo-auth-server
   mvn spring-boot:run

   # 3. Start the user service
   cd ../aimo-user-service
   mvn spring-boot:run

   # 4. Start other services as needed
   ```

5. **Frontend Applications**

   Instructions for developing and running frontend applications will be provided in their respective directories.

## Configuration

### Service Configuration

Configuration files for all microservices are located in the `src/main/resources` directory of each module:

- `bootstrap.yml`: Contains connection information for the Nacos configuration center
- `application.yml`: Contains basic configuration for the service

### Database Configuration

By default, the MySQL service is configured as follows:

- Host: localhost
- Port: 3336
- Username: root
- Password: 123456
- Default Database: aimo_user_service

## API Documentation

The project integrates Springdoc OpenAPI (Swagger), which can be accessed via the following URLs:

- Gateway API: http://localhost:8080/swagger-ui.html
- Microservice APIs: http://localhost:[service_port]/swagger-ui.html

## Development Progress

### Project Completion Assessment

**Overall Completion: Approximately 30%**

#### Completed Parts

1. **Project Architecture Design**:
   - Microservice architecture design completed
   - Infrastructure services configuration not completed (Nacos, MySQL, RabbitMQ, MinIO) (temporarily postponed, to be implemented after all modules are developed)
   - Docker Compose environment configuration not completed (temporarily postponed, to be implemented after all modules are developed)

2. **Basic Framework Setup**:
   - Directory structure for all microservice modules created
   - Independent dependency management and basic configuration roughly completed
   - Spring Cloud Alibaba integration not completed (temporarily postponed, to be implemented after all modules are developed)

3. **Partial Core Functionality Implementation**:
   - User service basic functions (registration, login)
   - Social service partial functions (post management)
   - Diary service basic functions

4. **Infrastructure Optimization**:
   - Redis dependency removal, simplifying deployment

5. **Frontend Development**:
   - Admin dashboard frontend (Vue.js): Development not yet started
   - Mobile application frontend: Development not yet started

### Incomplete Parts

1. **Microservice Functionality Implementation (Approximately 70% Incomplete)**:
   - Authentication service (aimo-auth-server): JWT authentication mechanism not fully implemented
   - Gateway service (aimo-gateway): Routing configuration and permission filtering not fully refined
   - AI assistant service (aimo-ai-service): Implementation not yet started
   - Membership service (aimo-membership-service): Implementation not yet started
   - Admin backend service (aimo-admin-service): Implementation not yet started
   - Message service (aimo-message-service): Implementation not yet started
   - Social service (aimo-social-service): Basic functionality implemented, including CRUD operations for posts, comments, and likes, implemented using MongoDB
   - User service (aimo-user-service): Basic functionality implemented, including CRUD operations for users, implemented using JPA
   - Diary service (aimo-diary-service): Basic functionality implemented, including diary creation and query, implemented using MyBatis Plus

2. **Frontend Development (Approximately 100% Incomplete)**:
   - Admin dashboard frontend (aimo-admin-vue): Implementation not yet started
   - Mobile application frontend (aimo-mobile-app): Implementation not yet started

3. **System Integration and Optimization**:
   - Inter-service communication mechanism not fully refined
   - Distributed transaction processing not yet implemented
   - Service circuit breaking and rate limiting not yet implemented
   - Logging and monitoring systems not fully refined

## Contributing

Further details on contributing, testing, and deployment will be added as the project progresses.
