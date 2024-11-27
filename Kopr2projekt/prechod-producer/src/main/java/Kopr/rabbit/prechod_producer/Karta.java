package Kopr.rabbit.prechod_producer;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Karta {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_karta")
	private int idKarta;
}
