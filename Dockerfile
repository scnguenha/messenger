FROM tomcat:8.0

MAINTAINER scnguenha

COPY target/messenger.war /usr/local/tomcat/webapps/