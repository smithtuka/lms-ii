FROM openjdk:8-jdk-alpine
WORKDIR /src
RUN javac src/smith/tukahirwa/Tests/FunctionUtilTest.java
CMD ["java", "src/smith/tukahirwa/Tests/FunctionUtilTest"]