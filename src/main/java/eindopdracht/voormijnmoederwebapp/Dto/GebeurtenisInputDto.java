package eindopdracht.voormijnmoederwebapp.Dto;

public class GebeurtenisInputDto {

    private String Naam;
    private String datum;
    private String straat;
    private String woonplaats;
    private String naamwaar;
    private String opmering;
    private String organisator;


    public GebeurtenisInputDto() {
    }

    public GebeurtenisInputDto(String naam, String datum, String straat, String woonplaats, String naamwaar, String opmering, String organisator) {
        Naam = naam;
        this.datum = datum;
        this.straat = straat;
        this.woonplaats = woonplaats;
        this.naamwaar = naamwaar;
        this.opmering = opmering;
        this.organisator = organisator;
    }

    public String getNaam() {
        return Naam;
    }

    public void setNaam(String naam) {
        Naam = naam;
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

    public String getOpmering() {
        return opmering;
    }

    public void setOpmering(String opmering) {
        this.opmering = opmering;
    }

    public String getOrganisator() {
        return organisator;
    }

    public void setOrganisator(String organisator) {
        this.organisator = organisator;
    }
}