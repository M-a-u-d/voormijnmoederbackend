package eindopdracht.voormijnmoederwebapp.Repositories;

import eindopdracht.voormijnmoederwebapp.Entiteiten.Gebeurtenis;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;


public interface GebeurtenisRepository extends JpaRepository <Gebeurtenis, String>, JpaSpecificationExecutor<Gebeurtenis> {
    List<Gebeurtenis> findAllGebeurtenissenByNaamEqualsIgnoreCase(String naam);

    void deleteByNaam(String naam);
}