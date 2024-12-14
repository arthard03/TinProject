package tin.tinproject.DTO;

import java.util.List;

public class PlayerWithBountyClaimsDTO {
    private Long id;
    private String name;
    private String clazz;
    private String speciality;
    private Integer persuasionLevel;
    private List<BountyClaimDTO> bountyClaims;

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

    public List<BountyClaimDTO> getBountyClaims() {
        return bountyClaims;
    }

    public void setBountyClaims(List<BountyClaimDTO> bountyClaims) {
        this.bountyClaims = bountyClaims;
    }
}
