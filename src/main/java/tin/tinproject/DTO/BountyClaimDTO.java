package tin.tinproject.DTO;

import java.util.Date;

public class BountyClaimDTO {

    private Long claimID;
    private Date claimDate;
    private Date finishDate;
    private Long playerID;
    private Long bountyID;

    public Long getPlayerID() {
        return playerID;
    }

    public void setPlayerID(Long playerID) {
        this.playerID = playerID;
    }

    public Long getBountyID() {
        return bountyID;
    }

    public void setBountyID(Long bountyID) {
        this.bountyID = bountyID;
    }

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
}