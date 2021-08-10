# How to make docker image of spring boot

---

## 1. Use vscode - Spring Initializr: Create a Maven Project



---

## 2. Specify Spring Boot version.



---

## 3. Specify project language: Java



---

## 4. Spring Initialzr: Input Group Id



---

## 5. Spring Initialzr: Input Artifact Id



---

## 6. Spring Initializr: Specify packaging type: jar



---

## 7. Spring initializr: Specify Java version: 11



---

## 8. Spring initializr: Choose dependencies



---

## 9. Generate into chosen folder



---

## 10. Add to Workspace



---

## 11. Create HomeController.java(1/5)



---

## 12. Create HomeController.java(2/5)



---

## 13. Create HomeController.java(3/5)



---

## 14. Create HomeController.java(4/5)



---

## 15. Create HomeController.java(5/5)



---

## 16. Run it(1/2)

```
mvn spring-boot:run
```



---

## 17. Run it(2/2)



---

## 18. Lets try

http://localhost:8080/



---

## 19. Create Docker file(1/3)



---

## 20. Create Docker file(2/3)



---

## 21. Create Docker file(3/3)



---

## 22. Build maven project

```powershell
mvn package
```



---

## 23. Build Docker Image(1/3)

```powershell
docker build -t dockerspringboot .
```



---

## 24. Build Docker Image(2/3)



---

## 25. Build Docker Image(3/3)



---

## 26. Run Docker Image

```powershell
docker run -d -p 8080:8080 --name docker-spring-boot dockerspringboot
```



---

## 27. See Docker Image in Docker Desktop	



---

## 28. Lets try

http://localhost:8080/



---

## 29. Docker Image tag and push

```powershell
docker tag dockerspringboot charles2beta/dockerspringboot
```

```powershell
docker push charles2beta/dockerspringboot
```



---

## 30. It works!



---

## 31. Others pull and run from Docker Hub

