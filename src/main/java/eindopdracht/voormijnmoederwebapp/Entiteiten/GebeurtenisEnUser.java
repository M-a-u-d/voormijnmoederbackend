package eindopdracht.voormijnmoederwebapp.Entiteiten;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "GebeurtenisEnUser")

    public class GebeurtenisEnUser {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime datumAangemeld;

    @ManyToOne
    @JsonManagedReference
    private Gebeurtenis gebeurtenis;

    @ManyToOne
    private User user;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getDatumAangemeld() {
        return datumAangemeld;
    }

    public void setDatumAangemeld(LocalDateTime datumAangemeld) {
        this.datumAangemeld = datumAangemeld;
    }

    public Gebeurtenis getGebeurtenis() {
        return gebeurtenis;
    }

    public void setGebeurtenis(Gebeurtenis gebeurtenis) {
        this.gebeurtenis = gebeurtenis;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
