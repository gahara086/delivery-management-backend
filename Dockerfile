FROM openjdk:17-jdk-slim

# 作業ディレクトリを設定
WORKDIR /app

# JARファイルを正しいパスにコピー
COPY target/app.jar app.jar

# アプリケーションを実行
ENTRYPOINT ["java", "-jar", "/app/app.jar"]
