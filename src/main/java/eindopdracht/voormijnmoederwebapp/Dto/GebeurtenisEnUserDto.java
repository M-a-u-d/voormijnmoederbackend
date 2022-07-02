package eindopdracht.voormijnmoederwebapp.Dto;


import java.time.LocalDateTime;

public class GebeurtenisEnUserDto {

    private LocalDateTime datumAangemeld;

    public GebeurtenisEnUserDto() {
    }

    public GebeurtenisEnUserDto(LocalDateTime datumAangemeld) {
        this.datumAangemeld = datumAangemeld;
    }

    public LocalDateTime getDatumAangemeld() {
        return datumAangemeld;
    }

    public void setDatumAangemeld(LocalDateTime datumAangemeld) {
        this.datumAangemeld = datumAangemeld;
    }
}

