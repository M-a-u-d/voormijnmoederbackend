package eindopdracht.voormijnmoederwebapp.Entiteiten;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "gebeurtenissen")
public class Gebeurtenis {

    @Id
    @Column (nullable = false)
    private String naam;

    @Column (nullable = false)
    private String username;

    @Column (nullable = false)
    private String datum;
    @Column
    private String straat;
    @Column
    private String woonplaats;
    @Column
    private String naamwaar;
    @Column
    private String opmerking;
    @Column
    private String organisator;

    @OneToMany(mappedBy = "user")
    @JsonIgnore
    private List<GebeurtenisEnUser> gebeurtenisEnUsers;

    public Gebeurtenis() {
    }


    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getDatum() {
        return datum;
    }

    public void setDatum(String datum) {
        this.datum = datum;
    }

    public String getStraat() {
        return straat;
    }

    public void setStraat(String straat) {
        this.straat = straat;
    }

    public String getWoonplaats() {
        return woonplaats;
    }

    public void setWoonplaats(String woonplaats) {
        this.woonplaats = woonplaats;
    }

    public String getNaamwaar() {
        return naamwaar;
    }

    public void setNaamwaar(String naamwaar) {
        this.naamwaar = naamwaar;
    }

    public String getOpmerking() {
        return opmerking;
    }

    public void setOpmerking(String opmerking) {
        this.opmerking = opmerking;
    }

    public String getOrganisator() {
        return organisator;
    }

    public void setOrganisator(String organisator) {
        this.organisator = organisator;
    }

    public List<GebeurtenisEnUser> getGebeurtenisEnUsers() {
        return gebeurtenisEnUsers;
    }

    public void setGebeurtenisEnUsers(List<GebeurtenisEnUser> gebeurtenisEnUsers) {
        this.gebeurtenisEnUsers = gebeurtenisEnUsers;
    }

}
