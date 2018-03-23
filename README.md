# notification-management
Case study for managing notifications

Note: used H2 db
Client for H2 db: http://localhost:8080/h2-console
 
Driver Class: org.h2.Driver
JDBC URL: jdbc:h2:mem:testdb
User Name: sa
Password:
SELECT * FROM NOTIFICATION_MESSAGE_AUDIT

1. Send message to system:
url--> http://localhost:8080/notify
request body--> {"to":"testTO","from":"testFrom","content":"testing system","deliveryMedium":["email","slack","na"]}
request type --> POST
