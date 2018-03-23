package com.casestudy.notification;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.support.converter.MappingJackson2MessageConverter;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.jms.support.converter.MessageType;

@SpringBootApplication
@EnableJms

//@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class,HibernateJpaAutoConfiguration.class}) //This is required if we are not using the database
public class NotificationManagementApp {

	public static void main(String[] args) {
		SpringApplication.run(NotificationManagementApp.class, args);
	}
	
	/*"Cannot convert object of type [com.casestudy.notification.domain.NotificationMessage] to JMS message. "
	  "Supported message payloads are: String, byte array, Map<String,?>, Serializable object."*/
	
	 @Bean
	 public MessageConverter jacksonJmsMessageConverter() {
		 MappingJackson2MessageConverter converter = new MappingJackson2MessageConverter();
		 converter.setTargetType(MessageType.TEXT);
		 converter.setTypeIdPropertyName("_type");
		 return converter;
  }

}
