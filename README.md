# spring-microservices

Starting the ZIPKIN Server before the any micorservice by using the below command
	java -jar zipkin-server-2.23.14-exec.jar

For Cloud Configuration Server, we are using GitHub as a remote repository to store the configuration files. 
Please make sure to update the GitHub repository URL in the application.properties file (https://github.com/kapildevsharma/config-server/blob/main/application.yml) 
of the config-server project (https://github.com/kapildevsharma/config-server.git) before running the application.

Open the project and run the following commands as well as 

1. cd service-registry
   mvn clean package 
2. cd ../config-server
   mvn clean package
3. cd ../cloud-gateway
   mvn clean package 
4. cd ../department-service
   mvn clean package
5. cd ../user-service
   mvn clean package


Start application in the following as well as 
1. Service registry
2. Cloud Configuration Server
3. Cloud API Gateway
4. Department Service
5. User Service

After running application, here are following url to verify all applications
1. Spring Eureka Service URL: http://localhost:8761/
2. Cloud Configuration server URL: http://localhost:9002/
3. API Gateway URL: http://localhost:9191/actuator
4. Department URL: http://localhost:9001/departments/
5. User URL: http://localhost:9002/users/1

Open the swagger URL to verify the API documentation
http://localhost:9191/swagger-ui.html
1. User Service Swagger URL: http://localhost:9002/swagger-ui/index.html
2. Department Service Swagger URL: http://localhost:9001/swagger-ui/index.html
3. API Gateway Swagger URL: http://localhost:9191/swagger-ui.html / http://localhost:9191/webjars/swagger-ui/index.html


How to insert data in the database for Using Swagger UI
Department Service
    1. Open the swagger URL for the department service
    http://localhost:9191/webjars/swagger-ui/index.html?urls.primaryName=department-service

   2. Click on the POST method and click on the try it out button and insert the below JSON data and hit the execute button
   {
   "departmentName": "IT",
   "departmentAddress": "Noida",
   "departmentCode": "IT-06"
   }

User Service
   1. Open the swagger URL for the user service
     http://localhost:9191/webjars/swagger-ui/index.html?urls.primaryName=user-service

   2. Click on the POST method and click on the try it out button and insert the below JSON data and hit the execute button
   {
   "firstName":"KDS QW",
   "lastName":"Test QW",
   "email":"test@test.com",
   "departmentId":2
   }


For more details, please refer to the below video link
https://www.youtube.com/watch?v=9n2s8Xo7l5c


