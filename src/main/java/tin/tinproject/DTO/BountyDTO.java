package tin.tinproject.DTO;

public class BountyDTO {

    private Long bountyID;
    private String description;
    private Double reward;
    private Integer status;
    private String difficulty;
    private Long guildID;

    public Long getGuildID() {
        return guildID;
    }

    public void setGuildID(Long guildID) {
        this.guildID = guildID;
    }

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
}