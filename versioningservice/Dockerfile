FROM ubuntu:20.04

RUN apt update -y

ENV JAVA_HOME=/suresh/software/jdk-11
ENV TOMCAT_HOME=/suresh/middleware/apache-tomcat-9.0.63

ENV PATH=$PATH:${JAVA_HOME}/bin:${TOMCAT_HOME}/bin

RUN mkdir -p /suresh/software
RUN mkdir -p /suresh/middleware

# For installing Java
WORKDIR /suresh/software

ADD https://download.java.net/openjdk/jdk11/ri/openjdk-11+28_linux-x64_bin.tar.gz .

RUN tar -xvzf openjdk-11+28_linux-x64_bin.tar

RUN rm -rf openjdk-11.0.1_linux-x64_bin.tar.gz

#********************* End of Java installation *********************************

# For installing Tomcat
WORKDIR /suresh/middleware

ADD https://dlcdn.apache.org/tomcat/tomcat-9/v9.0.63/bin/apache-tomcat-9.0.63.tar.gz .

RUN tar -xzvf apache-tomcat-9.0.63.tar.gz

RUN rm -rf apache-tomcat-9.0.63.tar.gz

#********************* End of Tomcat installation *******************************

# Copy the war file to tomcat webapps
COPY target/versionsservice-1.0.war apache-tomcat-9.0.63/webapps

CMD [ "catalina.sh", "run" ]

