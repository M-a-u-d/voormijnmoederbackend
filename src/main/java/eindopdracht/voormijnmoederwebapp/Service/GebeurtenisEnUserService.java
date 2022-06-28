package eindopdracht.voormijnmoederwebapp.Service;


import eindopdracht.voormijnmoederwebapp.Dto.GebeurtenisEnUserDto;
import eindopdracht.voormijnmoederwebapp.Dto.GebeurtenisEnUserInputDto;
import eindopdracht.voormijnmoederwebapp.Entiteiten.GebeurtenisEnUser;

import eindopdracht.voormijnmoederwebapp.Repositories.GebeurtenisEnUserRepository;
import org.springframework.stereotype.Service;

@Service
public class GebeurtenisEnUserService {


    private final GebeurtenisEnUserRepository gebeurtenisEnUserRepository;

    public GebeurtenisEnUserService(GebeurtenisEnUserRepository gebeurtenisEnUserRepository) {
        this.gebeurtenisEnUserRepository = gebeurtenisEnUserRepository;
    }

    public GebeurtenisEnUser transferToContactVerzoek (GebeurtenisEnUserInputDto dto){

        var gebeurtenisEnUser = new GebeurtenisEnUser();

        gebeurtenisEnUser.setDatumAangemeld(dto.getDatumAangemeld());

        return gebeurtenisEnUser;
    }

    public GebeurtenisEnUserDto transfertoDto (GebeurtenisEnUser gebeurtenisEnUser) {

        var dto = new GebeurtenisEnUserDto();

        dto.setDatumAangemeld(gebeurtenisEnUser.getDatumAangemeld());

        return dto;
    }

}
