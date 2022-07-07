package eindopdracht.voormijnmoederwebapp.Service;

import eindopdracht.voormijnmoederwebapp.Dto.GebeurtenisDto;
import eindopdracht.voormijnmoederwebapp.Dto.UserDto;
import eindopdracht.voormijnmoederwebapp.Entiteiten.Gebeurtenis;
import eindopdracht.voormijnmoederwebapp.Entiteiten.GebeurtenisEnUser;
import eindopdracht.voormijnmoederwebapp.Entiteiten.GebeurtenisEnUserKey;
import eindopdracht.voormijnmoederwebapp.Entiteiten.User;
import eindopdracht.voormijnmoederwebapp.Exeptions.RecordNotFoundException;
import eindopdracht.voormijnmoederwebapp.Repositories.GebeurtenisEnUserRepository;
import eindopdracht.voormijnmoederwebapp.Repositories.GebeurtenisRepository;
import eindopdracht.voormijnmoederwebapp.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashSet;

@Service
public class GebeurtenisEnUserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private GebeurtenisRepository gebeurtenisRepository;

    @Autowired
    private GebeurtenisEnUserRepository gebeurtenisEnUserRepository;


    public Collection<UserDto> getGebeurtenisEnUsersByGebeurtenisNaam(String gebeurtenisNaam) {
        Collection<UserDto> dtos = new HashSet<>();
        Collection<GebeurtenisEnUser> gebeurtenisEnUsers = gebeurtenisEnUserRepository.findAllByGebeurtenisNaam(gebeurtenisNaam);
        for (GebeurtenisEnUser gebeurtenisEnUser : gebeurtenisEnUsers) {
            User user = gebeurtenisEnUser.getUser();
            UserDto dto = new UserDto();

            user.setUsername(dto.getUsername());
            user.setId(dto.getId());
            user.setPassword(dto.getPassword());
            user.setEnabled(dto.getEnabled());
            user.setApikey(dto.getApikey());
            user.setEmail(dto.getEmail());

            dtos.add(dto);
        }
        return dtos;
    }

    public Collection<GebeurtenisDto> getGebeurtenisEnUsersByUserUsername(String userUsername) {
        Collection<GebeurtenisDto> dtos = new HashSet<>();
        Collection<GebeurtenisEnUser> gebeurtenisEnUsers = GebeurtenisEnUserRepository.findAllByUserName(userUsername);
        for (GebeurtenisEnUser gebeurtenisEnUser : gebeurtenisEnUsers) {
            Gebeurtenis gebeurtenis = gebeurtenisEnUser.getGebeurtenis();
            var dto = new GebeurtenisDto();

            dto.setNaam(gebeurtenis.getNaam());
            dto.setDatum(gebeurtenis.getDatum());
            dto.setStraat(gebeurtenis.getStraat());
            dto.setWoonplaats(gebeurtenis.getWoonplaats());
            dto.setNaamwaar(gebeurtenis.getNaamwaar());
            dto.setOpmerking(gebeurtenis.getOpmerking());
            dto.setOrganisator(gebeurtenis.getOrganisator());

            dtos.add(dto);
        }
        return dtos;
    }
    public GebeurtenisEnUserKey addGebeurtenisEnUser(String userUsername, String gebeurtenisNaam) {
        var gebeurtenisEnUser = new GebeurtenisEnUser();
        if (!userRepository.existsById(userUsername)) {throw new RecordNotFoundException();}
        User user = userRepository.findById(userUsername).orElse(null);
        if (!gebeurtenisRepository.existsById(gebeurtenisNaam)) {throw new RecordNotFoundException();}
        Gebeurtenis gebeurtenis = gebeurtenisRepository.findById(gebeurtenisNaam).orElse(null);
        gebeurtenisEnUser.setUser(user);
        gebeurtenisEnUser.setGebeurtenis(gebeurtenis);
        GebeurtenisEnUserKey id = new GebeurtenisEnUserKey(userUsername, gebeurtenisNaam);
        gebeurtenisEnUser.setId(id);
        gebeurtenisEnUserRepository.save(gebeurtenisEnUser);

        return id;
    }

}
