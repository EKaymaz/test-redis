FROM java:8

EXPOSE 8080

RUN git clone https://github.com/EKaymaz/test-redis.git

ADD /target/demo-0.0.1-SNAPSHOT.jar demo.jar


HEALTHCHECK --interval=10s --timeout=3s \
	CMD curl -v --fail http://localhost:${SERVER_PORT}/health || exit 1

ENTRYPOINT ["java","-jar","demo.jar"]
