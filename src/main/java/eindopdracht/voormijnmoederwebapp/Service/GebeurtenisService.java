package eindopdracht.voormijnmoederwebapp.Service;

import eindopdracht.voormijnmoederwebapp.Dto.GebeurtenisDto;
import eindopdracht.voormijnmoederwebapp.Dto.GebeurtenisInputDto;
import eindopdracht.voormijnmoederwebapp.Entiteiten.Gebeurtenis;
import eindopdracht.voormijnmoederwebapp.Exeptions.RecordNotFoundException;
import eindopdracht.voormijnmoederwebapp.Repositories.GebeurtenisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;

@Service
public class GebeurtenisService {

    private final GebeurtenisRepository gebeurtenisRepository;

    @Autowired
    public GebeurtenisService(GebeurtenisRepository gebeurtenisRepository) {
        this.gebeurtenisRepository = gebeurtenisRepository;
    }

    public List<GebeurtenisDto> getAllgebeurtenissen() {
        List<Gebeurtenis> gbList = gebeurtenisRepository.findAll();
        List<GebeurtenisDto> gbDtoList = new ArrayList<>();

        for(Gebeurtenis gb : gbList) {
            GebeurtenisDto dto = transfertoDto(gb);
            gbDtoList.add(dto);
        }
        return gbDtoList;
    }

    public List<GebeurtenisDto> getAllGebeurtenissenByNaam(String naam) {
        List<Gebeurtenis> gbList = gebeurtenisRepository.findAllGebeurtenissenByNaamEqualsIgnoreCase(naam);
        List<GebeurtenisDto> gbDtoList = new ArrayList<>();

        for(Gebeurtenis gb : gbList) {
            GebeurtenisDto dto = transfertoDto(gb);
            gbDtoList.add(dto);
        }
        return gbDtoList;

    }

    public GebeurtenisDto getGebeurtenisByNaam(String naam) {

        if (gebeurtenisRepository.findById(naam).isPresent()){
            Gebeurtenis gb = gebeurtenisRepository.findById(naam).get();
            return transfertoDto(gb);
        } else {
            throw new RecordNotFoundException("geen gebeurtenis gevonden");
        }
    }

    public GebeurtenisDto addGebeurtenis(GebeurtenisInputDto dto) {

            Gebeurtenis gb = transferToGebeurtenis(dto);
            gebeurtenisRepository.save(gb);

            return transfertoDto(gb);


    }

    public GebeurtenisDto updateGebeurtenis(String naam, GebeurtenisInputDto inputDto) {

        if (gebeurtenisRepository.findById(naam).isPresent()){

            Gebeurtenis gb = gebeurtenisRepository.findById(naam).get();

            Gebeurtenis gb1 = transferToGebeurtenis(inputDto);
            gb1.setNaam(gb.getNaam());

            gebeurtenisRepository.save(gb1);

            return transfertoDto(gb1);

        } else {

            throw new  RecordNotFoundException("geen gebeurtenis gevonden");

        }


    }

    public void deleteGebeurtenis(@RequestBody String naam) {

        gebeurtenisRepository.deleteByNaam(naam);

    }

    public Gebeurtenis transferToGebeurtenis (GebeurtenisInputDto dto){

        var Gebeurtenis = new Gebeurtenis();

        Gebeurtenis.setNaam (dto.getNaam());
        Gebeurtenis.setDatum(dto.getDatum());
        Gebeurtenis.setStraat(dto.getStraat());
        Gebeurtenis.setWoonplaats(dto.getWoonplaats());
        Gebeurtenis.setNaamwaar(dto.getNaamwaar());
        Gebeurtenis.setOpmerking(dto.getOpmerking());
        Gebeurtenis.setOrganisator(dto.getOrganisator());

        return Gebeurtenis;
    }

    public GebeurtenisDto transfertoDto (Gebeurtenis gebeurtenis) {

        var dto = new GebeurtenisDto();


        dto.setNaam(gebeurtenis.getNaam());
        dto.setDatum(gebeurtenis.getDatum());
        dto.setStraat(gebeurtenis.getStraat());
        dto.setWoonplaats(gebeurtenis.getWoonplaats());
        dto.setNaamwaar(gebeurtenis.getNaamwaar());
        dto.setOpmerking(gebeurtenis.getOpmerking());
        dto.setOrganisator(gebeurtenis.getOrganisator());

        return dto;
    }

}
