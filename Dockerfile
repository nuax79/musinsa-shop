ARG JDK_VERSION=17-alpine
ARG JDK_IMAGE=openjdk:${JDK_VERSION}
FROM ${JDK_IMAGE} AS openjdk

ARG APPLICATION=musinsa
ARG VERSION=0.0.1-SNAPSHOT

ENV APPLICATION=${APPLICATION}
ENV VERSION=${VERSION}

RUN mkdir /app
RUN addgroup --system javauser && adduser -S -s /bin/false -G javauser javauser

WORKDIR /app
COPY ./build/libs/${APPLICATION}-${VERSION}.jar ./application.jar
RUN chown -R javauser:javauser /app
USER javauser

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "./application.jar"]


