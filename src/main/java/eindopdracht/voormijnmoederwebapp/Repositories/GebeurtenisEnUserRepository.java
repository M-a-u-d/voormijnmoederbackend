package eindopdracht.voormijnmoederwebapp.Repositories;

import eindopdracht.voormijnmoederwebapp.Entiteiten.GebeurtenisEnUser;
import eindopdracht.voormijnmoederwebapp.Entiteiten.GebeurtenisEnUserKey;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;

public interface GebeurtenisEnUserRepository extends JpaRepository <GebeurtenisEnUser, GebeurtenisEnUserKey> {

    static Collection<GebeurtenisEnUser> findAllByUserName(String userName){
        return null;
    }

    Collection<GebeurtenisEnUser> findAllByGebeurtenisNaam(String gebeurtenisNaam);
}
