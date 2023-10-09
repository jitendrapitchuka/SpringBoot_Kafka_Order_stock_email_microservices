# SpringBoot_Kafka_Order_stock_email_microservices

##There are 3 microservices used in this project.
1.Order Service
2.Stock Service
3.Email Service

##Order service is a Producer.

##Stock and Email Services are consumers.

###On top of this there is a base-domains for Dto's
1.Order event dto will pass from order service to kafka Broker
2.The same Order event will consume by Stock and Email Microservices.
