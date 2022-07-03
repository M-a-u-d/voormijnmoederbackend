package eindopdracht.voormijnmoederwebapp.Entiteiten;

import javax.persistence.Column;
import java.io.Serializable;
import java.util.Objects;

public class GebeurtenisEnUserKey  implements Serializable {

    @Column (name = "user_username")
    private String userUsername;

    @Column(name = "gebeurtenis_naam")
    private String gebeurtenisNaam;

    public GebeurtenisEnUserKey() {

    }
    public GebeurtenisEnUserKey(String userUsername, String gebeurtenisNaam) {
        this.userUsername = userUsername;
        this.gebeurtenisNaam = gebeurtenisNaam;
    }

    public String getUserUsername() {
        return userUsername;
    }

    public void setUserUsername(String userUsername) {
        this.userUsername = userUsername;
    }

    public String getGebeurtenisNaam() {
        return gebeurtenisNaam;
    }

    public void setGebeurtenisNaam(String gebeurtenisNaam) {
        this.gebeurtenisNaam = gebeurtenisNaam;
    }

    @Override
    public boolean equals(Object o) {
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;
        GebeurtenisEnUserKey that = (GebeurtenisEnUserKey) o;
        return userUsername.equals(that.userUsername)&& gebeurtenisNaam.equals(that.gebeurtenisNaam);
    }

    @Override
    public int hashCode() {return Objects.hash(userUsername, gebeurtenisNaam);
    }
}
