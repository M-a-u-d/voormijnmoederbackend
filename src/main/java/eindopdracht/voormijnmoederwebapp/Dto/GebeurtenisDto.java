package eindopdracht.voormijnmoederwebapp.Dto;

public class GebeurtenisDto {
    private long id;
    private String Naam;
    private String datum;
    private String straat;
    private String woonplaats;
    private String naamwaar;
    private String opmerking;
    private String organisator;

    public GebeurtenisDto() {
    }

    public GebeurtenisDto(long id, String naam, String datum, String straat, String woonplaats, String naamwaar, String opmerking, String organisator) {
        this.id = id;
        Naam = naam;
        this.datum = datum;
        this.straat = straat;
        this.woonplaats = woonplaats;
        this.naamwaar = naamwaar;
        this.opmerking = opmerking;
        this.organisator = organisator;
    }

    public String getNaamwaar() {
        return naamwaar;
    }

    public void setNaamwaar(String naamwaar) {
        this.naamwaar = naamwaar;
    }

    public String getOpmering() {
        return opmerking;
    }

    public void setOpmering(String opmering) {
        this.opmerking = opmering;
    }

    public String getOrganisator() {
        return organisator;
    }

    public void setOrganisator(String organisator) {
        this.organisator = organisator;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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


}
