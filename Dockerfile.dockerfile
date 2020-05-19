FROM	openjdk:8
MAINTAINER RODRIGO TENORIO DE BOA VENTURA<boaventura19@yahoo.com.br>
COPY	target/Acqio.jar	Acqio.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "Acqio.jar"]