package eindopdracht.voormijnmoederwebapp.Service;

import eindopdracht.voormijnmoederwebapp.Dto.UserDto;
import eindopdracht.voormijnmoederwebapp.Entiteiten.Authority;
import eindopdracht.voormijnmoederwebapp.Entiteiten.FileUploadResponse;
import eindopdracht.voormijnmoederwebapp.Entiteiten.User;
import eindopdracht.voormijnmoederwebapp.Exeptions.UsernameNotFoundException;
import eindopdracht.voormijnmoederwebapp.Repositories.FileUploadRepository;
import eindopdracht.voormijnmoederwebapp.Repositories.UserRepository;
import eindopdracht.voormijnmoederwebapp.Utils.RandomStringGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;


@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    public UserService(UserRepository userRepository, UserRepository repository, FileUploadRepository uploadRepository)
    {
        this.userRepository = userRepository;
        this.repository = repository;
        this.uploadRepository = uploadRepository;
    }

    private final UserRepository repository;
    private final FileUploadRepository uploadRepository;


    public List<UserDto> getUsers() {
        List<UserDto> collection = new ArrayList<>();
        List<User> list = userRepository.findAll();
        for (User user : list) {
            collection.add(fromUser(user));
        }
        return collection;
    }

    public UserDto getUser(String username) {
        UserDto dto = new UserDto();
        Optional<User> user = userRepository.findById(username);
        if (user.isPresent()){
            dto = fromUser(user.get());
        }else {
            throw new UsernameNotFoundException(username);
        }
        return dto;
    }

    public boolean userExists(String username) {
        return userRepository.existsById(username);
    }

    public String createUser(UserDto userDto) {
        userDto.setPassword(passwordEncoder.encode(userDto.getPassword()));
        String randomString = RandomStringGenerator.generateAlphaNumeric(20);
        userDto.setApikey(randomString);
        User newUser = userRepository.save(toUser(userDto));
        return newUser.getUsername();
    }

    public void deleteUser(String username) {
        userRepository.deleteById(username);
    }

    public void updateUser(String username, UserDto newUser) {
        if (!userRepository.existsById(username)) throw new UsernameNotFoundException();
        User user = userRepository.findById(username).get();
        user.setPassword(newUser.getPassword());
        userRepository.save(user);
    }

    public Set<Authority> getAuthorities(String username) {
        if (!userRepository.existsById(username)) throw new UsernameNotFoundException(username);
        User user = userRepository.findById(username).get();
        UserDto userDto = fromUser(user);
        return userDto.getAuthorities();
    }

    public void addAuthority(String username, String authority) {

        if (!userRepository.existsById(username)) throw new UsernameNotFoundException(username);
        User user = userRepository.findById(username).get();
        user.addAuthority(new Authority(username, authority));
        userRepository.save(user);
    }

    public void removeAuthority(String username, String authority) {
        if (!userRepository.existsById(username)) throw new UsernameNotFoundException(username);
        User user = userRepository.findById(username).get();
        Authority authorityToRemove = user.getAuthorities().stream().filter((a) -> a.getAuthority().equalsIgnoreCase(authority)).findAny().get();
        user.removeAuthority(authorityToRemove);
        userRepository.save(user);
    }

    public void assignPhotoToUser(String name, String username) {

        Optional<User> optionalUser = repository.findById(username);
        Optional<FileUploadResponse> fileUploadResponse = uploadRepository.findByFileName(name);

        if (optionalUser.isPresent() && fileUploadResponse.isPresent()) {
            FileUploadResponse photo = fileUploadResponse.get();
            User user = optionalUser.get();
            user.setFile(photo);
            repository.save(user);
        }

    }
    public static UserDto fromUser(User user){

        var dto = new UserDto();

        dto.username = user.getUsername();
        dto.id = user.getId();
        dto.password = user.getPassword();
        dto.enabled = user.isEnabled();
        dto.apikey = user.getApikey();
        dto.email = user.getEmail();
        dto.hobbies = user.getHobbies();
        dto.huisdier = user.getHuisdier();
        dto.authorities = user.getAuthorities();

        return dto;
    }

    public User toUser(UserDto userDto) {

        var user = new User();

        user.setUsername(userDto.getUsername());
        user.setId(userDto.getId());
        user.setPassword(userDto.getPassword());
        user.setEnabled(userDto.getEnabled());
        user.setApikey(userDto.getApikey());
        user.setEmail(userDto.getEmail());
        user.setHobbies(userDto.getHobbies());
        user.setHuisdier(userDto.getHuisdier());

        return user;
    }

}
