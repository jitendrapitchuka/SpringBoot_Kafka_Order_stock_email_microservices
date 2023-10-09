## Project Overview

This project consists of three microservices:

1. **Order Service**: This microservice acts as a producer.

2. **Stock Service**: This microservice is a consumer.

3. **Email Service**: Another consumer in the system.

Additionally, there is a base-domains module for Data Transfer Objects (DTOs). Specifically:

- **Order Event DTO**: This DTO is passed from the Order Service to the Kafka Broker and is consumed by both the Stock and Email Microservices.

