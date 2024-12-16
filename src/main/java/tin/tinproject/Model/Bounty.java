package tin.tinproject.Model;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Size;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Entity
@Table(name = "Bounties")
public class Bounty {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bountyID;

    @Column(nullable = false)
    @Size(min = 10, max = 150)
    private String description;

    @Digits(integer = 10, fraction = 0)
    private Double reward;

    @Digits(integer = 1, fraction = 0)
    private Integer status;

    @Column(nullable = false)
    @Size(min = 4, max = 20)
    private String difficulty;

    @ManyToOne(cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
    @JoinColumn(name = "Guild_guild_ID", nullable = false)
    private Guild guild;

    @OneToMany(mappedBy = "bounty", cascade = CascadeType.REMOVE, orphanRemoval = true)
    private List<BountyClaim> bountyClaims;
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

    public List<BountyClaim> getBountyClaims() {
        return bountyClaims;
    }

    public void setBountyClaims(List<BountyClaim> bountyClaims) {
        this.bountyClaims = bountyClaims;
    }
}
