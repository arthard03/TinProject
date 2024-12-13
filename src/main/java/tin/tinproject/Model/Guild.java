package tin.tinproject.Model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "Guild")
public class Guild {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long guildID;

    private String name;

    private String description;

    private Integer members;

    @OneToMany(mappedBy = "guild",cascade = CascadeType.REMOVE,fetch = FetchType.EAGER, orphanRemoval = true)
    private List<Bounty> bounties;


    public Long getGuildID() {
        return guildID;
    }

    public void setGuildID(Long guildID) {
        this.guildID = guildID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getMembers() {
        return members;
    }

    public void setMembers(Integer members) {
        this.members = members;
    }

    public List<Bounty> getBounties() {
        return bounties;
    }

    public void setBounties(List<Bounty> bounties) {
        this.bounties = bounties;
    }
}