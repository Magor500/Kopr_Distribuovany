package Kopr.rabbit.prechod_producer;

import java.time.LocalDate;
import java.time.LocalTime;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;


@Component
public class ProducerController {
	@Autowired
	public RabbitTemplate rabbitTemplate;
	@Autowired
	public KartaRepository kartaRepo;
	@Autowired
	public PrechodRepository prechodRepo;
	
	@Scheduled(fixedDelay = 1000)
	void publischPrechod() {
		int idKarta = (int)(Math.random() * 6 )+1;
		
		Prechod lastPrechod = prechodRepo.findFirstByIdKartaOrderByDatumCasDesc(idKarta);
		
		
		
		if(lastPrechod == null) {
			int idLokacia = 2 * ((int)(Math.random() * 5 )+1) - 1;
			this.rabbitTemplate.convertAndSend("prechody","",idKarta + " " + LocalDate.now() + " " + LocalTime.now() + " " + idLokacia);
		}else {
			//vonku
			
			System.out.println(lastPrechod.getIdKarta() + " " + lastPrechod.getDatumCas());
			if(lastPrechod.getIdLokacia() % 2 != 0 ) {
				int idLokacia = 2 * ((int)(Math.random() * 5 )+1);
				this.rabbitTemplate.convertAndSend("prechody","",idKarta + " " + LocalDate.now() + " " + LocalTime.now() + " " + idLokacia);
			}else { //dnu
				int idLokacia = 2 * ((int)(Math.random() * 5 )+1) - 1;
				this.rabbitTemplate.convertAndSend("prechody","",idKarta + " " + LocalDate.now() + " " + LocalTime.now() + " " + idLokacia);
			}
		}
	}
}
