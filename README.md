# Locker Rent
## Get Started

1. First, clone the repository to your local computer.
2. Run the following command to build the Docker image and container:  `docker-compose up -d`
3. **Note :** This will start two containers, MySQL and phpMyAdmin.
4. Finally, run the Spring Boot application with the command below: `mvn spring-boot:run`
5. **Note:** Ensure Docker is installed on your computer.

# API End Point

**Create new client (user)**

**Path:** http://localhost:8086/api/users
<br>
`
{
	"name":"frank",
	"email":"papafrank@gmail.com"
}
`

**Create new locker**
**Path:** http://localhost:8086/api/lockers
<br>
{
	"lockerNumber":"009",
	"password":"0",
	"occupied":0
}

**Create booking**
**Path:** http://localhost:8086/api/bookings/create
<br>
{
	"userId": 1,
	"lockerIds": [105],
	"endDate": "2024-05-26T12:00:00"
}


