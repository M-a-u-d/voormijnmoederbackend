package eindopdracht.voormijnmoederwebapp.Controller;

import eindopdracht.voormijnmoederwebapp.Dto.GebeurtenisDto;
import eindopdracht.voormijnmoederwebapp.Dto.GebeurtenisInputDto;
import eindopdracht.voormijnmoederwebapp.Dto.UserDto;
import eindopdracht.voormijnmoederwebapp.Service.GebeurtenisEnUserService;
import eindopdracht.voormijnmoederwebapp.Service.GebeurtenisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@RestController

public class GebeurtenisController {
    private final GebeurtenisService gebeurtenisService;
    private final GebeurtenisEnUserService gebeurtenisEnUserService;


    @Autowired
    public GebeurtenisController(GebeurtenisEnUserService gebeurtenisEnUserService,
                                 GebeurtenisService gebeurtenisService) {
        this.gebeurtenisEnUserService = gebeurtenisEnUserService;
        this.gebeurtenisService = gebeurtenisService;
    }

    @GetMapping("/gebeurtenissen")
    public ResponseEntity<List<GebeurtenisDto>> getAllgebeurtenissen(
            @RequestParam(value = "naam", required = false) Optional<String> naam) {
        List<GebeurtenisDto> dtos;

        if (naam.isEmpty()) {
           dtos = gebeurtenisService.getAllgebeurtenissen();
        } else {
            dtos = gebeurtenisService.getAllGebeurtenissenByNaam(naam.get());
        }

        return ResponseEntity.ok().body(dtos);
    }


    @GetMapping("/gebeurtenissen/{naam}")
    public ResponseEntity<Object> getGebeurtenis
            (@PathVariable String naam) {
        GebeurtenisDto gebeurtenis = gebeurtenisService.getGebeurtenisByNaam(naam);

        return ResponseEntity.ok().body(gebeurtenis);
    }

    @PostMapping("/gebeurtenissen")
    public ResponseEntity<Object> addGebeurtenis(
            @RequestBody GebeurtenisInputDto gebeurtenisInputDto) {
        GebeurtenisDto dto = gebeurtenisService.addGebeurtenis(gebeurtenisInputDto);

        return ResponseEntity.created(null).body(dto);
    }

//        throws URISyntaxException {
//        URI location = new URI("localhost.8081/televisions");
//        return ResponseEntity.created(location).build();
//    }

    @PutMapping("/gebeurtenissen/{naam}")
    public ResponseEntity<Object> updateGebeurtenis(
            @PathVariable String naam,
            @RequestBody GebeurtenisInputDto newGebeurtenis) {
        GebeurtenisDto dto = gebeurtenisService.updateGebeurtenis(naam, newGebeurtenis);

        return ResponseEntity.ok().body(dto);
    }

    @DeleteMapping("/gebeurtenissen/{naam}")
    public ResponseEntity<Object> deleteGebeurtenis(
            @PathVariable Long naam) {
        gebeurtenisService.deleteGebeurtenis(String.valueOf(naam));

        return ResponseEntity.noContent().build();
    }

    @GetMapping("/gebeurtenissen/users/{gebeurtenisNaam}")
    public Collection<UserDto> getGebeurtenisEnUserId(@PathVariable("gebeurtenisNaam") String gebeurtenisNaam){
        return gebeurtenisEnUserService.getGebeurtenisEnUsersByGebeurtenisNaam(gebeurtenisNaam);
    }
}