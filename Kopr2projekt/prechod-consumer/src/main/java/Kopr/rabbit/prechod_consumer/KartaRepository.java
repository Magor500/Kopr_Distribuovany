package Kopr.rabbit.prechod_consumer;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface KartaRepository extends JpaRepository<Karta, Integer>{
	
	@Query("SELECT k.idKarta FROM Karta k")
	List<Integer> findAllIdKartas();
}
