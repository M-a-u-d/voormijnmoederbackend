package eindopdracht.voormijnmoederwebapp.Entiteiten;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class GebeurtenisEnUser {

    @EmbeddedId
    private GebeurtenisEnUserKey id;

    private LocalDateTime datumAangemeld;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId(value = "userName")
    @JoinColumn(name = "user_name")
    private User user;

    @ManyToOne
    @MapsId("gebeurtenisNaam")
    @JoinColumn(name = "gebeurtenis_naam")
    private Gebeurtenis gebeurtenis;

    public GebeurtenisEnUserKey getId() {
        return id;
    }

    public void setId(GebeurtenisEnUserKey id) {
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
