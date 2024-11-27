package Kopr.rabbit.prechod_consumer;

import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

import org.springframework.amqp.AmqpRejectAndDontRequeueException;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;



@Component
public class Consumer {
	@Autowired
	public RabbitTemplate rabbitTemplate;
	@Autowired
	public KartaRepository kartaRepo;
	@Autowired
	public PrechodRepository prechodRepo;
	
	@RabbitListener(queues = "ziskaj")
	public void consumeData(String payload) {
		int idKarta = Integer.parseInt(payload);
		
		List<Prechod> prechody = prechodRepo.findByIdKartaOrderByDatumCas(idKarta);
		
		int timeInSeconds = 0;
		if(prechody.size() % 2 == 0) {
			for(int i = 0 ; i < prechody.size(); i +=2) {
				String[] dnu = prechody.get(i).getDatumCas().toString().split(" ");
				String[] von = prechody.get(i+1).getDatumCas().toString().split(" ");
				
				String[] timeDnu = dnu[1].split("\\.");
				String[] timeVon = von[1].split("\\.");
				
				Duration duration = Duration.between(Time.valueOf(timeDnu[0]).toLocalTime()
				, Time.valueOf(timeVon[0]).toLocalTime());
				
				timeInSeconds += duration.getSeconds();
			}
		}else {
			for(int i = 0 ; i < prechody.size()-1; i +=2) {
				String[] dnu = prechody.get(i).getDatumCas().toString().split(" ");
				String[] von = prechody.get(i+1).getDatumCas().toString().split(" ");
				
				String[] timeDnu = dnu[1].split("\\.");
				String[] timeVon = von[1].split("\\.");
				
				Duration duration = Duration.between(Time.valueOf(timeDnu[0]).toLocalTime()
						, Time.valueOf(timeVon[0]).toLocalTime());
				
				timeInSeconds += duration.getSeconds();
			}
			
			
			
			
			String[] dnu = prechody.get(prechody.size()-1).getDatumCas().toString().split(" ");
			String[] timeDnu = dnu[1].split("\\.");
			
			Duration duration = Duration.between(Time.valueOf(timeDnu[0]).toLocalTime()
					, LocalTime.now());
			
			timeInSeconds += duration.getSeconds();
		}
		
		int seconds = timeInSeconds % 60;
		int timeInMinutes = timeInSeconds / 60;
		int minutes = timeInMinutes % 60; 
		int hours = timeInMinutes / 60;
		
		rabbitTemplate.convertAndSend("celkovyCas","vypis", "Karta s id: " + idKarta + " " + hours +" hod " + minutes +" min " + seconds +" sec");
		
	}
}
