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

    private String name;
    private String date;
    private String street;
    private String place;

//    @ManyToOne
//    private Member member;
}
