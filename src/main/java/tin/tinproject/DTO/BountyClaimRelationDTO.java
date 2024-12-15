package tin.tinproject.DTO;

import java.util.Date;
import java.util.List;

public class BountyClaimRelationDTO {
    private Long claimID;
    private Date claimDate;
    private Date finishDate;
    private List<BountyDTO> bountyDTOS;
    private  List<PlayerDTO> playerDTOS;

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

    public List<BountyDTO> getBountyDTOS() {
        return bountyDTOS;
    }

    public void setBountyDTOS(List<BountyDTO> bountyDTOS) {
        this.bountyDTOS = bountyDTOS;
    }

    public List<PlayerDTO> getPlayerDTOS() {
        return playerDTOS;
    }

    public void setPlayerDTOS(List<PlayerDTO> playerDTOS) {
        this.playerDTOS = playerDTOS;
    }
}
