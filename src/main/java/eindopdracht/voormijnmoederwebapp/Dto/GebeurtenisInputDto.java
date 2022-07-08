package eindopdracht.voormijnmoederwebapp.Dto;

public class GebeurtenisInputDto {

    private String Naam;
    private String username;
    private String datum;
    private String straat;
    private String woonplaats;
    private String naamwaar;
    private String opmerking;
    private String organisator;

    private UserDto userDto;


    public GebeurtenisInputDto() {
    }

    public UserDto getUserDto() {
        return userDto;
    }

    public void setUserDto(UserDto userDto) {
        this.userDto = userDto;
    }

    public String getNaam() {
        return Naam;
    }

    public void setNaam(String naam) {
        Naam = naam;
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
}
