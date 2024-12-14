package tin.tinproject.DTO;

import java.util.List;

public class BountryRelationDTO {
    private Long bountyID;
    private String description;
    private Double reward;
    private Integer status;
    private String difficulty;
    private List<BountyClaimDTO> bountyClaims;
private  List<GuildDTO>guildDTOS;

    public Long getBountyID() {
        return bountyID;
    }

    public void setBountyID(Long bountyID) {
        this.bountyID = bountyID;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getReward() {
        return reward;
    }

    public void setReward(Double reward) {
        this.reward = reward;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    public List<BountyClaimDTO> getBountyClaims() {
        return bountyClaims;
    }

    public void setBountyClaims(List<BountyClaimDTO> bountyClaims) {
        this.bountyClaims = bountyClaims;
    }

    public List<GuildDTO> getGuildDTOS() {
        return guildDTOS;
    }

    public void setGuildDTOS(List<GuildDTO> guildDTOS) {
        this.guildDTOS = guildDTOS;
    }
}
