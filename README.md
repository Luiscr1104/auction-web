# Auction web Java
***
## Un proyecto de servicios utilizando Spring Tools 4 for Eclipse y otras herramientas.
***
La idea es crear una subasta web con algunos parametros como: apuesta minima, apuesta máxima y monto de auto-incremento para obtener un ganador de cierto articulo.

La empresa que construye este sitio me ha pedido que venga con el algoritmo para determinar automáticamente la oferta ganadora después de que todos los postores hayan ingresado su información en el sitio.

El proyecto sigue en desarrollo porque el esqueleto y parte de la lógica lo quiero implementar para un proyecto similar en el futuro.
***

## Installation

### Spring Tools 4
Spring Tools 4 is the next generation of Spring tooling for your favorite coding environment. Largely rebuilt from scratch, it provides world-class support for developing Spring-based enterprise applications, whether you prefer Eclipse, Visual Studio Code, or Theia IDE.
https://spring.io/tools

### Spring Boot:
helps you to create Spring-powered, production-grade applications and services with absolute minimum fuss. It takes an opinionated view of the Spring platform so that new and existing users can quickly get to the bits they need.

You can use Spring Boot to create stand-alone Java applications that can be started using java -jar or more traditional WAR deployments. We also provide a command-line tool that runs Spring scripts.

https://github.com/spring-projects/spring-boot#installation-and-getting-started

***
### Maven: 
Is a build automation tool used primarily for Java projects. Maven can also be used to build and manage projects written in C#, Ruby, Scala, and other languages. Maven addresses two aspects of building software: how software is built, and its dependencies.

#### Spring Boot Starter Test:
Starter for testing Spring Boot applications with libraries including JUnit Jupiter, Hamcrest and Mockito
https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-test
***

Una vez instalado el Spring Tools 4, importamos el proyecto y se recomienda hacer build con maven, luego install maven y previamente iniciar el servicio con Spring boot App.

### Para ejecutar el servicio vamos a nuestra ruta mapeada:
```
http://localhost:8080/auctionApi/runWinnerProcess
```