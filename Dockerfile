# syntax=docker/dockerfile:labs
FROM maven:3.8.5-openjdk-17 as build

WORKDIR /build
COPY --parents pom.xml camunda-service/pom.xml core-service/pom.xml gateway-service/pom.xml notification-service/pom.xml ./
RUN mvn dependency:resolve

COPY ./ ./
RUN <<-EOF
	mkdir dists/
	for item in camunda-service core-service gateway-service notification-service; do
	  pushd ${item}/
	  mvn package -DskipTests
	  find target -maxdepth 1 -type f -name "${item}-*.jar" -exec cp {} ../dists/${item}.jar \;
	  popd
	done
EOF

FROM openjdk:17-alpine
RUN apk add curl

COPY --from=build /build/dists/ /app/

# CMD [ "java", "-jar", "notification-service.jar"]
