//package eindopdracht.voormijnmoederwebapp;
//
//import eindopdracht.voormijnmoederwebapp.Repositories.RoleRepository;
//import eindopdracht.voormijnmoederwebapp.Entiteiten.Role;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
//import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
//import org.springframework.test.annotation.Rollback;
//
//
//import java.util.List;
//
//import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
//
//@DataJpaTest
//@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
//@Rollback(false)
//public class RoleRepositoryTests {
//
//    @Autowired
//    private RoleRepository repo;
//
//    @Test
//    public void testCreateRoles() {
//        Role user = new Role("User");
//        Role admin = new Role("Admin");
//        Role customer = new Role("Member");
//
//        repo.saveAll(List.of(user, admin, customer));
//
//        List<Role> listRoles = repo.findAll();
//
//        assertThat(listRoles.size()).isEqualTo(3);
//    }
//
//
//}
