FROM jenkins/jenkins:lts

# Instale o JDK 21
USER root
RUN apt-get update && \
    apt-get install -y openjdk-23-jdk && \
    apt-get clean;

# Configure o JAVA_HOME
ENV JAVA_HOME /usr/lib/jvm/java-21-openjdk-amd64
ENV PATH $JAVA_HOME/bin:$PATH

USER jenkins