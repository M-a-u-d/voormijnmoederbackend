package eindopdracht.voormijnmoederwebapp.Dto;

public class UserInputDto {

    public String username;
    public Long id;
    public String password;
    public Boolean enabled;
    public String apikey;
    public String email;

    public UserInputDto() {
    }

    public UserInputDto(String username, Long id, String password, Boolean enabled, String apikey, String email) {
        this.username = username;
        this.id = id;
        this.password = password;
        this.enabled = enabled;
        this.apikey = apikey;
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public String getApikey() {
        return apikey;
    }

    public void setApikey(String apikey) {
        this.apikey = apikey;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
