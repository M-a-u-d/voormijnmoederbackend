package eindopdracht.voormijnmoederwebapp.Controller;

import eindopdracht.voormijnmoederwebapp.Service.GebeurtenisEnUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/geus")
public class GebeurtenisEnUserController {

    private final GebeurtenisEnUserService gebeurtenisEnUserService;

    @Autowired
    public GebeurtenisEnUserController(GebeurtenisEnUserService gebeurtenisEnUserService) {
        this.gebeurtenisEnUserService = gebeurtenisEnUserService;
    }

    @PostMapping("/{userName}/{gebeurtenisNaam}")
    public  void addGebeurtenisEnUser(
            @PathVariable("userName") String userName,
            @PathVariable ("gebeurtenisNaam") String gebeurtenisNaam) {
                gebeurtenisEnUserService.addGebeurtenisEnUser(userName, gebeurtenisNaam);
    }

}
