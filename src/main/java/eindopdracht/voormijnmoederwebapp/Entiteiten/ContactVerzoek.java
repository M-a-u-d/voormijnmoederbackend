package eindopdracht.voormijnmoederwebapp.Entiteiten;


import javax.persistence.*;

@Entity
@Table(name = "Contactverzoek")
    public class ContactVerzoek {

    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String naam;

    @Column
    private String vanWie;

    @Column
    private String omschrijving;

    @Column
    private String datum;

    public ContactVerzoek() {
    }

    public ContactVerzoek(String naam, String vanWie, String omschrijving, String datum) {
        this.naam = naam;
        this.vanWie = vanWie;
        this.omschrijving = omschrijving;
        this.datum = datum;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public String getVanWie() {
        return vanWie;
    }

    public void setVanWie(String vanWie) {
        this.vanWie = vanWie;
    }

    public String getOmschrijving() {
        return omschrijving;
    }

    public void setOmschrijving(String omschrijving) {
        this.omschrijving = omschrijving;
    }

    public String getDatum() {
        return datum;
    }

    public void setDatum(String datum) {
        this.datum = datum;
    }
}
