FROM quay.io/wildfly/wildfly

EXPOSE 8080

ADD jakarta-demo.war /opt/jboss/wildfly/standalone/deployments/

LABEL authors="Sebastian Molin"

CMD ["/opt/jboss/wildfly/bin/standalone.sh", "-b", "0.0.0.0"]