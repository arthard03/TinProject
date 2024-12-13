package tin.tinproject.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "Bounties")
public class Bounty {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bountyID;

    private String description;

    private Double reward;

    private Integer status;

    private String difficulty;

    @ManyToOne
    @JoinColumn(name = "Guild_guild_ID", nullable = false)
    private Guild guild;

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

    public Guild getGuild() {
        return guild;
    }

    public void setGuild(Guild guild) {
        this.guild = guild;
    }
}