# CurrencyConversion and CurrencyExchange Backend

Maven Command To Build Docker Image : spring-boot:build-image

![](https://github.com/Rohithv07/CurrencyExchangeCurrencyConversion/blob/main/images/ApiDocumentation.gif)

## Currency Exchange Service

* Stores the exchange rate of 3 different currency (USD, EUR, AUD)in an in-memory h2 database.

* Recieve the from currency and to currency as path variable and shows the details about it.

### Port :

* 8001

### Urls : 

> http://localhost:8001/currency-exchange/from/USD/to/INR - here USD and INR are provided as path variables

> After custom routing : http://localhost:8765/currency-exchange/from/USD/to/INR

> Swagger documentation : http://localhost:8001/swagger-ui.html


## Currency Conversion Service

* Communicates with the *CurrencyExchange* service and use the exchange rate for the conversion of the amount.

* Conversion from, Conversion to and the amount to be converted are taken as path variable

* FeignProxy is made use in order to communicate with the currency exchange service.

### Port :

* 8100

### Urls :

> http://localhost:8100/currency-conversion/from/USD/to/INR/quantity/10 - here USD, INR, 10 are provided are path variables

> After custom routing : http://localhost:8765/currency-conversion/from/USD/to/INR/quantity/10

> Swagger documentation : http://localhost:8100/swagger-ui.html


### Naming Server

* Services are registered with eureka discovery server.

![Eureka Discovery Server](https://github.com/Rohithv07/CurrencyExchangeCurrencyConversion/blob/main/images/Screenshot%202021-08-04%20at%205.12.09%20PM.png)

### Port :

* 8765

### Url :

> http://localhost:8761/

## API-Gateway

* Used to route API's.

* Provide cross cutting concerns:

	* Security

	* Monitoring

	* Metrics

* Match routes on any request attribute.

![Spring Cloud Gateway](https://docs.spring.io/spring-cloud-gateway/docs/3.0.4-SNAPSHOT/reference/html/images/spring_cloud_gateway_diagram.png)

>>> Taken from https://docs.spring.io/spring-cloud-gateway/docs/3.0.4-SNAPSHOT/reference/html/

### Custom Routing

> http://localhost:8765/currency-exchange/from/USD/to/INR

> http://localhost:8765/currency-conversion/from/USD/to/INR/quantity/10

## Docker

### Docker images by using the maven command:

* Built using `spring-boot:build-image -DskipTests` - command used for creating image

* Currency Exchange : docker.io/rohithvazhathodiyil/currency-currency-exchange-service:0.0.1-SNAPSHOT

* Currency Conversion : docker.io/rohithvazhathodiyil/currency-conversion-service:0.0.1-SNAPSHOT

* Naming Server : docker.io/rohithvazhathodiyil/currency-naming-server:0.0.1-SNAPSHOT
>>> After creating the image and setting up the compose file for naming server, no service will register to eureka because now we are using docker and it will not be available via localhost.

* Api Gateway : docker.io/rohithvazhathodiyil/api-gateway-service:0.0.1-SNAPSHOT


# CurrencyConversion and CurrencyExchange Frontend

![](https://github.com/Rohithv07/CurrencyExchangeCurrencyConversion/blob/main/images/Frontend.gif)

* Angular framework is used in front end.

* There are mainly 4 components present.

	* Login Component : where the login form with a switchable button doing login and sign up. New user details are stored inside firebase and firebase auth api is used for the authorization and authentication functionality. Proper error messages are shown when the authentication fails.

	* Header/Nav Component : Here after the user logged in, a welcome message like `welcome username` is shown on the top along with a logout button which when clicked logs out the user.

	* Currency Exchange Component : This component shows the details grabbed from the currency exchange service running in the backend and a table of these contents are shown.

	* Currency Conversion Component : This component have a form field where we give inputs like `currency from`, `currency to`, `quantity` and these variables are passed as path variable which is the requirement for the Currency Conversion service and the total calculated amount after conversion is shown after clicking the `Convert` button.

* Once the user logged in, the details of the user are stored inside the local storage so that eventhough the app is refreshed, the user remains logged in.

* When we click the log out button present in the header component, the user gets logged out and after that the auth guard prevents the user again to visit the previous page. In order visit the currency conversion, currency exchange page, the user needs to be authenticated again.





