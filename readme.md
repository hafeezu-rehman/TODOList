# 📝 First To-Do Application

A clean and functional **To-Do List Web App** built using **Spring Boot**, **Thymeleaf**, **MySQL**, and **JavaScript**.

---

## 🚀 Features

- Add, edit, and delete tasks
- Stores data in a MySQL database
- Thymeleaf-based UI with responsive design
- JavaScript-powered interactivity
- Environment-aware API base URL access in frontend

---

## ⚙️ Configuration (Must Do Before Running)

Before you run the project, update the file:
```
src/main/resources/application.properties
```

Replace the placeholder values with your actual configuration:

```properties
spring.application.name=First To-Do Application
server.port=8085

# ✅ Database Configuration
spring.datasource.url=jdbc:mysql://{DBURL}
spring.datasource.username={DBUSER}
spring.datasource.password={DBPASSWORD}

spring.jpa.hibernate.ddl-auto=update
spring.mvc.throw-exception-if-no-handler-found=true

# ✅ Base URL for frontend JS to call APIs
app.api.base-url={API Base URL}
```

Example:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/todolist
spring.datasource.username=root
spring.datasource.password=123456
app.api.base-url=http://localhost:8085/api
```

---

## 🛠️ How to Run the App

### 📦 Using Maven (Development Mode)

```bash
./mvnw spring-boot:run
```

### 🏗️ Build JAR File

```bash
mvn clean install
```

The compiled file will be created in the `target/` folder.

### 🚀 Run JAR in Foreground

```bash
java -jar target/todolist-0.0.1-SNAPSHOT.jar
```

---

## 🌐 Access the App

After running, open your browser and go to:

```
http://localhost:8085
```

### ✅ Live Demo

You can check out the running app here:  
👉 **[http://54.225.90.113:8085/](http://54.225.90.113:8085/)**

---

## 📁 Project Structure

```
src/
├── main/
│   ├── java/
│   │   └── com.project.todolist
│   │       ├── controller/
│   │       ├── model/
│   │       ├── repository/
│   │       ├── service/
│   │       └── config/
│   └── resources/
│       ├── static/        <-- CSS / JS files
│       ├── templates/     <-- Thymeleaf templates
│       └── application.properties
```

---

## 📄 License

This project is open for personal or academic use. Feel free to improve and build on top of it!

---

## 👤 Author

**Hafeez Ur Rehman**  
🎓 BBIT Student | 💻 Spring Boot Developer  
🌐 [GitHub](https://github.com/hafeezu-rehman) | [LinkedIn](https://www.linkedin.com/in/hafeezurrehman)
