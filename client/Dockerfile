# 基础镜像
FROM openjdk:8-jdk-alpine
# 挂载临时目录
VOLUME /tmp
# 创建变量JAR_FILE
ARG JAR_FILE
# 把jar放入容器中
ADD ${JAR_FILE} certification-client-1.jar
# 暴露端口
EXPOSE 8882
# 容器启动时执行命令
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/certification-client-1.jar"]
