package Kopr.rabbit.prechod_producer;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@EnableScheduling
@SpringBootApplication
public class PrechodProducerApplication {

	@Autowired
	public RabbitTemplate rabbitTemplate;
	
	public static void main(String[] args) {
		SpringApplication.run(PrechodProducerApplication.class, args);
	}

}
