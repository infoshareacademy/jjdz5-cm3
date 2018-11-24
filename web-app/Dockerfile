FROM jboss/wildfly
MAINTAINER "Delegations"
RUN /opt/jboss/wildfly/bin/add-user.sh username password --silent
CMD ["echo Waiting 5 seconds"]
CMD ["sleep", "5"]
CMD ["echo Starting Wildfly"]
CMD ["/opt/jboss/wildfly/bin/standalone.sh", "-b", "0.0.0.0", "-bmanagement", "0.0.0.0"]
