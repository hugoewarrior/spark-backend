FROM maven:3-jdk-8

# Push the code to the server
WORKDIR /lab8

# Prepare by downloading dependencies
ADD pom.xml /lab8/pom.xml
RUN ["mvn", "dependency:resolve"]
RUN ["mvn", "verify"]

COPY . /lab8

# Adding source, compile and package into a fat jar
RUN ["mvn", "package"]

EXPOSE 4567