package eindopdracht.voormijnmoederwebapp.Controller;

import eindopdracht.voormijnmoederwebapp.Service.GebeurtenisEnUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/geus")
public class GebeurtenisEnUserController {

    private final GebeurtenisEnUserService gebeurtenisEnUserService;

    @Autowired
    public GebeurtenisEnUserController(GebeurtenisEnUserService gebeurtenisEnUserService) {
        this.gebeurtenisEnUserService = gebeurtenisEnUserService;
    }

    @PostMapping("/{userUsername}/{gebeurtenisNaam}")
    public ResponseEntity<Object> addGebeurtenisEnUser(
            @PathVariable("userUsername") String userUsername,
            @PathVariable ("gebeurtenisNaam") String gebeurtenisNaam) {
                gebeurtenisEnUserService.addGebeurtenisEnUser(userUsername, gebeurtenisNaam);

        return ResponseEntity.noContent().build();
    }

}
