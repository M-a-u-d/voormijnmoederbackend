package eindopdracht.voormijnmoederwebapp.Repositories;

import eindopdracht.voormijnmoederwebapp.entiteiten.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MemberRepository extends JpaRepository<Member, Long> {

    List<Member> findAllByLastNameContainingOrderByLastName(String lastName);

}