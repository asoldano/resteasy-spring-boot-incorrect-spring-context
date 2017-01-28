Sample app to demonstrate possible issue with the integration between Spring and Resteasy, when there is more than one instance of a webapp running.

### About the app:

Simple REST HTTP interface, built with Spring Boot, which returns a simple text response based on the implementation of the ```ClientInterface```.
The REST capabilities are implemented using JAX-RS, provided by resteasy through the [RestEasy-SpringBoot library](https://github.com/paypal/resteasy-spring-boot)

There are two implementations of ```ClientInterface```, which are toggled based on the presence of the ```client-impl-two``` profile
### About the issue:
The issue itself appears during the tests.

There are 3 tests
* A_SuccessfulResponseOneTest
* B_SuccessfulResponseTwoTest
* C_FailingTest

They have been named A_, B_ and C_ in order to ensure the order of execution, 
because it influences the outcome of the failing test.

*When running the tests using the Junit integration from IntelliJ, the third test fails*.

Screenshots:
 
 [Screenshot1](https://s27.postimg.org/595qawj2r/incorrect_app_context_01.png)
 
 [Screenshot2](https://s27.postimg.org/bo4r7kpsj/incorrect_app_context_02.png)
 

 The test ```C_FailingTest``` fails because the output it receives from the REST resource is the one which is configured for the previous test ```B_SuccessfulResponseTwoTest```, by setting the ```client-impl-two``` profile. So somehow, *the Spring application context from the previous test (B_SuccessfulResponseTwoTest) is erroneously used/injected while executing the test after it (C_FailingTest)*.
 
 
IMPORTANT NOTES:
 * sometimes, running ```./mvnw clean test``` also yields the same result, but I have been unable to provide a reproducible example 
 * after much debugging, I have determined the following
    * the Spring Application context is correctly loaded by Spring/Spring Boot
    * Spring Boot correctly injects the port number, and the rest client in the tests always call the REST instance they are supposed to
    * it is only when Resteasy takes over the request, that it somehow loads up the incorrect instance of the application, and hence the incorrect Spring Application context is used, which brings unexpected behavior
 * during the tests, there is more than one instance of the application running, each on it's own port, which I assume has something to do with the issue
 * there is another branch, ```jersey-instead-of-resteasy``` in which Jersey is used as the JAX-RS implementation, and where the tests are successful no matter if they are run with IntelliJ or with Maven
   