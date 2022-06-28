package eindopdracht.voormijnmoederwebapp.Dto;

import java.time.LocalDateTime;

public class GebeurtenisEnUserInputDto {



    private LocalDateTime datumAangemeld;

    public GebeurtenisEnUserInputDto() {
    }

    public GebeurtenisEnUserInputDto(LocalDateTime datumAangemeld) {
        this.datumAangemeld = datumAangemeld;


}

    public LocalDateTime getDatumAangemeld() {
        return datumAangemeld;
    }

    public void setDatumAangemeld(LocalDateTime datumAangemeld) {
        this.datumAangemeld = datumAangemeld;
    }
}
