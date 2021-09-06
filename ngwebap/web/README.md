# ngwebap - web

---

## 2. create web

---

### 2-1. Create an empty project

![ngwebap create web 0](https://user-images.githubusercontent.com/17401732/129671322-7434a242-2be2-4aaf-a5d2-7e6e5b6c623c.png)

---

### 2-2. Create an empty README.md

![ngwebap create web 1](https://user-images.githubusercontent.com/17401732/129671340-0fc51063-2c00-478e-ada5-2b39fb94db36.png)

---

### 2-4. Spring Initializr: Create a Maven Project

---

![ngwebap create web 5](https://user-images.githubusercontent.com/17401732/129671350-46fe7841-211c-499c-be02-89b64802f505.png)

---

![ngwebap create web 6](https://user-images.githubusercontent.com/17401732/129671362-4f08c504-0102-4840-957f-2b9b6cdbb185.png)

---

![ngwebap create web 7](https://user-images.githubusercontent.com/17401732/129671377-dc9f390e-7ba9-495e-ab21-730c4cfaffd8.png)

---

![ngwebap create web 8](https://user-images.githubusercontent.com/17401732/129671387-41a9a2fa-f52f-4b9c-a79d-e77c0288f00f.png)

---

![ngwebap create web 9](https://user-images.githubusercontent.com/17401732/129671403-e5ea818a-2229-49da-b7f0-fa8cb941c5c8.png)

---

![ngwebap create web 10](https://user-images.githubusercontent.com/17401732/129671421-cfc76f2a-704e-45e9-80fb-eefc6d9fdd25.png)

---

![ngwebap create web 11](https://user-images.githubusercontent.com/17401732/129671441-78a476a2-27eb-4e0d-bdb8-d093bc29d7af.png)

---

![ngwebap create web 12](https://user-images.githubusercontent.com/17401732/129671447-55a2ae8e-cc9e-4c85-8dd1-6b2cc1999d50.png)

---

![ngwebap create web 13](https://user-images.githubusercontent.com/17401732/129671457-5895f939-2f52-4c79-93fc-818c66d44348.png)

---

![ngwebap create web 14](https://user-images.githubusercontent.com/17401732/129671469-93e67787-dbb9-4a50-ba18-ae1c686f6d6f.png)

---

![ngwebap create web 15](https://user-images.githubusercontent.com/17401732/129671487-b329788c-f47d-452d-a4a7-19e6d50111a8.png)

---

### 2-5. Add scripts in package.json

![ngwebap create web 16](https://user-images.githubusercontent.com/17401732/129671504-e2e18c62-6251-4791-bb96-16925ee48b33.png)

---

### 2-6. Create pom-web.xml

![ngwebap create web 17](https://user-images.githubusercontent.com/17401732/129671514-a910d550-c7df-406d-82e2-75f7d890e7fc.png)

---

### 2-7. Update pom.xml

![ngwebap create web 18](https://user-images.githubusercontent.com/17401732/129671527-6c928bb6-26b3-4d7f-9b5b-91f989d62790.png)

---

### 2-8. Setup application.properties

![ngwebap create web 19](https://user-images.githubusercontent.com/17401732/129671541-fff90b34-dbdf-43a6-bcc7-c1e4062e3772.png)

---

### 2-9. Setup application-site.properties

![ngwebap create web 20](https://user-images.githubusercontent.com/17401732/129671552-ddec28d6-88d4-4847-bc45-f109da13db0a.png)

---

![ngwebap create web 21](https://user-images.githubusercontent.com/17401732/129671566-fbb43857-04a0-4bdb-a378-769ffff6d257.png)

---

### 2-10. Lets try startup-ap

![ngwebap create web 22](https://user-images.githubusercontent.com/17401732/129671576-e01e0ff0-4b12-4857-80bd-e92f7b642e13.png)

---

![ngwebap create web 23](https://user-images.githubusercontent.com/17401732/129671588-e678e5cb-73e3-4dd1-9b83-ae36962dc593.png)

---

## 4. add logback to ap web

---

### 4-1. add logback.spring.xml

![ngwebap add logback to ap web 1](https://user-images.githubusercontent.com/17401732/130218269-b50f65f9-0b15-4cdd-b1c1-531dc057e673.png)

---

### 4-2. .gitignore ngwebap/logs

![ngwebap add logback to ap web 2](https://user-images.githubusercontent.com/17401732/130218312-f3065f0d-3038-4cdc-84ad-d52c68f2d2be.png)

---

## 5. add security to web

---

### 5-1. add CommonController

![ngwebap 5  add security to web 1](https://user-images.githubusercontent.com/17401732/130218702-a0343694-816a-40ce-bbf1-d99958b591c2.png)

---

![ngwebap 5  add security to web 2](https://user-images.githubusercontent.com/17401732/130218708-30ef0a83-2d21-4376-b6be-8dd4e80de4d3.png)

---

### 5-2. add spring-boot-starter-security

![ngwebap 5  add security to web 3](https://user-images.githubusercontent.com/17401732/130218726-d4457b2a-d084-44fc-8b1d-dd08e2caf70a.png)

---

### 5-3. bypass spring-boot-starter-security

![ngwebap 5  add security to web 4](https://user-images.githubusercontent.com/17401732/130218742-b5ab6791-5809-480d-9b25-45e305792d04.png)

---

### 5-4. add httpclient, gson to common's pom.xml

![ngwebap 5  add security to web 5](https://user-images.githubusercontent.com/17401732/130218755-840697df-e5b2-4e2b-bffc-bcfe3dde353e.png)

---

### 5-5. add HttpDao and update CommonController

![ngwebap 5  add security to web 6](https://user-images.githubusercontent.com/17401732/130218766-4e790718-95db-462c-ab54-7f8fccbdfe4d.png)

---

### 5-6. add GlobalConfig and web.properties

![ngwebap 5  add security to web 7](https://user-images.githubusercontent.com/17401732/130218782-911c9e77-99a0-40f6-9436-0e0473f8ce0d.png)

---

### 5-7. add WebResult to common

![ngwebap 5  add security to web 8](https://user-images.githubusercontent.com/17401732/130218798-1284ba97-1f7f-4938-aafc-36762cbd9cd2.png)

---

### 5-8. add CakeController to ap

![ngwebap 5  add security to web 9](https://user-images.githubusercontent.com/17401732/130218809-4c571ce2-1a8d-4447-ad75-057e5e1a56d9.png)

---

### 5-9. test web's CommonController to ap's CakeController

![ngwebap 5  add security to web 10](https://user-images.githubusercontent.com/17401732/130218826-a7a14354-0ab0-46d9-83db-85a8b6982997.png)

### 5-10. add CustomAuthenticationProvider

### 5-11. add GrantedAuthorityImpl

### 5-12. add JwtAuthenticationEntryPoint

### 5-13. add JwtAuthenticationFilter

### 5-14. add JwtLoginFilter

### 5-15. update WebSecurityConfig to enable security

### 5-16. test with postman POST /web/api/login to get jwt token

### 5-17. test with postman GET /web/api/cake/alive/ with jwt token
