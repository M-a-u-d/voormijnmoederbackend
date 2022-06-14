package eindopdracht.voormijnmoederwebapp.Repositories;

import eindopdracht.voormijnmoederwebapp.entiteiten.Gebeurtenis;
import org.springframework.data.jpa.repository.JpaRepository;



public interface GebeurtenisRepository extends JpaRepository<Gebeurtenis, Long> {

}