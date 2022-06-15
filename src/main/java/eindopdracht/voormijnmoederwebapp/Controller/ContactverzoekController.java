package eindopdracht.voormijnmoederwebapp.Controller;


import eindopdracht.voormijnmoederwebapp.Service.ContactVerzoekService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
public class ContactverzoekController {

    private final ContactVerzoekService contactVerzoekService;

    @Autowired
    public ContactverzoekController(ContactVerzoekService contactVerzoekService) {
        this.contactVerzoekService = contactVerzoekService;
    }
}
