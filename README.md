# 图书管理系统 (Books Management System)

本项目是一个使用 Spring Boot 3 构建的图书管理系统，结合 MySQL 数据库，通过 Docker 部署。

## 目录

- [先决条件](#先决条件)
- [项目结构](#项目结构)
- [构建与运行](#构建与运行)
- [API 文档](#api-文档)
- [测试](#测试)
- [常见问题](#常见问题)

## 先决条件

在开始之前，请确保已经安装以下工具：

- [Docker](https://www.docker.com/)
- [Docker Compose](https://docs.docker.com/compose/install/)
- [Git](https://git-scm.com/)
- [Java 17+](https://www.oracle.com/java/technologies/javase-jdk17-downloads.html)
- [Maven](https://maven.apache.org/)

## 项目结构

```bash
.
├── src/                   # 项目源代码
├── Dockerfile             # Docker 镜像的构建文件
├── docker-compose.yml      # Docker Compose 文件
├── pom.xml                # Maven 项目配置文件
└── README.md              # 项目说明文档


```

## 构建与运行

### 1.克隆项目

```bash
git clone https://github.com/your-username/BooksManagementSystem.git
cd BooksManagementSystem

```

### 2.构建项目

确保项目依赖正确并编译成功：

```bash
./gradlew build
```

### 3.使用Docker启动项目

在项目根目录中使用 `docker-compose` 来启动服务：

```bash
docker-compose up --build
```

这将会启动两个服务：

- MySQL 数据库（端口：3306）
- Spring Boot 应用程序（端口：8080）

## 4. 访问 Swagger-ui API

在浏览器或 Postman 中访问：

```
http://localhost:8080/swagger-ui/index.html
```

# 测试

可以使用swagger-ui测试 API：
```
http://localhost:8080/swagger-ui/index.html
```
