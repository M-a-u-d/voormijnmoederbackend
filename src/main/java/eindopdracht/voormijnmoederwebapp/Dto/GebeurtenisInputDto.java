package eindopdracht.voormijnmoederwebapp.Dto;

public class GebeurtenisInputDto {

    private String Naam;
    private String datum;
    private String straat;
    private String woonplaats;

    public GebeurtenisInputDto() {
    }


    public GebeurtenisInputDto(String naam, String datum, String straat, String woonplaats) {
        Naam = naam;
        this.datum = datum;
        this.straat = straat;
        this.woonplaats = woonplaats;
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
