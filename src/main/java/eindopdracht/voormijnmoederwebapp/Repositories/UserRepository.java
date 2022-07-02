package eindopdracht.voormijnmoederwebapp.Repositories;

import eindopdracht.voormijnmoederwebapp.Entiteiten.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;


public interface UserRepository extends JpaRepository<User, String>, JpaSpecificationExecutor<User>{
    List<User> findAllUsersByNameEqualsIgnoreCase(String Name);
    static boolean existsByName(String userName) {
        return false;
    }


}