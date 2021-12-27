# spring-microservices

Start application in the following as well as 

1. Service registry
2. Cloud API Gateway
3. User Service
4. Department Service

Open the project and run the following commands as well as 

cd service-registry
mvn clean package 
cd ../cloud-gateway
mvn clean package 
cd ../user-service
mvn clean package
cd ../department-service
mvn clean package


Before Starting the above micorservice, we start the ZIPKIN Server by using the below command
	java -jar zipkin-server-2.23.14-exec.jar


