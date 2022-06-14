package eindopdracht.voormijnmoederwebapp.entiteiten;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "members")
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String firstName;

    private String lastName;

    private String address;

    @OneToMany(mappedBy = "member")
    @JsonIgnore
    private List<Gebeurtenis> borrowedCopies;


}
