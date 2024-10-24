#
## 使用官方Java基础镜像
#FROM openjdk:17-jdk-slim
#
#MAINTAINER lfg
#
## 设置工作目录
#WORKDIR /app
## 将jar文件复制到容器中
#COPY build/libs/BooksManagementSystem-0.0.1-SNAPSHOT.jar app.jar
#
## 运行应用
#ENTRYPOINT ["java", "-jar", "/app.jar"]
#
#
#

# 使用官方 Java 17 基础镜像
FROM openjdk:17-jdk-slim AS builder

# 设置工作目录
WORKDIR /app

# 复制 gradlew 和构建配置文件
COPY gradlew ./
COPY build.gradle.kts settings.gradle.kts ./

# 复制整个 gradle 文件夹
COPY gradle/ gradle/

# 创建一个空的 gradle.properties 文件，避免构建失败
RUN touch gradle.properties

# 确保 gradlew 可执行
RUN chmod +x gradlew

# 下载依赖
RUN ./gradlew dependencies --no-daemon

# 复制源代码
COPY . .

# 构建 JAR 文件
RUN ./gradlew build -x test --no-daemon


# 使用更小的基础镜像运行 JAR 文件
FROM openjdk:17-jdk-slim

# 设置工作目录
WORKDIR /app

# 从构建阶段复制 JAR 文件到运行阶段
COPY --from=builder /app/build/libs/BooksManagementSystem-0.0.1-SNAPSHOT.jar app.jar

# 运行应用程序
ENTRYPOINT ["java", "-jar", "/app/app.jar"]



