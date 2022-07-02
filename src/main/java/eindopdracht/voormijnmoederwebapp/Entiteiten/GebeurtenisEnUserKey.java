package eindopdracht.voormijnmoederwebapp.Entiteiten;

import javax.persistence.Column;
import java.io.Serializable;
import java.util.Objects;

public class GebeurtenisEnUserKey  implements Serializable {

    @Column (name = "user_name")
    private String userName;

    @Column(name = "gebeurtenis_naam")
    private String gebeurtenisNaam;

    public GebeurtenisEnUserKey() {
    }
    public GebeurtenisEnUserKey(String userName, String gebeurtenisNaam) {
        this.userName = userName;
        this.gebeurtenisNaam = gebeurtenisNaam;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
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
        return userName.equals(that.userName)&& gebeurtenisNaam.equals(that.gebeurtenisNaam);
    }

    @Override
    public int hashCode() {return Objects.hash(userName, gebeurtenisNaam);
    }
}
