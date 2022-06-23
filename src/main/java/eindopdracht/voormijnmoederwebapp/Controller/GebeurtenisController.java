package eindopdracht.voormijnmoederwebapp.Controller;

import eindopdracht.voormijnmoederwebapp.Dto.GebeurtenisDto;
import eindopdracht.voormijnmoederwebapp.Dto.GebeurtenisInputDto;
import eindopdracht.voormijnmoederwebapp.Service.GebeurtenisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController

public class GebeurtenisController {

    @Autowired
    public GebeurtenisService gebeurtenisService;

    @Autowired
    public GebeurtenisController(GebeurtenisService gebeurtenisService) {
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


    @GetMapping("/gebeurtenissen/{id}")
    public ResponseEntity<Object> getGebeurtenis(@PathVariable Long id) {

        GebeurtenisDto gebeurtenis = gebeurtenisService.getGebeurtenisById(id);

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

    @PutMapping("/gebeurtenissen/{id}")
    public ResponseEntity<Object> updateGebeurtenis(
            @PathVariable long id,
            @RequestBody GebeurtenisInputDto newGebeurtenis) {
        GebeurtenisDto dto = gebeurtenisService.updateGebeurtenis(id, newGebeurtenis);
        return ResponseEntity.ok().body(dto);
    }



    @DeleteMapping("/gebeurtenissen/{id}")
    public ResponseEntity<Object> deleteGebeurtenis(@PathVariable Long id) {

        gebeurtenisService.deleteGebeurtenis(id);

        return ResponseEntity.noContent().build();
    }
}