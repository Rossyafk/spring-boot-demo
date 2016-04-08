# spring-boot-demo

## Executing the project

### Starting

#### Creating the docker images

```bash
cd job-launcher-microservice
mvn docker:build

cd job-execution-microservice
mvn docker:build
```

#### Starting the docker instances

To start the server, execute

```bash
cd docker
docker-compose up -d
```

TODO

### Sending commands

TODO
