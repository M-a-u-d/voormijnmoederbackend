package eindopdracht.voormijnmoederwebapp.Service;


import eindopdracht.voormijnmoederwebapp.Dto.ContactVerzoekDto;
import eindopdracht.voormijnmoederwebapp.Dto.ContactVerzoekInputDto;
import eindopdracht.voormijnmoederwebapp.Repositories.ContactVerzoekRepository;
import eindopdracht.voormijnmoederwebapp.Entiteiten.ContactVerzoek;
import org.springframework.stereotype.Service;

@Service
public class ContactVerzoekService {


    private final ContactVerzoekRepository contactVerzoekRepository;

    public ContactVerzoekService(ContactVerzoekRepository contactVerzoekRepository) {
        this.contactVerzoekRepository = contactVerzoekRepository;
    }

    public ContactVerzoek transferToContactVerzoek (ContactVerzoekInputDto dto){

        var contactVerzoek = new ContactVerzoek();

        contactVerzoek.setNaam (dto.getNaam());
        contactVerzoek.setVanWie(dto.getVanWie());
        contactVerzoek.setOmschrijving(dto.getOmschrijving());
        contactVerzoek.setDatum(dto.getDatum());

        return contactVerzoek;
    }

    public ContactVerzoekDto transfertoDto (ContactVerzoek contactVerzoek) {

        var dto = new ContactVerzoekDto();

        dto.setId(contactVerzoek.getId());
        dto.setNaam(contactVerzoek.getNaam());
        dto.setVanWie(contactVerzoek.getVanWie());
        dto.setOmschrijving(contactVerzoek.getOmschrijving());
        dto.setDatum(contactVerzoek.getDatum());

        return dto;
    }

}
