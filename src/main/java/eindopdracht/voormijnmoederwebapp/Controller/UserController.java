package eindopdracht.voormijnmoederwebapp.Controller;

import eindopdracht.voormijnmoederwebapp.Dto.GebeurtenisDto;
import eindopdracht.voormijnmoederwebapp.Dto.UserDto;
import eindopdracht.voormijnmoederwebapp.Entiteiten.FileUploadResponse;
import eindopdracht.voormijnmoederwebapp.Exeptions.BadRequestException;
import eindopdracht.voormijnmoederwebapp.Service.GebeurtenisEnUserService;
import eindopdracht.voormijnmoederwebapp.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Collection;
import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping(value = "/users")
public class UserController {


    @Autowired
    private UserService userService;

    private final UserService service;
    private final PhotoController controller;
    private final GebeurtenisEnUserService gebeurtenisEnUserService;

    public UserController(UserService service, PhotoController controller,
                          GebeurtenisEnUserService gebeurtenisEnUserService) {
        this.service = service;
        this.controller = controller;
        this.gebeurtenisEnUserService = gebeurtenisEnUserService;
    }

    @GetMapping(value = "")
    public ResponseEntity<List<UserDto>> getUsers() {
        List<UserDto> userDtos = userService.getUsers();
        return ResponseEntity.ok().body(userDtos);
    }

    @GetMapping(value = "/{username}")
    public ResponseEntity<UserDto> getUser(
            @PathVariable("username") String username) {
        UserDto optionalUser = userService.getUser(username);

        return ResponseEntity.ok().body(optionalUser);
    }

    @PostMapping(value = "")
    public ResponseEntity<UserDto> createUser(
            @RequestBody UserDto dto) {
        String newUsername = userService.createUser(dto);
        userService.addAuthority(newUsername, "ROLE_USER");

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{username}")
                .buildAndExpand(newUsername).toUri();

        return ResponseEntity.created(location).build();
    }

    @PutMapping(value = "/{username}")
    public ResponseEntity<UserDto> updateKlant
            (@PathVariable("username") String username,
             @RequestBody UserDto dto) {
        userService.updateUser(username, dto);

        return ResponseEntity.noContent().build();
    }

    @DeleteMapping(value = "/{username}")
    public ResponseEntity<Object> deleteKlant
            (@PathVariable("username") String username) {
        userService.deleteUser(username);

        return ResponseEntity.noContent().build();
    }

    @GetMapping(value = "/{username}/authorities")
    public ResponseEntity<Object> getUserAuthorities
            (@PathVariable("username") String username) {

        return ResponseEntity.ok().body(userService.getAuthorities(username));
    }

    @PostMapping(value = "/{username}/authorities")
    public ResponseEntity<Object> addUserAuthority
            (@PathVariable("username") String username,
             @RequestBody Map<String, Object> fields) {
        try {
            String authorityName = (String) fields.get("authority");
            userService.addAuthority(username, authorityName);

        return ResponseEntity.noContent().build();

        } catch (Exception ex) {
            throw new BadRequestException();
        }
    }

    @DeleteMapping(value = "/{username}/authorities/{authority}")
    public ResponseEntity<Object> deleteUserAuthority
            (@PathVariable("username") String username,
             @PathVariable("authority") String authority) {
        userService.removeAuthority(username, authority);

        return ResponseEntity.noContent().build();
    }

    @PostMapping("/{username}/photo")
    public void assignPhotoToUser(@PathVariable("username") String username,
                                  @RequestBody MultipartFile file) {

        FileUploadResponse photo = controller.singleFileUpload(file);

        service.assignPhotoToUser(photo.getFileName(), username);

    }

    @GetMapping("/gebeurtenissen/{userusername}")
    public Collection<GebeurtenisDto> getGebeurtenisEnUserId(@PathVariable("userusername") String userUsername){
        return gebeurtenisEnUserService.getGebeurtenisEnUsersByUserUsername(userUsername);
    }

//    @GetMapping("/{username}/photo")
//    public void ResponsEntity<Object>getPhoto
//            (@PathVariable("username") String username,
//             @RequestBody MultipartFile file) {
//
//        return ResponseEntity.ok().body(userService.getPhoto(username));
//
//    }
}