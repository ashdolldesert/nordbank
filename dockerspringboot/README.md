# How to make docker image of spring boot

---

## 1. Use vscode - Spring Initializr: Create a Maven Project

![docker spring boot 1](https://user-images.githubusercontent.com/17401732/128848051-2f75fcd0-9896-4438-859e-540c6771cbde.png)

---

## 2. Specify Spring Boot version.

![docker spring boot 2](https://user-images.githubusercontent.com/17401732/128848078-c7a4425c-1a0b-4930-9201-a6017639a8f2.png)

---

## 3. Specify project language: Java

![docker spring boot 3](https://user-images.githubusercontent.com/17401732/128848095-16e517f9-7666-49ac-b7db-1bdbb67211e1.png)

---

## 4. Spring Initialzr: Input Group Id

![docker spring boot 4](https://user-images.githubusercontent.com/17401732/128848109-8c446e0b-1189-4e83-bdb0-21569b5c9252.png)

---

## 5. Spring Initialzr: Input Artifact Id

![docker spring boot 5](https://user-images.githubusercontent.com/17401732/128848121-ad377c3c-f2f0-4987-82fb-1c1bbeb97cda.png)

---

## 6. Spring Initializr: Specify packaging type: jar

![docker spring boot 6](https://user-images.githubusercontent.com/17401732/128848134-f3ddae0d-96d8-44ca-a73c-a660a3eb9f1b.png)

---

## 7. Spring initializr: Specify Java version: 11

![docker spring boot 7](https://user-images.githubusercontent.com/17401732/128848148-1f3ba4d7-cce0-426f-84c1-314f87116bc4.png)

---

## 8. Spring initializr: Choose dependencies

![docker spring boot 8](https://user-images.githubusercontent.com/17401732/128848168-a3407e33-39b4-4223-bb50-d040cb8e80ed.png)

---

## 9. Generate into chosen folder

![docker spring boot 9](https://user-images.githubusercontent.com/17401732/128848184-e12d31db-7408-4721-aff9-77ca501c8d1b.png)

---

## 10. Add to Workspace

![docker spring boot 10](https://user-images.githubusercontent.com/17401732/128848200-4b4029a3-e7a0-4b76-ae00-ad6dcf91fbaa.png)

---

## 11. Create HomeController.java(1/5)

![docker spring boot 11](https://user-images.githubusercontent.com/17401732/128848225-4daa7497-6c0e-44c2-b71b-e4145068fe4b.png)

---

## 12. Create HomeController.java(2/5)

![docker spring boot 12](https://user-images.githubusercontent.com/17401732/128848237-53d421e4-e683-42c8-9ae0-303677f2d52f.png)

---

## 13. Create HomeController.java(3/5)

![docker spring boot 13](https://user-images.githubusercontent.com/17401732/128848246-9bc3f5c9-a2ae-4462-8934-cae2ffde9317.png)

---

## 14. Create HomeController.java(4/5)

![docker spring boot 14](https://user-images.githubusercontent.com/17401732/128848265-68b8a56b-192b-43ee-abe5-c96d46aa3515.png)

---

## 15. Create HomeController.java(5/5)

![docker spring boot 15](https://user-images.githubusercontent.com/17401732/128848277-eb3369e2-8518-4391-9b84-0dc760af26f7.png)

---

## 16. Run it(1/2)

```
mvn spring-boot:run
```

![docker spring boot 16](https://user-images.githubusercontent.com/17401732/128848290-6d2cc470-d5f5-4467-8ce3-f86bec6debf3.png)

---

## 17. Run it(2/2)

![docker spring boot 17](https://user-images.githubusercontent.com/17401732/128848306-212c6075-fa22-4eaf-8c50-18a8576bdbf8.png)

---

## 18. Lets try

http://localhost:8080/

![docker spring boot 18](https://user-images.githubusercontent.com/17401732/128848320-3e56c5f7-ad5b-4e5d-94fc-90bd84cde030.png)

---

## 19. Create Docker file(1/3)

![docker spring boot 19](https://user-images.githubusercontent.com/17401732/128848344-590d49dd-f79a-44c5-bbac-ad9939c6acde.png)

---

## 20. Create Docker file(2/3)

![docker spring boot 20](https://user-images.githubusercontent.com/17401732/128848356-d246b998-728b-4974-83a9-f1db2ab93c57.png)

---

## 21. Create Docker file(3/3)

![docker spring boot 21](https://user-images.githubusercontent.com/17401732/128848371-1d73fb8c-3205-47d9-a090-5929d34bbd89.png)

---

## 22. Build maven project

```powershell
mvn package
```

![docker spring boot 22](https://user-images.githubusercontent.com/17401732/128848387-01448933-136b-47f1-a1b2-5dc1f5d97020.png)

---

## 23. Build Docker Image(1/3)

```powershell
docker build -t dockerspringboot .
```

![docker spring boot 23](https://user-images.githubusercontent.com/17401732/128848408-b4678e26-734e-425b-99b7-751f5c0dd7f7.png)

---

## 24. Build Docker Image(2/3)

![docker spring boot 24](https://user-images.githubusercontent.com/17401732/128848421-08fd4832-3241-44ad-a9e4-b4e8f8de94ee.png)

---

## 25. Build Docker Image(3/3)

![docker spring boot 25](https://user-images.githubusercontent.com/17401732/128848437-8a927c5c-dbad-42b0-a2b4-148187f1ac6c.png)

---

## 26. Run Docker Image

```powershell
docker run -d -p 8080:8080 --name docker-spring-boot dockerspringboot
```

![docker spring boot 26](https://user-images.githubusercontent.com/17401732/128848459-6c9ba6b4-7965-44d5-949c-b732ab553af6.png)

---

## 27. See Docker Image in Docker Desktop	

![docker spring boot 27](https://user-images.githubusercontent.com/17401732/128848473-cf0e4690-a763-425c-93e0-128d3397a348.png)

---

## 28. Lets try

http://localhost:8080/

![docker spring boot 28](https://user-images.githubusercontent.com/17401732/128848487-00a4b304-78f3-4874-8e29-c3f7400f0d5e.png)

---

## 29. Docker Image tag and push

```powershell
docker tag dockerspringboot charles2beta/dockerspringboot
```

```powershell
docker push charles2beta/dockerspringboot
```

![docker spring boot 29](https://user-images.githubusercontent.com/17401732/128848515-4f60a250-b116-4f29-9617-948ffd76bcaf.png)

---

## 30. It works!

![docker spring boot 30](https://user-images.githubusercontent.com/17401732/128848528-728f13c5-b756-4b55-8c64-248616fed36f.png)

---

## 31. Others pull and run from Docker Hub

![docker spring boot 31](https://user-images.githubusercontent.com/17401732/128848561-43382007-d3b9-4a14-88f7-a1a85b8a251e.png)
