# Locker Rent
## Get Started

1. First, clone the repository to your local computer.
2. Run the following command to build the Docker image and container:  `docker-compose up -d`
3. **Note :** This will start two containers, MySQL and phpMyAdmin.
4. Finally, run the Spring Boot application with the command below: `mvn spring-boot:run`
5. **Note:** Ensure Docker is installed on your computer.

# API End Point

**Create new client (user)**
<br>
**Path:** http://localhost:8086/api/users
<br>
- Body
```
{
	"name":"frank",
	"email":"papafrank@gmail.com"
}
 ```
- Response 200
```
{
	"status": "200 OK",
	"message": "Success",
	"payload": "Loker berhasil di booking."
}
```

**Create new locker**
<br>
**Path:** http://localhost:8086/api/lockers
- Body
<br>
```
{
	"lockerNumber":"009",
	"password":"0",
	"occupied":0
}
```
<br>

**Create booking**
<br>
**Path:** http://localhost:8086/api/bookings/create
<br>
- body
```
{
	"userId": 1,
	"lockerIds": [105],
	"endDate": "2024-05-26T12:00:00"
}
```
- Response 400
```
{
	"status": "400 BAD_REQUEST",
	"message": "Locker is already occupied.",
	"payload": null
}
```
- Response 404
```
{
	"status": "404 NOT_FOUND",
	"message": "Locker not found.",
	"payload": null
}
```
- Response 400
```
{
	"status": "400 BAD_REQUEST",
	"message": "Cannot book more than 3 lockers.",
	"payload": null
}
```

