package eindopdracht.voormijnmoederwebapp.Dto;


public class ContactVerzoekDto {
    private long Id;
    private String naam;
    private String vanWie;
    private String omschrijving;
    private String datum;

    public ContactVerzoekDto() {
    }

    public ContactVerzoekDto(long id, String naam, String vanWie, String omschrijving, String datum) {
       Id = id;
        this.naam = naam;
        this.vanWie = vanWie;
        this.omschrijving = omschrijving;
        this.datum = datum;
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
