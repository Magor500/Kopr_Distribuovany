package Kopr.rabbit.prechod_producer;

import java.time.LocalDate;
import java.time.LocalTime;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;


@Component
public class Producer {
	@Autowired
	public RabbitTemplate rabbitTemplate;
	
	@Scheduled(fixedDelay = 1000)
	void publischCelkovyCas() {
		int idKarta = ((int)(Math.random() * 3 )+1);
		this.rabbitTemplate.convertAndSend("celkovyCas","ziskaj",idKarta);
	}
	
	@RabbitListener(queues = "vypis")
	public void consumeData(String payload) {
		System.out.println(payload);
	}
}
