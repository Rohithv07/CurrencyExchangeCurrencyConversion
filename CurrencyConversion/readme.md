http://localhost:8100/currency-conversion/from/USD/to/INR/quantity/10

## API-Gateway

> http://localhost:8765/CURRENCY-EXCHANGE/currency-exchange/from/USD/to/INR
> http://localhost:8765/CURRENCY-CONVERSION/currency-conversion/from/USD/to/INR/quantity/10

- all the authentication can be done in api gateway

- after specifying `spring.cloud.gateway.discovery.locator.lowerCaseServiceId=true` in properties file

> http://localhost:8765/currency-conversion/currency-conversion/from/USD/to/INR/quantity/10
> http://localhost:8765/currency-exchange/currency-exchange/from/USD/to/INR

### Custom Routing

> http://localhost:8765/currency-exchange/from/USD/to/INR
> http://localhost:8765/currency-conversion/from/USD/to/INR/quantity/10

## Docker

spring-boot:build-image -DskipTests - command used for creating image

By using Dockefile:
1) Create jar files by Run as -> Maven Build -> package -DskipTests=true -Dmaven.test.failure.ignore=true. We skip tests here as we have none
2) Create the docker file (Here if we are using java11 go with FROM openjdk:11. Here I changed all projects to java 8 for docker purpose)
Template : Normal
	FROM openjdk:8-jdk-alpine
	ARG JAR_FILE=target/*.jar
	COPY ${JAR_FILE} app.jar
	ENTRYPOINT ["java","-jar","/app.jar"]
	
3) Run docker build -t rohithvazhathodiyil/currency-exchange-service:0.0.1-SNAPSHOT . - for currency-exchange. Note about the last dot for the build context
4) Run docker build -t rohithvazhathodiyil/currency-conversion-service:0.0.1-SNAPSHOT .
5) Run docker build -t rohithvazhathodiyil/naming-server-service:0.0.1-SNAPSHOT .
6) Run docker build -t rohithvazhathodiyil/api-gateway-service:0.0.1-SNAPSHOT .

Docker images by using the maven command:

* Built using `spring-boot:build-image -DskipTests` - command used for creating image

Currency Exchange : docker.io/rohithvazhathodiyil/currency-currency-exchange-service:0.0.1-SNAPSHOT
Currency Conversion : docker.io/rohithvazhathodiyil/currency-conversion-service:0.0.1-SNAPSHOT

Naming Server : docker.io/rohithvazhathodiyil/currency-naming-server:0.0.1-SNAPSHOT
* After creating the image and setting up the compose file for naming server, no service will register to eureka because now we are using docker and it will not be available via localhost
Api Gateway : docker.io/rohithvazhathodiyil/api-gateway-service:0.0.1-SNAPSHOT
