# warehouse-service

## General info
Simple data warehouse application which provides analytics data via GET endpoints.
The application was deployed on AWS (Elastic Beanstalk) and it is available on: </br></br>
**http://warehouse-env.eba-4tqrmjdu.eu-west-2.elasticbeanstalk.com/**


## Stack technology
 * JVM 11
 * Kotlin 
 * Spring
 * Springboot
 * OpenApi
 * MongoDB
 * Junit
 * Mockk
 * Gradle

Code was covered with three types of tests:
* unit
* integration
* controller tests

## Setup

```
git clone https://github.com/bartlomiej87/warehouse-service.git
./gradlew build
java -jar build/libs/warehouse-<version>.jar
```

Note: before running application on local env you need to setup mongodb.</br>
Docker setup:
```
docker pull mongo:latest
docker run -d -p 27017:27017 --name <imageId> mongo:latest
```

## API
Api contract was defined in [api.yml](docs/openapi/api.yml) </br>
There is subtask(openApiGenerate) of gradle build which generates API based on api.yaml file.
There are generated API interfaces and API model classes.

## Usage
An application was deployed on AWS(Elastic beanstalk). Mongodb is installed (via ssh) on the same EC2 as application - as purpose of simplify setup.

Examples of requests:
```
http://warehouse-env.eba-4tqrmjdu.eu-west-2.elasticbeanstalk.com/v1/analytics?metrics=clicks&metrics=impressions&dimensions=campaign&dateFrom=2019-01-20&dateTo=2019-01-20
```
```
http://warehouse-env.eba-4tqrmjdu.eu-west-2.elasticbeanstalk.com/v1/analytics/campaign/top?sortBy=ctr&dateFrom=2019-04-20&dateTo=2019-04-20
```

I would suggest to import [api.yml](docs/openapi/api.yml) into Postman and send request via Postman

## Possible extensions
 * dockerizing app (deploy to EKS)
 * moving mongodb to another machine
 * CI/CD
 * terraform scripts (deploy to AWS)
 * adding profiles dev, stg, prod