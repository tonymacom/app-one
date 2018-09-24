FROM java:8-jre

MAINTAINER mabo <itmabo@163.com>

ADD ./target/app-one*.jar /app/app-one.jar
CMD ["java", "-jar", "/app/app-one.jar"]

EXPOSE 9704