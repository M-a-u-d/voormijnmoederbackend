package eindopdracht.voormijnmoederwebapp.Controller;


import eindopdracht.voormijnmoederwebapp.Service.GebeurtenisService;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GebeurtenisController {

    private final GebeurtenisService gebeurtenisService;


    public GebeurtenisController(GebeurtenisService gebeurtenisService) {
        this.gebeurtenisService = gebeurtenisService;
    }
}
