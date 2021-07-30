# Jpamysql

Demo project for Spring Boot JPA Mysql

This is a very simple project only focus on a few things

1. Create a spring jpa project
2. Setting mysql db connection info
3. Run it

tags: #spring #jpa #mysql #lombok

---

## Goal

Using spring boot jpa to access mysql db and generate table "user" into schema.

---

## Requirements

---


### Installed Maven

Lets check

```
mvn -v
```

---

### Installed **mysql db**
![mysql nord](https://user-images.githubusercontent.com/17401732/127609501-8d6593d5-af5f-4f58-b350-5865106fa95b.png)

---

Must have a administrator account root/1234 and a schema "nord"

I use **mysql-installer-community-8.0.26.0.msi** to installed it on Windows 10.

```mysql
CREATE SCHEMA `nord` DEFAULT CHARACTER SET utf8 ;
```



---

## Create a spring jpa project

I use vscode 
Spring Initializr: Create Maven Project

- maven
- java 11
- spring-boot-starter-data-jpa
- spring-boot-starter-web
- spring-boot-devtools
- lombok
- mysql-connector-java

---

## Setting mysql db connection info

application.properties

```properties
spring.jpa.hibernate.ddl-auto=update
spring.datasource.url=jdbc:mysql://localhost:3306/nord
spring.datasource.username=root
spring.datasource.password=1234
spring.datasource.driver-class-name =com.mysql.jdbc.Driver
spring.jpa.database-platform=org.hibernate.dialect.MySQL5InnoDBDialect
#spring.jpa.show-sql: true
```

---

## Run it

```
mvn spring-boot:run
```

---

## Focus on

| file                     | description      |
| ------------------------ | ---------------- |
| pom.xml                  | dependencies     |
| JpamysqlApplication.java | spring boot main |
| application.properties   | connection info  |
| User.java                | entity           |

