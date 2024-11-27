package Kopr.rabbit.prechod_consumer;

import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDateTime;

import org.springframework.amqp.AmqpRejectAndDontRequeueException;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class ConsumerController {
	@Autowired
	public KartaRepository kartaRepo;
	@Autowired
	public PrechodRepository prechodRepo;
	
	@RabbitListener(queues = "prechod")
	public void consumeData(String payload) {
		
		System.out.println(payload);
		
		String[] split = payload.split(" ");
		
		System.out.println(split[2]);
		
		String[] splitTime = split[2].split("\\.");
				
		String timestamp = split[1] + " " + splitTime[0];
		
		
		
		Prechod prechod = new Prechod(Timestamp.valueOf(timestamp),Integer.parseInt(split[3]),Integer.parseInt(split[0]));
		
		if(kartaRepo.findAllIdKartas().contains(prechod.getIdKarta())) {
			prechodRepo.save(prechod);
		}else {
			throw new AmqpRejectAndDontRequeueException("No access");
		}
	}
}
