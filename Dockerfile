FROM tomcat:8.5.50-jdk8-openjdk
LABEL maintainer="andresta@deltadatamandiri.com"
COPY target/ACC_Hunter_Web.war /usr/local/tomcat/webapps/
EXPOSE 8080
CMD ["catalina.sh", "run"]
