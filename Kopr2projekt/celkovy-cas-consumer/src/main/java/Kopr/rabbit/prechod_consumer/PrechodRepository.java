package Kopr.rabbit.prechod_consumer;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PrechodRepository extends JpaRepository<Prechod, Integer>{

	List<Prechod> findByIdKartaOrderByDatumCas(int idKarta);
}
