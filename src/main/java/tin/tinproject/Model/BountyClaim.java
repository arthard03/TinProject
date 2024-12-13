package tin.tinproject.Model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "Bounty_claim")
public class BountyClaim {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long claimID;

    private Date claimDate;

    private Date finishDate;

    @ManyToOne
    @JoinColumn(name = "Player_ID", nullable = false)
    private Player player;

    @ManyToOne
    @JoinColumn(name = "Bounteis_bounty_ID", nullable = false)
    private Bounty bounty;

    public Long getClaimID() {
        return claimID;
    }

    public void setClaimID(Long claimID) {
        this.claimID = claimID;
    }

    public Date getClaimDate() {
        return claimDate;
    }

    public void setClaimDate(Date claimDate) {
        this.claimDate = claimDate;
    }

    public Date getFinishDate() {
        return finishDate;
    }

    public void setFinishDate(Date finishDate) {
        this.finishDate = finishDate;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Bounty getBounty() {
        return bounty;
    }

    public void setBounty(Bounty bounty) {
        this.bounty = bounty;
    }
}