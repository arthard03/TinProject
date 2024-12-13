package tin.tinproject.Model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "Player")
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String clazz;

    private String speciality;

    private Integer persuasionLevel;

    @OneToMany(mappedBy = "player",cascade = CascadeType.REMOVE,fetch = FetchType.EAGER, orphanRemoval = true)
    private List<BountyClaim> bountyClaims;

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

    public String getClazz() {
        return clazz;
    }

    public void setClazz(String clazz) {
        this.clazz = clazz;
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    public Integer getPersuasionLevel() {
        return persuasionLevel;
    }

    public void setPersuasionLevel(Integer persuasionLevel) {
        this.persuasionLevel = persuasionLevel;
    }

    public List<BountyClaim> getBountyClaims() {
        return bountyClaims;
    }

    public void setBountyClaims(List<BountyClaim> bountyClaims) {
        this.bountyClaims = bountyClaims;
    }
}