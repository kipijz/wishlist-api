# 🏫 Wishlist REST API

REST API made with Java, Spring Boot and PostgreSQL (H2 for Integration test).       

Can add, delete, update, get wishes. Also can get a list of all wishes.

## How to run
### Spring Boot:
```
mvn spring-boot:run
```

### Docker:
```
docker run --name some-postgres -e POSTGRES_PASSWORD=mysecretpassword -p 5432:5432 -d postgres 
Project Configuration 
URL: jdbc:postgresql://localhost:5432/
User Name: postgres
Password: mysecretpassword
```

### H2 Database:
```
URL: localhost:8080/h2-console/

Driver Class: org.h2.Driver
JDBC URL: jdbc:h2:mem:testdb
User Name: sa
Password: 
```

## REST APIs Endpoints
### Add a Wish

* /add-wish [POST]

### Update wish

* /update-wish/{id} [PUT]

### Delete wish

* /delete-wish/{id} [DELETE]

### Get Wish by ID

* /get-wish/{id} [GET]

### Get Wish list by ID

* /get-wish-list [GET]

### Additional task (get names from JSON and separate with delimiter)

* /additional-task [PUT]
