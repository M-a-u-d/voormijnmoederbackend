package eindopdracht.voormijnmoederwebapp.Service;

import eindopdracht.voormijnmoederwebapp.Dto.ContactVerzoekDto;
import eindopdracht.voormijnmoederwebapp.Dto.GebeurtenisDto;
import eindopdracht.voormijnmoederwebapp.Dto.GebeurtenisInputDto;
import eindopdracht.voormijnmoederwebapp.Repositories.GebeurtenisRepository;
import eindopdracht.voormijnmoederwebapp.entiteiten.Gebeurtenis;
import org.springframework.stereotype.Service;

@Service
public class GebeurtenisService {

    private final GebeurtenisRepository gebeurtenisRepository;


    public GebeurtenisService(GebeurtenisRepository gebeurtenisRepository) {
        this.gebeurtenisRepository = gebeurtenisRepository;
    }

    public Gebeurtenis transferToGebeurtenis (GebeurtenisInputDto dto){

        var Gebeurtenis = new Gebeurtenis();

        Gebeurtenis.setNaam (dto.getNaam());
        Gebeurtenis.setDatum(dto.getDatum());
        Gebeurtenis.setStraat(dto.getStraat());
        Gebeurtenis.setWoonplaats(dto.getWoonplaats());

        return Gebeurtenis;
    }

    public GebeurtenisDto transfertoDto (Gebeurtenis gebeurtenis) {

        var dto = new GebeurtenisDto();

        dto.setId(gebeurtenis.getId());
        dto.setNaam(gebeurtenis.getNaam());
        dto.setDatum(gebeurtenis.getDatum());
        dto.setStraat(gebeurtenis.getStraat());
        dto.setWoonplaats(gebeurtenis.getWoonplaats());

        return dto;
    }

}
