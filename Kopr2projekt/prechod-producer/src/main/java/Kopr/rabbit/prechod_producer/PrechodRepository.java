package Kopr.rabbit.prechod_producer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PrechodRepository extends JpaRepository<Prechod, Long>{

	Prechod findFirstByIdKartaOrderByDatumCasDesc(long idKarta);
}
