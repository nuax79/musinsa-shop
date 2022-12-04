# MUSINSA 상품 REST API 

## Framework Information
* Language : Java 17
* Framework : Spring boot 3.0.0
* Build : Gradle 7.5.1
* H2 Database (InMemory)

## Project Usage

### Project Git Clone
```bash
$ git clone https://github.com/nuax79/musinsa-shop.git
```

### Project Build
```bash
$ gradlew clean build -x test
```

### Project Test
```bash
$ gradlew clean test
```

### Project Run (port 8080)
```bash
$ gradlew bootrun
```

## Project Docker Usage

### Docker Build
```bash
docker build -t musinsa/musinsa-shop:latest -f Dockerfile .
```

### Docker images
```bash
docker images
```

### Docker run
```bash
docker run -d --name musinsa-shop -p 8080:8080 musinsa/musinsa-shop:latest 
```

### Docker verification
```bash
docker ps -a
```
