# MUSINSA 상품 REST API 

## Framework Information
* Language : Java 17
* Framework : Spring boot 3.0.0
* Build : Gradle 7.5.1
* H2 Database (InMemory)



## Usage

### Gradle Build
```bash
$ gradlew clean build -x test
```

### Gradle Test
```bash
$ gradlew clean test
```

### Gradle Run
```bash
$ gradlew bootrun
```

### Docker Build
```bash
docker build -t ghcr.io/misoboy/musinsa-api:latest -f Dockerfile .
```

### Docker run
```bash
docker run -d --name musinsa-api -p 8080:8080 ghcr.io/misoboy/musinsa-api:latest
```
