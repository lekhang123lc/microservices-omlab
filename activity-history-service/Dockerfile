FROM adoptopenjdk/openjdk11:jdk-11.0.9.1_1
# add user
RUN groupadd hungvi
RUN useradd hungvi -g hungvi -m -s /bin/bash
RUN echo "hungvi:dream" | chpasswd

# setup
ADD ./files/etc/profile /etc/profile
ENV TZ Asia/Ho_Chi_Minh
ENV LANG C.UTF-8

# see https://spring.io/guides/gs/spring-boot-docker/
VOLUME /tmp
ADD ./build/libs/activity-history-service-1.0-SNAPSHOT.war app.war
RUN sh -c 'touch /app.war'
ENV JAVA_OPTS="-XX:ThreadStackSize=256k"
ENTRYPOINT [ "sh", "-c", "exec java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /app.war" ]

