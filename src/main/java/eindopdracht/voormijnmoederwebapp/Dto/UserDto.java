package eindopdracht.voormijnmoederwebapp.Dto;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import eindopdracht.voormijnmoederwebapp.Entiteiten.Authority;
import eindopdracht.voormijnmoederwebapp.Entiteiten.FileUploadResponse;

import javax.persistence.OneToOne;
import java.util.Set;

public class UserDto {

    public String username;
    public Long id;
    public String password;
    public Boolean enabled;
    public String apikey;
    public String email;

    @JsonSerialize
    public Set<Authority> authorities;

    @OneToOne
    FileUploadResponse file;

    private GebeurtenisDto gebeurtenisDto;

    public String getUsername() {
        return username;
    }

    public Long getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public String getApikey() {
        return apikey;
    }

    public String getEmail() {
        return email;
    }

    public Set<Authority> getAuthorities() {
        return authorities;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public void setApikey(String apikey) {
        this.apikey = apikey;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAuthorities(Set<Authority> authorities) {
        this.authorities = authorities;
    }

    public GebeurtenisDto getGebeurtenisDto() {
        return gebeurtenisDto;
    }

    public void setGebeurtenisDto(GebeurtenisDto gebeurtenisDto) {
        this.gebeurtenisDto = gebeurtenisDto;
    }

    public FileUploadResponse getFile() {
        return file;
    }

    public void setFile(FileUploadResponse file) {
        this.file = file;
    }
}

