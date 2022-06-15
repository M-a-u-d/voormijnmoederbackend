package eindopdracht.voormijnmoederwebapp.Dto;

public class ContactVerzoekInputDto {

    private String naam;
    private String vanWie;
    private String omschrijving;
    private String datum;

    public ContactVerzoekInputDto() {
    }
    public ContactVerzoekInputDto(String naam, String vanWie, String omschrijving, String datum) {
        this.naam = naam;
        this.vanWie = vanWie;
        this.omschrijving = omschrijving;
        this.datum = datum;
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
