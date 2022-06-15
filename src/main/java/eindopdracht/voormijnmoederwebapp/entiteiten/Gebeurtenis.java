package eindopdracht.voormijnmoederwebapp.entiteiten;

import lombok.Data;


import javax.persistence.*;

@Data
@Entity
@Table(name = "gebeurtenis")

public class Gebeurtenis {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String Naam;
    private String datum;
    private String straat;
    private String woonplaats;

//    @ManyToOne
//    private Member member;
}
