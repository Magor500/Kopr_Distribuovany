package Kopr.rabbit.prechod_consumer;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalDateTime;

import org.springframework.amqp.rabbit.support.ListenerExecutionFailedException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PrechodConsumerApplication {
	
	public static void main(String[] args) {
		try {
			SpringApplication.run(PrechodConsumerApplication.class, args);
		}catch(ListenerExecutionFailedException e){
			System.out.println(e.toString());
		}
		
	}

}
