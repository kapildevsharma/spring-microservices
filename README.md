# spring-microservices

Starting the ZIPKIN Server before the any micorservice by using the below command
	java -jar zipkin-server-2.23.14-exec.jar

Open the project and run the following commands as well as 

1. cd service-registry
mvn clean package 
2. cd ../cloud-gateway
mvn clean package 
3. cd ../user-service
mvn clean package
4. cd ../department-service
mvn clean package


Start application in the following as well as 
1. Service registry
2. Cloud API Gateway
3. User Service
4. Department Service

After running applciation, here are following url to verify all applications
1. Spring Eureka Service URL: http://localhost:8761/
2. API Gateway URL: http://localhost:9191/actuator
3. User URL: http://localhost:9002/users/1
4. Department URL : http://localhost:9001/actuator/  http://localhost:9001/departments/  


