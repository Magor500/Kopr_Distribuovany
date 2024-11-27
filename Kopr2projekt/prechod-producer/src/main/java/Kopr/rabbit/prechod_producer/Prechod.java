package Kopr.rabbit.prechod_producer;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;

@Entity
public class Prechod {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_prechod")
	private int idPrechod;
	
	@Column(name="datum_cas")
	private Timestamp datumCas;
	
	@Column(name="id_lokacia")
	private int idLokacia;
	
	@Column(name="id_karta")
	private int idKarta;
	
	public Timestamp getDatumCas() {
		return datumCas;
	}
	
	public Prechod() {
		
	}
	
	public Prechod(Timestamp datumCas, int idLokacia, int idKarta) {
		super();
		this.datumCas = datumCas;
		this.idLokacia = idLokacia;
		this.idKarta = idKarta;
	}
	public void setDatumCas(Timestamp datumCas) {
		this.datumCas = datumCas;
	}
	public long getIdLokacia() {
		return idLokacia;
	}
	public void setIdLokacia(int idLokacia) {
		this.idLokacia = idLokacia;
	}
	public long getIdKarta() {
		return idKarta;
	}
	public void setIdKarta(int idKarta) {
		this.idKarta = idKarta;
	}
}
