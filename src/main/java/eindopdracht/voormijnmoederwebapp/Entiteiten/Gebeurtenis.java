package eindopdracht.voormijnmoederwebapp.Entiteiten;


import javax.persistence.*;

@Entity
@Table(name = "gebeurtenissen")
public class Gebeurtenis {

    @Id
    @GeneratedValue
    long Id;

    @Column
    private String naam;
    @Column
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

//    @ManyToOne
//    private User user;


    public Gebeurtenis() {
    }



    public long getId() {
        return Id;
    }

    public void setId(long id) {
        Id = id;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        naam = naam;
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
}
