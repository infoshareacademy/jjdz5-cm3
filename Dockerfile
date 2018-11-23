RUN apt-get update && apt-get upgrade -y
RUN mysqld create database CM3;