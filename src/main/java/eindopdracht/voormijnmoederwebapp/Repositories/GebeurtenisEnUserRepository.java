package eindopdracht.voormijnmoederwebapp.Repositories;

import eindopdracht.voormijnmoederwebapp.Entiteiten.GebeurtenisEnUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;

public interface GebeurtenisEnUserRepository extends JpaRepository <GebeurtenisEnUser, LocalDateTime> {
}
