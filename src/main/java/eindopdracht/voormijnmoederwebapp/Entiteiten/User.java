package eindopdracht.voormijnmoederwebapp.Entiteiten;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "users")
public class User {

    @Id
    private String username;

    @Column
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String name;

    @Column
    private Integer Phone;

    @Column
    private String birthdate;


    @Column
    private String password;

    @Column
    private String email;

    @Column(nullable = false)
    private boolean enabled = true;

    @Column
    private String apikey;

    @OneToMany(
            targetEntity = Authority.class,
            mappedBy = "username",
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.EAGER)

    private Set<Authority> authorities = new HashSet<>();

    @OneToMany( mappedBy = "user")
    @JsonIgnore
    private List<Gebeurtenis> gebeurtenissen;


//    @ManyToMany(fetch = FetchType.EAGER)
//    @JoinTable(
//            name = "users_roles",
//            joinColumns = @JoinColumn(name = "user_username"),
//            inverseJoinColumns = @JoinColumn(name = "role_id")
//    )
//    private Set<Role> roles = new HashSet<>();
//
//    public void addRole(Role role) {
//        this.roles.add(role);
//    }

    public User() {
    }
    public User(String username, Long id, String name, Integer phone, String birthdate, String password, String email, boolean enabled, String apikey, Set<Authority> authorities) {
        this.username = username;
        this.id = id;
        this.name = name;
        Phone = phone;
        this.birthdate = birthdate;
        this.password = password;
        this.email = email;
        this.enabled = enabled;
        this.apikey = apikey;
        this.authorities = authorities;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPhone() {
        return Phone;
    }

    public void setPhone(Integer phone) {
        Phone = phone;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public String getApikey() {
        return apikey;
    }

    public void setApikey(String apikey) {
        this.apikey = apikey;
    }

    public Set<Authority> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(Set<Authority> authorities) {
        this.authorities = authorities;
    }

//    public Set<Role> getRoles() {
//        return roles;
//    }
//
//    public void setRoles(Set<Role> roles) {
//        this.roles = roles;
//    }

    public void addAuthority(Authority authority) {
        this.authorities.add(authority);
    }
    public void removeAuthority(Authority authority) {
        this.authorities.remove(authority);
    }
}

